package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

@AllArgsConstructor

public class FlightDto {

    private Long id;

    private String origen;

    private String destino;

    private String fechaHoraSalida;

    private String fechaHoraLlegada;

    private double convertedPrecio;

    private String frecuencia;


}
