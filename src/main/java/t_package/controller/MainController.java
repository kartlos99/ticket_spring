package t_package.controller;

import org.springframework.web.bind.annotation.*;
import t_package.model.Status;
import t_package.model.Ticket;
import t_package.model.User;
import t_package.repository.StatusRepository;
import t_package.repository.TicketRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class MainController {

    private TicketRepository ticketRepository;
    private StatusRepository statusRepository;

    public MainController(
            TicketRepository ticketRepository,
            StatusRepository statusRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping
    public List<Ticket> tickets() {
        return ticketRepository.findByActive(true);
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable("id") Ticket ticket) {
        return ticket;
    }

    @PostMapping
    public Object addTicket(
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam(name = "author_id") User author,
            @RequestParam(name = "worker_id") User worker
            ) {
//        System.out.println(body);
        Status status = statusRepository.findByCode("open");

        Ticket ticket = new Ticket(title, body, true);
        ticket.setAuthor(author);
        ticket.setWorker(worker);
        ticket.setStatus(status);
        ticket.setStartDate(new Date());
        return ticketRepository.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(
            @RequestBody Ticket ticket
    ) {
        return ticketRepository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable("id") Ticket ticket) {
        ticket.setActive(false);
        ticketRepository.save(ticket);
    }


}
