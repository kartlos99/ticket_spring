package t_package.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import t_package.model.Status;
import t_package.model.User;
import t_package.repository.StatusRepository;
import t_package.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin
public class AController {
    private UserRepository userRepository;
    private StatusRepository statusRepository;

    public AController(
            UserRepository userRepository,
            StatusRepository statusRepository
    ) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findByActive(true);
    }

    @GetMapping("/states")
    public List<Status> getallStatus() {
        return statusRepository.findAll();
    }
}
