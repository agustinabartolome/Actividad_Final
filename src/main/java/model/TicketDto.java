package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long idTicket;

    private FlightDto flight;

    private CompanyDto company;

    private String nombrePasajero;

    private String emailPasajero;

    private String pasaportePasajero;

    public void setFlight(FlightDto flightDetails) {

    }

    public void setNombrePasajero() {
        this.nombrePasajero = nombrePasajero;
    }

    public void setEmailPasajero() {
        this.emailPasajero = emailPasajero;
    }

    public void setPasaportePasajero() {
        this.pasaportePasajero = pasaportePasajero;
    }

    public void setCompanyDto() {

    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }
}
