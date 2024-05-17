package controller;

import model.FlightDto;
import model.Ticket;
import model.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.FlightClient;
import service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightClient flightClient;

    @GetMapping("")
    public List<TicketDto> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/flights")
    public List <FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @PostMapping("/add")
    public TicketDto addTicket(@RequestBody TicketDto ticketDto){

        System.out.print(ticketDto.toString());

        return ticketService.addTicket(ticketDto);
    }

    @PutMapping("/{idTicket}")
    public TicketDto updateTicket(@PathVariable Long idTicket, @RequestParam TicketDto ticketDto){
        return ticketService.updateTicket(idTicket, ticketDto);
    }

    @DeleteMapping("/delete/{idTicket}")
    public void deleteTicket(@PathVariable Long idTicket){
        ticketService.deleteTicket(idTicket);
    }

    @GetMapping("/{idTicket}")
    public void findTicketById(@PathVariable Long idTicket){
        ticketService.findTicketById(idTicket);
    }

    @GetMapping("/generate/{id}")
    public TicketDto generateTicket(@PathVariable Long id) {

        FlightDto flightDetails = flightClient.getFlightDetails(id);

        TicketDto ticket = ticketService.generateTicket(flightDetails);

        return ticket;
    }

    /*
    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightClient flightClient;

    @GetMapping("")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/flights")
    public List <FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket){

        System.out.print(ticket.toString());

        return ticketService.addTicket(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestParam Ticket ticket){
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }

    @GetMapping("/{id}")
    public void findTicketById(@PathVariable Long id){
        ticketService.findTicketById(id);
    }

    */



}
