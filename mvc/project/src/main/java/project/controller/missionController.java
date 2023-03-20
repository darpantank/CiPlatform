package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.model.mission;
import project.service.missionServiceInterface;

@Controller
public class missionController {
	@Autowired
	missionServiceInterface service;
	
	@RequestMapping("/home")
	public ModelAndView loadAllMission(@RequestParam("keyword") String keyword) {
		ModelAndView mav=new ModelAndView();
		List<mission> mylist=this.service.loadAllMissionOnSearch(keyword);
		mav.addObject("missions",mylist);
		System.out.println(mylist);
		mav.setViewName("home");
		return mav;
	}
}
