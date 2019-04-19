package t_package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t_package.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByActive(Boolean active);
//    List<Ticket> findByBodyContainingOrTitleContaining(String body, String title);

    @Query(value = "select * from ticket t where (t.title like %:title% or t.body like %:body%) and t.active = true ", nativeQuery = true)
    List<Ticket> getSearched(
            @Param("title") String title,
            @Param("body") String body
    );
}
