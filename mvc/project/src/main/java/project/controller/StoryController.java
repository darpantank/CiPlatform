package project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.dto.StoryDto;
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
	@ResponseBody
	public String saveStoryOfUser(StoryDto storyDto) {
		System.out.println(storyDto);
		return "Thanks";
	}
	
	@RequestMapping(path = "/demo")
	public String demoPage() {
		return "demo";
	}
}
