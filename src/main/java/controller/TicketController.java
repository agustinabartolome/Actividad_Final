package controller;

import exceptions.ResourceNotFoundException;
import model.FlightDto;
import model.Ticket;
import model.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.FlightClient;
import service.TicketService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/flights/{id}")
    public List <FlightDto> finVueloById(@PathVariable Long id)
    {
        return flightClient.findFlightDtoById(id);
    }

    /*
    @PostMapping("/add")
    public TicketDto addTicket(@RequestBody TicketDto ticketDto){

        System.out.print(ticketDto.toString());

        return ticketService.addTicket(ticketDto);
    }
    */

    @PutMapping("/update")
    public TicketDto updateTicket(@PathVariable Long idTicket, @RequestParam TicketDto ticket){

        return ticketService.updateTicket(idTicket, ticket);
    }

    @DeleteMapping("/delete/{idTicket}")
    public String deleteTicket(@PathVariable Long idTicket){

        try {
            ticketService.deleteTicket(idTicket);
            return "El ticket " + idTicket + " se eliminó correctamente";
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
            return "No se encontró el ticket";
        }
    }

    @GetMapping("/{idTicket}")
    public Optional <Ticket> getTicketById(@PathVariable Long idTicket){
        return ticketService.getTicketById(idTicket);
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

    @PutMapping("/{idTicket}")
    public Ticket updateTicket(@PathVariable Long idTicket, @RequestParam Ticket ticket){
        return ticketService.updateTicket(idTicket, ticket);
    }

    @DeleteMapping("/delete/{idTicket}")
    public void deleteTicket(@PathVariable Long idTicket){
        ticketService.deleteTicket(idTicket);
    }

    @GetMapping("/{idTicket}")
    public void findTicketById(@PathVariable Long idTicket){
        ticketService.findTicketById(idTicket);
    }

    */



}
