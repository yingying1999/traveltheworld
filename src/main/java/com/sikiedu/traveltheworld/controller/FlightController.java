package com.sikiedu.traveltheworld.controller;

import java.util.List;

import com.sikiedu.traveltheworld.domain.Flight;
import com.sikiedu.traveltheworld.domain.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sikiedu.traveltheworld.repository.FlightRepository;

@RestController
public class FlightController {

	//spring
	@Autowired
	private FlightRepository flightRepository;

	//根据城市查询航班
	@RequestMapping("/flight/searchbycity")
	public ModelAndView searchbycity(Flight flight, Model model)
	{	
		List<Flight> flightList = flightRepository.findByFromCityAndArivCity(flight.getFromCity(), flight.getArivCity());
		System.out.println(flightList);
        model.addAttribute("flightList", flightList);
        return new ModelAndView("/searchResults.html", "flightModel", model);
	}

	//admin部分：
	//管理航班，会查询所有航班
	@RequestMapping("/flight/manage")
	public ModelAndView search(Model model)
	{	
		List<Flight> flightList = (List<Flight>) flightRepository.findAll();
		System.out.println(flightList);
        model.addAttribute("flightList", flightList);
        return new ModelAndView("/flightManage.html", "flightModel", model);
	}
	//进入修改航班的页面
	@RequestMapping("/flight/startUpdate/{id}")
	public ModelAndView startUpdate(@PathVariable("id") Long id, Model model)
	{	
		Flight flight = (flightRepository.findById(id)).get();
		System.out.println(flight);
        model.addAttribute("flight", flight);
		return new ModelAndView("/edit-flight.html","flightModel",model);
	}
	//提交修改航班
	@RequestMapping("/flight/update")
	public ModelAndView update(Flight flight)
	{	
		flightRepository.save(flight);
		return new ModelAndView("redirect:/flight/manage");
	}

	//删除航班
	@RequestMapping("/flight/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id)
	{	
		flightRepository.deleteById(id);
		return new ModelAndView("redirect:/flight/manage");
	}
	//进入新增航班的页面
	@RequestMapping("/flight/startCreate")
	public ModelAndView startCreate()
	{	
		return new ModelAndView("/create-flight.html");
	}
	//提交新增航班
	@RequestMapping("/flight/create")
	public ModelAndView create(Flight flight)
	{	
		flightRepository.save(flight);
		return new ModelAndView("redirect:/flight/manage");
	}
}