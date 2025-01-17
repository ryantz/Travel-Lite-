package com.project.travellite.service;

import com.project.travellite.dto.AddFlightRequest;
import com.project.travellite.model.Flights;
import com.project.travellite.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {
    @Autowired
    private FlightRepository flightRepo;

    public List<Flights> getAllFlights(){
        return flightRepo.findAll();
    }
    public Optional<Flights> getFlightById(Long id){
        return flightRepo.findById(id);
    }
    public List<Optional<Flights>> getFlightByCompany(String company){
        return flightRepo.findByCompany(company);
    }

    public List<Optional<Flights>> getFlightByDepart(LocalDateTime departure){
        return flightRepo.findByDepartureTime(departure);
    }

    public List<Optional<Flights>> getFlightByDestination(String destination){
        return flightRepo.findByDestination(destination);
    }

    public List<Optional<Flights>> getFlightByFlightNumber(String flightNumber){
        return flightRepo.findByFlightNumber(flightNumber);
    }

    public Flights addFlight(AddFlightRequest flightReq){
        Flights flights = new Flights();
        flights.setFlightNumber(flightReq.getFlightNumber());
        flights.setCompany(flightReq.getCompany());
        flights.setOrigin(flightReq.getOrigin());
        flights.setDestination(flightReq.getDestination());
        flights.setPrice(flightReq.getPrice());
        flights.setType(flightReq.getType());
        flights.setSeatCount(flightReq.getSeatCount());
        flights.setArrivalTime(flightReq.getArrivalTime());
        flights.setDepartureTime(flightReq.getDepartureTime());
        flightRepo.save(flights);

        return flights;
    }

    public List<String> getCompanyNames(){
        return flightRepo.findCompanies();
    }

    public List<Flights> findFlightsByLandingPage(LocalDate departureDate, String origin, String destination){
       return flightRepo.findFlightsFromLandingPage(departureDate, origin, destination);
    }
}

