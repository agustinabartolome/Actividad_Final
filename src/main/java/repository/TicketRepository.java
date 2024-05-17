package repository;


import model.Ticket;
import model.TicketDto;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public interface TicketRepository {

    TicketDto save(TicketDto ticket);

    TicketDto findById(Long idTicket);

    TicketDto add(TicketDto ticket);

    TicketDto update (Long idTicket, TicketDto ticket);

    void delete (Long idTicket);

    List<TicketDto> findAll();

}
