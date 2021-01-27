package com.sikiedu.traveltheworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sikiedu.traveltheworld.domain.Reservation;
import com.sikiedu.traveltheworld.repository.ReservationRepository;

@RestController
public class ReservationController {
	@Autowired
	private ReservationRepository reservationRepository;

    @RequestMapping("/reservation/create/{resvType}/{custID}/{resvKey}")
    public ModelAndView create(@PathVariable("resvType") String resvType,@PathVariable("custID") Long custID,@PathVariable("resvKey") Long resvKey) {
        Reservation reservation = new Reservation();
        reservation.setResvType(resvType);
        reservation.setCustID(custID);
        reservation.setResvKey(resvKey);
    	reservationRepository.save(reservation);
        return new ModelAndView("redirect:/reservation/search/"+custID);
    }
	@RequestMapping("/reservation/search/{id}")
	public ModelAndView search(@PathVariable("id") Long id, Model model)
	{	
		List<Reservation> reservationList = reservationRepository.findByCustID(id);
		System.out.println(reservationList);
        model.addAttribute("reservationList", reservationList);
        return new ModelAndView("/myReservation.html", "reservationtModel", model);
	}
	@RequestMapping("/reservation/search")
	public ModelAndView search()
	{	
		return new ModelAndView("/search.html");
	}

}