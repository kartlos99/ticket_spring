package t_package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t_package.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByCode(String code);
}
