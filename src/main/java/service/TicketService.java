package service;

import exceptions.ResourceNotFoundException;
import model.FlightDto;
import model.Ticket;
import model.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
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

    public List<TicketDto> getAllTickets() {

        return ticketRepository.findAllTickets();
    }

    public void addTicket(Ticket ticketDto) {
         ticketRepository.save(ticketDto);

    }

    public TicketDto updateTicket(Long idTicket, TicketDto ticketDto) {
        return ticketRepository.update(idTicket, ticketDto);
    }

    public Optional<Ticket> getTicketById(Long idTicket) {

        Optional<Ticket> optionalTicket = ticketRepository.findById(idTicket);
        if ( optionalTicket.isPresent()){
            return Optional.of(optionalTicket.get()); } else {
            new ResourceNotFoundException("No se pudo enciontrar el ticket con la identificacion " + idTicket);
        }

        return optionalTicket;
    }
/*
    public Optional<TicketDto> findById (Long IdTicket) {

        return ticketRepository.findById(IdTicket);
    }
*/
    public void deleteTicket(Long idTicket) throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(idTicket).orElseThrow(() ->
                new ResourceNotFoundException("No se encontró el vuelo con identificación " + idTicket));
        ticketRepository.deleteById(ticket.getIdTicket());
    }

    public TicketDto generateTicket(FlightDto flightDetails) {
        TicketDto ticket = new TicketDto();

        ticket.setFlight(flightDetails);
        //ticket.setNombrePasajero();
        //ticket.setEmailPasajero();
        //ticket.setPasaportePasajero();
        //ticket.setCompanyDto();

        return ticket;
    }

/*
    @Autowired
    TicketRepository ticketRepository

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Long idTicket){
        ticketRepository.deleteById(idTicket);
    }

 */
}
