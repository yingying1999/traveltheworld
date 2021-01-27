package com.sikiedu.traveltheworld.controller;

import java.util.List;

import com.sikiedu.traveltheworld.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sikiedu.traveltheworld.repository.FlightRepository;

@RestController
public class FlightController {

	//spring
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("/flight/search")
	public ModelAndView search(Flight flight, Model model)
	{	
		List<Flight> flightList = flightRepository.findByFromCityAndArivCity(flight.getFromCity(), flight.getArivCity());
		System.out.println(flightList);
        model.addAttribute("flightList", flightList);
        return new ModelAndView("/searchResults.html", "flightModel", model);
	}


	
}