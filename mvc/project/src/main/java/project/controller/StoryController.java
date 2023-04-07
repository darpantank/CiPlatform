package project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.dto.StoryDto;
import project.model.Story;
import project.model.User;
import project.service.StoryServiceIntereface;

@Controller
public class StoryController {
	
	@Autowired
	StoryServiceIntereface service;
	@RequestMapping(path = "story")
	public String storyPage() {
		return "story";
	}
	@RequestMapping(path = "/createstory")
	public String addEditStoryPage(HttpServletRequest request,Model m) {
		User user=(User)request.getSession().getAttribute("user");
		m.addAttribute("missions",this.service.findMissionOfUsers(user));
		return "addstory";
	}
	@PostMapping(value = "/savestory")
	public @ResponseBody String saveStoryOfUser(StoryDto storyDto,HttpSession session,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		this.service.saveStoryOfUser(storyDto,user,session);
		return "Thanks";
	}
	@RequestMapping(value = "/getdraftstory" , method = RequestMethod.GET)
	public @ResponseBody Story getDraftedStory(@RequestParam("missionId") String missionId,HttpServletRequest request){
		Story story=new Story();
		User user=(User)request.getSession().getAttribute("user");
		if(user.getEmail()==null||user.getEmail()=="") {
			return story;
		}
		story=this.service.getDraftMission(missionId,user);
		return story;
	}
}
