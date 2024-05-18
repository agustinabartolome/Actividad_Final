package repository;


import model.Ticket;
import model.TicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findById(Long idTicket);

    TicketDto update(Long idTicket, TicketDto ticketDto);

    List<TicketDto> findAllTickets();

    /*
    TicketDto save(TicketDto ticket);

    TicketDto findById(Long idTicket);

    TicketDto add(TicketDto ticket);

    TicketDto update (Long idTicket, TicketDto ticket);

    void delete (Long idTicket);

    List<TicketDto> findAll();
*/

}
