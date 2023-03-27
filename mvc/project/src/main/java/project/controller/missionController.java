package project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
import project.service.missionServiceInterface;

@Controller
public class missionController {
	@Autowired
	missionServiceInterface service;	
	@RequestMapping(value="/searchMission",method = RequestMethod.POST)
	public @ResponseBody String loadAllMissionOnSearch(@RequestParam("Filters") String filters) {
		String Output="";
		System.out.println("Enter in Search Mission"+filters);
		ObjectMapper obj=new ObjectMapper();
		try {
			FilterObject filter=obj.readValue(filters, FilterObject.class);
			try {
				Output=obj.writeValueAsString(this.service.loadAllMissionOnSearch(filter));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}catch(JsonProcessingException e){
			e.printStackTrace();
		}
		System.out.println("output:"+ Output);
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
	@RequestMapping(value="/loadListOfCity",method = RequestMethod.POST)
	public @ResponseBody String loadCountryList(@RequestParam("countryId") int countryId) {
		List<city> mylist=this.service.loadCityOfCountry(countryId);
		System.out.println(mylist);
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
		System.out.println(mylist);
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
		System.out.println(mylist);
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
