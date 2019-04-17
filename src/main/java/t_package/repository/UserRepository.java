package t_package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t_package.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
