package com.ciplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciplatform.dto.UserAdminPanelDto;
import com.ciplatform.dto.UserProfileDto;

@Service
public interface AdminServiceInterface {
	List<UserAdminPanelDto> fetchUsers();
}
