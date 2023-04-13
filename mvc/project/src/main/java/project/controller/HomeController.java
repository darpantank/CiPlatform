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

import project.dto.UserProfileDto;
import project.model.Mission;
import project.model.PasswordReset;
import project.model.User;
import project.service.MissionServiceInterface;
import project.service.UserServiceInterface;

@Controller
public class HomeController {
	@Autowired
	UserServiceInterface service;
	@Autowired
	MissionServiceInterface mservice;
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
	@RequestMapping(value="/resetmypassword", method=RequestMethod.POST)
	public ModelAndView resetmypassword(@RequestParam("token") String token,@RequestParam("password") String password,@RequestParam("confirm_password") String cnfpassword) {
		ModelAndView mav=new ModelAndView();
		if(password!=""&&cnfpassword!=null&&token!=null) {
			
//			check Given Token is Present in Our DB or not 
			PasswordReset prst=this.service.isValidToken(token);
			System.out.println("1 step");
			if(prst.isValidObject()) {
				System.out.println("2 step");
				System.out.println(password +" 2nd");
				if(this.service.isPasswordUpdated(token, password)) {
					System.out.println("3 step");
					System.out.println(password +" 3nd");
					if(this.service.deleteToken(prst)) {
						System.out.println("4 step");
						mav.setViewName("login");
						mav.addObject("message","passwordupdate");
						
					}
					else {
						mav.setViewName("forgotpassword");
						mav.addObject("message","invalidtoken");
					}
				}
				else {
					mav.setViewName("forgotpassword");
					mav.addObject("message","invalidtoken");
				}
			}
			else {
				mav.setViewName("forgotpassword");
				mav.addObject("message","invalidtoken");
			}
			
		}
		else {
			mav.setViewName("failed");
			mav.addObject("message","Atleast Enter Password and Confirmpassword same");
		}
		return mav;
	}
	@RequestMapping(value = "/saveuser",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user1,Model m) {
		
		System.out.println(user1);
		if(!this.service.validateEmailId(user1.getEmail())){
			if(this.service.storeUserData(user1)) {	
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
			System.out.println("User Not Valid...");
			m.addAttribute("message","user Aleready Found in Rcord");
			return "failed";
		}
		
	}
	@RequestMapping(value = "/validateuser",method = RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		User myuser=this.service.validateUserDetail(email, password);
		if(myuser.getEmail()!=null||myuser.getEmail()!="") {
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
		System.out.println(prst);
		if(prst.getEmail()!=null||prst.getToken()!=null||prst.getCreated_at()!=null) {
			
//			Check that Token Is Not Expired before Changing Password Opeartion 
			
			if(!this.service.isTokenExpire(prst))
			{
				mav.addObject("token",Token);
				mav.setViewName("resetpassword");
			}
			else {
				mav.addObject("message","token is now expired please regenerate mail and use it within 4 hour");
				mav.setViewName("failed");
			}
			
		}
		else {
			mav.addObject("message","invalidtoken");
			mav.setViewName("failed");
		}
		return mav;
	}
	@RequestMapping(value = "/profile")
	public String editProfilePageView(Model m,HttpServletRequest request) {
		User user= (User)request.getSession().getAttribute("user");
		m.addAttribute("user",user);
		return "editprofile";
	}
	@RequestMapping(value = "/editprofile" ,method = RequestMethod.POST)
	public @ResponseBody boolean updateProfile(UserProfileDto userProfileDto,HttpServletRequest request,HttpSession session) {
		User user= (User)request.getSession().getAttribute("user");
		return this.service.editUserProfile(userProfileDto,user,session);
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
