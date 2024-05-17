package service;

import model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "flight-server")
public interface FlightClient {

    @GetMapping("/flights")
    List<FlightDto> getAllFlights();

    @GetMapping("flights/{id}")
    List<FlightDto> findFlightDtoById(@PathVariable ("id") Long id);


    FlightDto getFlightDetails(Long flightId);
}
