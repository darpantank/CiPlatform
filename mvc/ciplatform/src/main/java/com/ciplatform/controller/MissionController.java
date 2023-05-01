package com.ciplatform.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciplatform.dto.FetchMissionByUserDto;
import com.ciplatform.dto.FilterObjectDto;
import com.ciplatform.dto.MissionCommentDto;
import com.ciplatform.dto.MissionVolunteerIncomingDto;
import com.ciplatform.dto.MissionVolunteersOutgoingDto;
import com.ciplatform.dto.PostCommentDto;
import com.ciplatform.exception.UserNotFoundException;
import com.ciplatform.model.City;
import com.ciplatform.model.Comment;
import com.ciplatform.model.Country;
import com.ciplatform.model.FavoriteMission;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.User;
import com.ciplatform.service.MissionServiceInterface;
import com.ciplatform.service.UserServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MissionController {
	@Autowired
	MissionServiceInterface service;	
	@Autowired
	UserServiceInterface userService;
	@RequestMapping(value="/searchMission",method = RequestMethod.POST)
	public @ResponseBody Map<Long,List<FetchMissionByUserDto>> loadAllMissionOnSearch(@RequestParam("FilterObject") String filters,HttpServletRequest request){
		ObjectMapper mp=new ObjectMapper();
		FilterObjectDto filterObject=new FilterObjectDto();
		User user=new User();
		user=(User)request.getSession().getAttribute("user");
		try{			
			filterObject=mp.readValue(filters, FilterObjectDto.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this.service.loadAllMissionOnSearch(filterObject,user);
	}
	@RequestMapping(value="/loadListOfCountry")
	public @ResponseBody String loadCountryList() {
		List<Country> mylist=this.service.loadListOfCountry();
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
		List<City> mylist=this.service.loadCityOfCountry(countryId);
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
		List<MissionTheme> mylist=this.service.loadAllThemes();
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
		List<Skill> mylist=this.service.loadAllSkills();
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
	public String loadMissionPage(Model m,@RequestParam("mission_id") int mission_id,HttpServletRequest request) throws UserNotFoundException{
		Mission Mission=new Mission();
		User Myuser= (User)request.getSession().getAttribute("user");
		if(Myuser==null||Myuser.getUserId()==0||Myuser.getEmail()=="") {
			throw new UserNotFoundException();
		}
		Mission=this.service.fetchMissionById(mission_id);
		m.addAttribute("documents",this.service.getDocumentOfMission(Mission));
		m.addAttribute("isFavourited",this.service.favouriteMission(Myuser, Mission));
		m.addAttribute("ratingOfUser",this.service.ratingOfParticularUser(Myuser, Mission));
		m.addAttribute("media",this.service.getMediaofMission(Mission));
		m.addAttribute("isAlreadyApplied",this.service.isAppliedForMission(Mission, Myuser));
		int goalAchieved=0;
		goalAchieved=this.service.calculateGoalOfMission(Mission);
		m.addAttribute("goalAchieved",goalAchieved);
		Double rating=0D;
		Long ratingByPeople=0L;
		Map<Double,Long> map=this.service.ratingOfMission(Mission);
		if(map!=null||!map.isEmpty()) {			
			ratingByPeople=(Long)map.get(map.keySet().toArray()[0]);
			rating=(Double)map.keySet().toArray()[0];
		}
		m.addAttribute("rating",rating);
		m.addAttribute("ratingByPeople",ratingByPeople);
		m.addAttribute("Mission",Mission);
		return "mission";
	}
	@RequestMapping(value="/addToMyFavourite" ,method = RequestMethod.POST)
	public @ResponseBody boolean addMyFavouriteMission(@RequestParam("missionId") String missionId,HttpServletRequest request) throws UserNotFoundException {
		int mission=Integer.parseInt(missionId);
		Mission myMission=this.service.fetchMissionById(mission);
		User Myuser= (User)request.getSession().getAttribute("user");
		if(Myuser==null||Myuser.getUserId()==0||Myuser.getEmail()=="") {
			throw new UserNotFoundException();
		}
		if(Myuser.getEmail()!=null) {			
			FavoriteMission myATF=new FavoriteMission(myMission,Myuser);
			return this.service.addToFavourite(myATF);
		}
		return false;
	}
	@RequestMapping(value = "/getRelatedMission" , method = RequestMethod.GET)
	public @ResponseBody List<FetchMissionByUserDto> relatedMission(@RequestParam("missionId") String missionId,HttpServletRequest request) {
		int mission=Integer.parseInt(missionId);
		User Myuser= (User)request.getSession().getAttribute("user");
		Mission myMission=this.service.fetchMissionById(mission);
		return this.service.getRelatedMission(myMission,Myuser);
	}
	@RequestMapping(value = "/ratingToMission",method = RequestMethod.POST)
	public @ResponseBody Boolean ratingToMission(@RequestParam("missionId") String missionId,@RequestParam("rating") String rating,HttpServletRequest request) throws UserNotFoundException {
		System.out.print(missionId);
		int mission=Integer.parseInt(missionId);
		int ratingCon=Integer.parseInt(rating);
		User Myuser= (User)request.getSession().getAttribute("user");
		if(Myuser==null||Myuser.getUserId()==0||Myuser.getEmail()=="") {
			throw new UserNotFoundException();
		}
		Mission myMission=this.service.fetchMissionById(mission);
		return this.service.ratingToMission(Myuser,myMission,ratingCon);
	}
	
	@RequestMapping(value= "/recommandtocoworker" , method = RequestMethod.POST)
	public @ResponseBody String recommandToCoWorker(@RequestParam("missionId") String missionId,@RequestParam("email_id") String email,HttpServletRequest request) throws UserNotFoundException {
		int mission=Integer.parseInt(missionId);
		Mission myMission=this.service.fetchMissionById(mission);
		User SendFromUser= (User)request.getSession().getAttribute("user");
		User SendToUser= this.userService.getUserFromEmail(email);
		if(SendToUser.getEmail()==null||SendToUser.getEmail()=="") {
			return "emailnotfound";
		}
		else if(SendFromUser.getEmail().equals(SendToUser.getEmail())) {
			return "bothusersame";
		}
		else if(SendFromUser==null||SendFromUser.getEmail()==null||SendFromUser.getEmail()=="") {
			return "sessionnotfound";
		}
		else {
			//Store Data Of Recommandation
			this.service.recommandToCoWorker(myMission,SendFromUser,SendToUser);
			return "success";
		}
	}
	@RequestMapping(value="/getCommentsOfMission" ,method = RequestMethod.GET)
	public @ResponseBody List<MissionCommentDto> loadCommentsOfMission(@RequestParam("missionId") String missionId){
		int mission=Integer.parseInt(missionId);
		Mission myMission=this.service.fetchMissionById(mission);
		return this.service.loadCommentsOfMission(myMission);
	}
	@PostMapping(value="/postcomment")
	@ResponseBody
	public boolean postCommentByUser(PostCommentDto postCommentDto,HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		this.service.postComment(postCommentDto, user);
		return true;
	}
	@RequestMapping(value = "/getTotalVolunteerOfMission")
	@ResponseBody
	public long totalVolunteersInMission(@RequestParam("missionId") String missionId) {
		int mission_id=Integer.parseInt(missionId);
		Mission mission=this.service.fetchMissionById(mission_id);
		return this.service.fetchTotalVolunteersInMisson(mission);
	}
	@RequestMapping(value = "getVolunteers")
	@ResponseBody
	public List<MissionVolunteersOutgoingDto> getVolunteersOfMission(MissionVolunteerIncomingDto missionVolunteerIncomingDto) {
		return this.service.getVolunteersOfMission(missionVolunteerIncomingDto);
	}
	@RequestMapping(value = "/applyForMission" ,method = RequestMethod.POST)
	@ResponseBody
	public boolean applyForMission(@RequestParam("missionId") int missionId,HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		Mission mission=this.service.fetchMissionById(missionId);
		if(user==null||user.getUserId()==0||mission==null||mission.getMissionId()==0) {
			return false;
		}
		else {
			return this.service.applyForMission(mission,user);			
		}
	}
	@RequestMapping(value = "/homeadmin", method = RequestMethod.GET)
	public String homeViewFromAdmin(HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("admin");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		return "home";
	}
}
