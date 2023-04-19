package project.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.dto.ChangePasswordDto;
import project.dto.ContactUsDto;
import project.dto.GoalBasedTimesheetIncomingDto;
import project.dto.TimeBasedTimesheetIncomingDto;
import project.dto.TimeSheetDto;
import project.dto.UserProfileDto;
import project.exception.UserNotFoundException;
import project.model.Mission;
import project.model.PasswordReset;
import project.model.User;
import project.service.MissionServiceInterface;
import project.service.StoryServiceIntereface;
import project.service.UserServiceInterface;

@Controller
public class HomeController {
	@Autowired
	UserServiceInterface service;
	@Autowired
	MissionServiceInterface mservice;
	@Autowired
	StoryServiceIntereface storyService;
	final static int LOGOUT_TIME = 900; /* User Session Is Validate For 15 Minutes */
	@RequestMapping("/registration")
	public String registrationView() {
		return "registration";
	}
	@RequestMapping("/login")
	public String loginView() {
		return "login";
	}
	@RequestMapping("/forgotpassword")
	public String forgotPasswordView() {
		return "forgotpassword";
	}
	@RequestMapping("/privacy")
	public String privacyPageView() {
		return "privacy";
	}
	@RequestMapping("/logout")
	public String LogoutUser(HttpSession request,Model m) {
	    request.removeAttribute("user");
	    request.invalidate();
	    m.addAttribute("message","logoutsuccess");
		return "login";
	}

	/*
	 * @RequestMapping("/home") public String homeView() { return "home"; }
	 */
	@RequestMapping("/timesheet")
	public String timesheetPageView(Model m,HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		m.addAttribute("missions",this.storyService.findMissionOfUsers(user));
		return "timesheet";
	}
	@RequestMapping(value="/resetmypassword", method=RequestMethod.POST)
	public ModelAndView resetmypassword(@RequestParam("token") String token,@RequestParam("password") String password,@RequestParam("confirm_password") String cnfpassword) {
		ModelAndView mav=new ModelAndView();
		if(password!=""&&cnfpassword!=null&&token!=null) {
			
//			check Given Token is Present in Our DB or not 
			PasswordReset prst=this.service.isValidToken(token);
			if(prst.isValidObject()) {
				if(this.service.isPasswordUpdated(token, password)) {
					if(this.service.deleteToken(prst)) {
						mav.addObject("message","passwordupdate");
						mav.setViewName("login");
						
					}
					else {
						mav.addObject("message","invalidtoken");
						mav.setViewName("forgotpassword");
					}
				}
				else {
					mav.addObject("message","invalidtoken");
					mav.setViewName("forgotpassword");
				}
			}
			else {
				mav.addObject("message","invalidtoken");
				mav.setViewName("forgotpassword");
			}
			
		}
		else {
			mav.setViewName("failed");
			mav.addObject("message","Enter Password and Confirmpassword same");
		}
		return mav;
	}
	@RequestMapping(value = "/saveuser",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user,Model m) {
		System.out.println(user);
		if(user.getEmail()==""||user.getFirst_name()==""||user.getLast_name()==""||user.getPhone_number()==""||user.getPassword()=="") {
			m.addAttribute("message","All Field Of Form Is Compulsary");
			return "failed";
		}
		if(!this.service.validateEmailId(user.getEmail())&&!this.service.validateMobileNo(user.getPhone_number())){
			if(this.service.storeUserData(user)) {	
				System.out.println("User Saved successfully...");
				m.addAttribute("message","registrationsuccess");
				return "login";
			}
			else {
				m.addAttribute("message","Data Not Inserted Due to Technical Fault");
				return "failed";
			}
			}
		else {
			m.addAttribute("message","registrationfailed");
			return "registration";
		}
		
	}
	@RequestMapping(value = "/validateuser",method = RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		User myuser=this.service.validateUserDetail(email, password);
		if(myuser.getEmail()!=null) {
			mav.setViewName("home");
			mav.addObject("message","Successfully login");
			HttpSession session=request.getSession(true);
			session.setMaxInactiveInterval(LOGOUT_TIME);
			session.setAttribute("user",myuser);
			}
		else {
			mav.setViewName("login");
			mav.addObject("message","wrongpassword");
		}		
		return mav;
	}
	@RequestMapping(value="/forgotPasswordTokenGenerate" , method = RequestMethod.POST)
	public ModelAndView forgotPasswordTokenGen(@RequestParam("email") String email) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forgotpassword");
		if(this.service.validateEmailId(email)) {
			if(this.service.forgotPasswordImpl(email)) {
				mav.addObject("message","tokensent");
			}
			else {
				mav.addObject("message","someerror");
			}
		}
		else {
			mav.addObject("message","usernotfound");
		}
		return mav;
	}
	@RequestMapping(path="/validatetoken/{token}")
	public ModelAndView validateToken(@PathVariable("token") String Token) {
		ModelAndView mav=new ModelAndView();
		PasswordReset prst=this.service.validateToken(Token);
		if(prst.getEmail()!=null||prst.getToken()!=null||prst.getCreated_at()!=null) {
			
//			Check that Token Is Not Expired before Changing Password Opeartion 
			
			if(!this.service.isTokenExpire(prst))
			{
				mav.addObject("token",Token);
				mav.setViewName("resetpassword");
			}
			else {
				mav.addObject("message","tokenexpire");
				mav.setViewName("forgotpassword");
			}
			
		}
		else {
			mav.addObject("message","invalidtoken");
			mav.setViewName("forgotpassword");
		}
		return mav;
	}
	@RequestMapping(value = "/profile")
	public String editProfilePageView(Model m,HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		m.addAttribute("user",user);
		return "editprofile";
	}
	@RequestMapping(value = "/editprofile" ,method = RequestMethod.POST)
	public @ResponseBody boolean updateProfile(UserProfileDto userProfileDto,HttpServletRequest request,HttpSession session) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		return this.service.editUserProfile(userProfileDto,user,session);
		}
	@RequestMapping(value = "/changeMyPassword", method = RequestMethod.POST)
	public @ResponseBody String changeMyPassword(ChangePasswordDto changePasswordDto,HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		if(!user.getPassword().equals(changePasswordDto.getOldPassWord())) {
			return "oldpassnotmatched";
		}
		if(changePasswordDto.getConfirmNewPassWord().length()>7&&changePasswordDto.getConfirmNewPassWord().equals(changePasswordDto.getNewPassWord())) {
			if(this.service.changeMyPassword(changePasswordDto,user)) {
				return "success";
			}else {
				return "servererror";
			}
		}
		else {
			return "passwordcriterianotmatched";
		}
	}
	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public @ResponseBody boolean contactUsPage(ContactUsDto contactUs,HttpServletRequest request) throws UserNotFoundException {
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		return this.service.contactUs(user,contactUs);
	}
	@RequestMapping(value = "/loadtimesheets",method=RequestMethod.GET)
	public @ResponseBody List<TimeSheetDto> loadTimesheets(HttpServletRequest request) throws UserNotFoundException{
		User user= (User)request.getSession().getAttribute("user");
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}
		return this.service.loadTimesheetsOfUser(user);
	}
	@RequestMapping(value="savetimebasedsheet" ,method =RequestMethod.POST )
	public @ResponseBody boolean saveTimeSheetTimeBasedMission(TimeBasedTimesheetIncomingDto timesheet,HttpServletRequest request) throws UserNotFoundException {
		System.out.println(timesheet);
		User user= (User)request.getSession().getAttribute("user");
		Mission mission=new Mission();
		mission=this.mservice.fetchMissionById(timesheet.getMissionId());
		if(user==null||user.getUser_id()==0||user.getEmail()=="") {
			throw new UserNotFoundException();
		}		
		return this.service.saveTimeSheetForTimeBasedMission(user,mission,timesheet);
	}
	@RequestMapping(value="savegoalbasedsheet" ,method =RequestMethod.POST )
	public @ResponseBody boolean saveTimeSheetGoalBasedMission(GoalBasedTimesheetIncomingDto timesheet) {
		System.out.println(timesheet);
		return true;
	}
//	@ExceptionHandler(value = ConstraintViolationException.class)
//    public String sqlExceptionHanler(Model m) {       
//        m.addAttribute("message", "Some thing went wrong");
//        return "failed";
//    }
//	@ExceptionHandler(value = Exception.class)
//    public String centralExceptionHanler(Model m) {       
//        m.addAttribute("message", "Data Handling Error");
//        return "failed";
//    }
}
