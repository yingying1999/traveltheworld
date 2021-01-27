package com.sikiedu.traveltheworld.repository;

import java.util.List;

import com.sikiedu.traveltheworld.domain.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long>{
	
	List<Flight> findByFromCityAndArivCity(String fromCity,String arivCity);			
}
