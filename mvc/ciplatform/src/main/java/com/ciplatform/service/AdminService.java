package com.ciplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciplatform.dao.AdminDaoInterface;
import com.ciplatform.dto.UserAdminPanelDto;
import com.ciplatform.dto.UserProfileDto;
import com.ciplatform.model.User;

@Service
public class AdminService implements AdminServiceInterface {
	@Autowired
	AdminDaoInterface daoOperation;

	public List<UserAdminPanelDto> fetchUsers() {
		List<User> users=this.daoOperation.fetchUsers();
		List<UserAdminPanelDto> profileDtos=new ArrayList<UserAdminPanelDto>();
		if(users.size()>0) {
			for(User user:users) {
				UserAdminPanelDto profileDto=new UserAdminPanelDto();
				profileDto.setFirstName(user.getFirst_name());
				profileDto.setLastName(user.getLast_name());
				profileDto.setEmail(user.getEmail());
				profileDto.setDepartment(user.getDepartment());
				profileDto.setEmployeeId(user.getEmployee_id());
				profileDto.setStatus(user.getStatus().toString());
				profileDto.setUserId(user.getUser_id());
				profileDtos.add(profileDto);
			}
		}
		System.out.println(profileDtos);
		return profileDtos;
	}

}
