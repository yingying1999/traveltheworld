package com.sikiedu.traveltheworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sikiedu.traveltheworld.domain.Flight;
import com.sikiedu.traveltheworld.domain.Reservation;
import com.sikiedu.traveltheworld.repository.FlightRepository;
import com.sikiedu.traveltheworld.repository.ReservationRepository;

@RestController
public class ReservationController {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private FlightRepository flightRepository;

	//新增预订
    @RequestMapping("/reservation/create/{resvType}/{custID}/{resvKey}")
    public ModelAndView create(@PathVariable("resvType") String resvType,@PathVariable("custID") Long custID,@PathVariable("resvKey") Long resvKey) {
    	System.out.println(resvType);
    	if(resvType.equals("flight")) {
        	System.out.println(resvType);
        	Flight flight = (flightRepository.findById(resvKey)).get();
        	flight.setNumAvail(flight.getNumAvail()-1  );
        	flightRepository.save(flight);
        }
        Reservation reservation = new Reservation();
        reservation.setResvType(resvType);
        reservation.setCustID(custID);
        reservation.setResvKey(resvKey);
    	reservationRepository.save(reservation);
        return new ModelAndView("redirect:/reservation/search/"+custID);
    }
    //查询用户的预订
	@RequestMapping("/reservation/search/{custID}")
	public ModelAndView search(@PathVariable("custID") Long custID, Model model)
	{	
		List<Reservation> reservationList = reservationRepository.findByCustID(custID);
		System.out.println(reservationList);
        model.addAttribute("reservationList", reservationList);
        return new ModelAndView("/myReservation.html", "reservationtModel", model);
	}
	//进入开始预订页面
	@RequestMapping("/reservation/start")
	public ModelAndView search()
	{	
		return new ModelAndView("/startReservation.html");
	}

}