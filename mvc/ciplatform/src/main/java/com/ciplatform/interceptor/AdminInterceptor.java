package com.ciplatform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ciplatform.exception.AdminNotFoundException;
import com.ciplatform.model.User;

public class AdminInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user= (User)request.getSession().getAttribute("admin");
		if(user==null) {
			request.setAttribute("message", "nonadmin");
			throw new AdminNotFoundException();
//			response.sendRedirect(request.getContextPath());
		}
		else {			
			return true;
		}
	}


	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); 
	}
	
	

}
