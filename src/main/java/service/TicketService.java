package service;

import com.netflix.discovery.converters.Auto;
import model.FlightDto;
import model.Ticket;
import model.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    /*
    private final List<Ticket> tickets = new ArrayList();

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Ticket addTicket(Ticket addedTicket){

        tickets.add(addedTicket);

        return addedTicket;
    }

    */

    @Autowired
    private TicketRepository ticketRepository;

    private final List<TicketDto> tickets = new ArrayList();

    public List<TicketDto> getAllTickets() {
        return tickets;
    }

    /*
    public TicketDto addTicket(TicketDto ticketDto) {
        return tickets.addTicket(ticketDto);
    }
    */
    public TicketDto addTicket(TicketDto ticketDto) {
        return ticketRepository.save(ticketDto);
    }

    public TicketDto updateTicket(Long idTicket, TicketDto ticketDto) {
        return ticketRepository.update(idTicket, ticketDto);
    }

    public TicketDto findTicketById(Long idTicket) {

        return ticketRepository.findById(idTicket);
    }

    public void deleteTicket(Long idTicket) {

        ticketRepository.delete(idTicket);
    }

    public TicketDto generateTicket(FlightDto flightDetails) {
        TicketDto ticket = new TicketDto();

        ticket.setFlight(flightDetails);
        ticket.setNombrePasajero();
        ticket.setEmailPasajero();
        ticket.setPasaportePasajero();
        ticket.setCompanyDto();

        return ticket;
    }
}
