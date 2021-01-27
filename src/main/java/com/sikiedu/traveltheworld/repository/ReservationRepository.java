package com.sikiedu.traveltheworld.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sikiedu.traveltheworld.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
	List<Reservation> findByCustID(Long id);			
}
