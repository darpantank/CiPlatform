package com.ciplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciplatform.dto.UserAdminPanelDto;
import com.ciplatform.dto.UserProfileDto;
import com.ciplatform.service.AdminServiceInterface;
import com.ciplatform.service.UserServiceInterface;

@Controller
public class AdminController {
	@Autowired
	AdminServiceInterface service;
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public String showAdminPanel() {
		return "userpageadmin";
	}
	@RequestMapping(value = "fetchusers",method = RequestMethod.GET)
	public @ResponseBody List<UserAdminPanelDto> fetchUsers(){
		return this.service.fetchUsers();
	}
}
