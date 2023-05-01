package com.ciplatform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import com.ciplatform.model.User;

public class AdminInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user= (User)request.getSession().getAttribute("admin");
		if(user==null) {
			request.setAttribute("message", "nonadmin");
			response.sendRedirect(request.getContextPath());
			return false;
		}
		else {			
			return true;
		}
	}
	

}
