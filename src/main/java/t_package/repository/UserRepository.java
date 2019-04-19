package t_package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t_package.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByActive(Boolean active);
}
