package com.ciplatform.controller;

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

import com.ciplatform.dto.DraftStoryDto;
import com.ciplatform.dto.StoryCardDto;
import com.ciplatform.dto.StoryDto;
import com.ciplatform.exception.UserNotFoundException;
import com.ciplatform.model.Story;
import com.ciplatform.model.User;
import com.ciplatform.service.StoryServiceIntereface;
import com.ciplatform.service.UserServiceInterface;

@Controller
public class StoryController {
	
	@Autowired
	StoryServiceIntereface service;
	@Autowired
	UserServiceInterface userService;
	
	@RequestMapping(path = "story")
	public String storyPage() {
		return "story";
	}
	@RequestMapping(path = "/createstory")
	public String addEditStoryPage(HttpServletRequest request,Model m) throws UserNotFoundException {
		User user=(User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		m.addAttribute("missions",this.service.findMissionOfUsers(user));
		return "addstory";
	}
	@PostMapping(value = "/savestory")
	public @ResponseBody String saveStoryOfUser(StoryDto storyDto,HttpSession session,HttpServletRequest request) throws UserNotFoundException {
		User user=(User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		this.service.saveStoryOfUser(storyDto,user,session);
		return "success";
	}
	@RequestMapping(value = "/getdraftstory" , method = RequestMethod.GET)
	public @ResponseBody DraftStoryDto getDraftedStory(@RequestParam("missionId") String missionId,HttpServletRequest request) throws UserNotFoundException{
		DraftStoryDto story;
		User user=(User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		story=this.service.getDraftMission(missionId,user);
		if(user.getEmail()==null||user.getEmail()=="") {
			return story;
		}
		return story;
	}
	@RequestMapping(value="/getDetailStory",method=RequestMethod.GET)
	public String getDetailStory(@RequestParam("storyId") String storyId,HttpServletRequest request,Model m) throws UserNotFoundException {
		int id=Integer.parseInt(storyId);
		User user=(User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		Story story=this.service.getDetailStory(id);
		m.addAttribute("story",story);
		m.addAttribute("user",user);
		HttpSession s=request.getSession(false);
		String missionView="viewCount"+story.getStoryId();
		if(s!=null&&s.getAttribute(missionView)==null) {			
			if(user.getUserId()!=story.getUser().getUserId()&&story.getStoryId()!=0) {
//			Count View Of Page
				this.service.incrementPageViews(story.getStoryId());
				String temp="viewCount"+story.getStoryId();
				s.setAttribute(temp, "yes");
			}
		}
		return "detailstory";
	}
	@RequestMapping(value = "/loadCountOfStory" ,method=RequestMethod.GET)
	public @ResponseBody Long getStoryCount() {
		return this.service.getCountOfStory();
	}
	@RequestMapping(value = "/loadStoryByPageNo" , method = RequestMethod.GET)
	public @ResponseBody List<StoryCardDto> loadStoryByPageNo(@RequestParam("currentPage") int currentPage) {
		return this.service.getStoriesByPageNo(currentPage);
	}
	@RequestMapping(value = "/submitdraftstory", method = RequestMethod.GET)
	public @ResponseBody Boolean submitDraftStory(@RequestParam("storyId") int storyId,HttpServletRequest request) throws UserNotFoundException {
		User user=(User)request.getSession().getAttribute("user");
		if(user==null||user.getUserId()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		if(user.getEmail()==""||user.getEmail()==null||storyId==0) {
			return false;
		}
		this.service.submitDraftedStory(storyId,user.getUserId());
		return true;
	}
	@RequestMapping(value= "/recommandtocoworkerstory" , method = RequestMethod.POST)
	public @ResponseBody String recommandToCoWorkerStory(@RequestParam("storyId") int storyId,@RequestParam("emailId") String email,HttpServletRequest request) throws UserNotFoundException {
		User SendFromUser= (User)request.getSession().getAttribute("user");
		User SendToUser= this.userService.getUserFromEmail(email);
//		||SendFromUser.getUserId()==0||SendFromUser.getEmail()==""||SendToUser==null||SendToUser.getUserId()==0||SendToUser.getEmail()==""
		if(SendFromUser==null) {
			throw new UserNotFoundException();
		}
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
			this.service.recommandToCoWorkerStory(storyId,SendFromUser,SendToUser);
			return "success";
		}
	}
}
