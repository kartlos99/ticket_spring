package t_package;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import t_package.model.Status;
import t_package.model.User;
import t_package.repository.StatusRepository;
import t_package.repository.UserRepository;

@Component
@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create")
public class InitRunner implements CommandLineRunner {
    private StatusRepository statusRepository;
    private UserRepository userRepository;

    public InitRunner(StatusRepository statusRepository, UserRepository userRepository){
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Status open = new Status("ღია", "open", "#339999");
        statusRepository.save(open);
        Status recive = new Status("მიღებული", "recived", "#77aa99");
        statusRepository.save(recive);
        Status close = new Status("დახურული", "closed", "#33ff22");
        statusRepository.save(close);

        User user = new User();
        user.setName("name");
        user.setUsername("user");
        user.setPassword("user");
        user.setActive(true);
        userRepository.save(user);
        User admin = new User();
        admin.setName("adm_name");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setActive(true);
        userRepository.save(admin);

        System.out.println("statusebi da 2 useri chaiwera!!!");
    }
}