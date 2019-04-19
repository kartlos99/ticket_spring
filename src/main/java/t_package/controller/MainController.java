package t_package.controller;

import org.springframework.web.bind.annotation.*;
import t_package.model.Status;
import t_package.model.Ticket;
import t_package.repository.StatusRepository;
import t_package.repository.TicketRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
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

    @GetMapping("/filter")
    public List<Ticket> getTicketFilter(
            @RequestParam String filter
    ) {
        System.out.println(filter);
        return ticketRepository.getSearched(filter, filter);
//        return ticketRepository.findByBodyContainingOrTitleContaining(filter, filter).stream().filter(ticket -> ticket.getActive()).collect(Collectors.toList());
    }

    @PostMapping
    public Object addTicket(
            @RequestBody Ticket ticket
    ) {
//        System.out.println(body);
        Status status = statusRepository.findByCode("open");

        ticket.setStatus(status);
        ticket.setStartDate(new Date());
        ticket.setActive(true);
        return ticketRepository.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(
            @RequestBody Ticket ticket,
            @PathVariable("id") Ticket ticketInDB
    ) {
        // tu es bileti daxurulia ( 'closed' statusi ) ar varedaqtirebt
        if (ticketInDB.getStatus().getCode().equals("closed")) {
            System.out.println("closed Ticket non editable!");
            return ticketInDB;
        }

        // vafiqsirebt daxurvis dros
        if (ticket.getStatus().getCode().equals("closed")) {
            ticket.setEndDate(new Date());
        }
        return ticketRepository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable("id") Ticket ticket) {
        if (ticket != null) {
            ticket.setActive(false);
            ticketRepository.save(ticket);
        }
    }


}
