package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

private Long idTicket;

private String nombrePasajero;

private String emailPasajero;

private String pasaportePasajero;


}
