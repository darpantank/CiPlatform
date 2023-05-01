package com.ciplatform.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ciplatform.dto.ChangePasswordDto;
import com.ciplatform.dto.CmsHomePageDto;
import com.ciplatform.dto.ContactUsDto;
import com.ciplatform.dto.GoalBasedTimesheetIncomingDto;
import com.ciplatform.dto.TimeBasedTimesheetIncomingDto;
import com.ciplatform.dto.TimeSheetDto;
import com.ciplatform.dto.UserProfileDto;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.Mission;
import com.ciplatform.model.PasswordReset;
import com.ciplatform.model.User;

public interface UserServiceInterface {
	public boolean storeUserData(User user1);
	public User validateUserDetail(String email, String password);
	public boolean validateEmailId(String email);
	public boolean forgotPasswordImpl(String email);
	public PasswordReset validateToken(String Token);
	public boolean deleteToken(PasswordReset prst);
	public PasswordReset isValidToken(String token);
	public boolean isPasswordUpdated(String Token,String password);
	public PasswordReset getEmailFromToken(String token);
	public boolean isTokenExpire(PasswordReset prst);
	public User getUserFromEmail(String email);
	public boolean editUserProfile(UserProfileDto userProfileDto, User user,HttpSession session);
	public boolean changeMyPassword(ChangePasswordDto changePasswordDto, User user);
	public boolean contactUs(User user, ContactUsDto contactUs);
	public boolean validateMobileNo(String mobileNumber);
	public List<TimeSheetDto> loadTimesheetsOfUser(User user);
	public boolean saveTimeSheetForTimeBasedMission(User user, Mission mission,
			TimeBasedTimesheetIncomingDto timesheet);
	public boolean saveTimeSheetForGoalBasedMission(User user, Mission mission,
			GoalBasedTimesheetIncomingDto timesheet);
	public boolean deleteMytimeSheet(int user_id, int timesheetId);
	public List<CmsHomePageDto> fetchCms();
	public CmsPage findCmsBySlug(String slug);
	public List<CmsPage> fetchAllCms();
}
