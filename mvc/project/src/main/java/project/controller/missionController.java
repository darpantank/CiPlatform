package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.model.country;
import project.model.mission;
import project.service.missionServiceInterface;

@Controller
public class missionController {
	@Autowired
	missionServiceInterface service;
	
	@RequestMapping(value = "/loadAllMission")
	public @ResponseBody String loadAllMission(){
		List<mission> mylist=this.service.loadAllMission();
		ObjectMapper obj=new ObjectMapper();
		String Output="";
		try {
			Output=obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	
	@RequestMapping(value="/searchMission",method = RequestMethod.POST)
	public @ResponseBody String loadAllMissionOnSearch(@RequestParam("keyword") String keyword) {
		List<mission> mylist=this.service.loadAllMissionOnSearch(keyword);
		ObjectMapper obj=new ObjectMapper();
		String Output="";
		try {
			Output=obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	@RequestMapping(value="/loadListOfCountry")
	public @ResponseBody String loadCountryList() {
		List<country> mylist=this.service.loadListOfCountry();
		ObjectMapper obj=new ObjectMapper();
		String Output="";
		try {
			Output=obj.writeValueAsString(mylist);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Output;
	}
	
}
