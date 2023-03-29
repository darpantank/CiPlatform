package project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.dto.AddToFavourite;
import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
import project.model.user;
import project.service.missionServiceInterface;

@Controller
public class missionController {
	@Autowired
	missionServiceInterface service;	
	@RequestMapping(value="/searchMission",method = RequestMethod.POST)
	public @ResponseBody Map<Long,List<mission>> loadAllMissionOnSearch(@RequestParam("FilterObject") String filters){
		ObjectMapper mp=new ObjectMapper();
		FilterObject fo=new FilterObject();
		try{			
			System.out.println("Enter into Mission Controller");
			System.out.println(filters);
			fo=mp.readValue(filters, FilterObject.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this.service.loadAllMissionOnSearch(fo);
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
	@RequestMapping(value="/loadListOfCity",method = RequestMethod.POST)
	public @ResponseBody String loadCountryList(@RequestParam("countryId") int countryId) {
		List<city> mylist=this.service.loadCityOfCountry(countryId);
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
	@RequestMapping(value="/loadListOfTheme")
	public @ResponseBody String loadAllTheme() {
		List<mission_theme> mylist=this.service.loadAllThemes();
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
	@RequestMapping(value="/loadListOfSkill")
	public @ResponseBody String loadAllSkill() {
		List<skill> mylist=this.service.loadAllSkills();
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
	@RequestMapping(value="/getMyMission" ,method = RequestMethod.GET)
	public String loadMissionPage(Model m,HttpServletRequest request,@RequestParam("mission_id") int mission_id){
		mission Mission=new mission();
		Mission=this.service.fetchMissionById(mission_id);
		m.addAttribute("Mission",Mission);
		return "mission";
	}
	@RequestMapping(value="/addToMyFavourite" ,method = RequestMethod.POST)
	public @ResponseBody boolean addMyFavouriteMission(@RequestParam("missionId") String missionId,HttpServletRequest request) {
		int mission=Integer.parseInt(missionId);
		mission myMission=this.service.fetchMissionById(mission);
		user Myuser= (user)request.getSession().getAttribute("user");
		if(Myuser.getEmail()!=null) {			
			favorite_mission myATF=new favorite_mission(myMission,Myuser);
			return this.service.addToFavourite(myATF);
		}
		return false;
	}
	
}
