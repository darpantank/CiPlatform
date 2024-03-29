package com.ciplatform.dao;

import java.util.List;

import com.ciplatform.model.City;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.ContactUs;
import com.ciplatform.model.Country;
import com.ciplatform.model.Notifications;
import com.ciplatform.model.PasswordReset;
import com.ciplatform.model.Skill;
import com.ciplatform.model.TimeSheet;
import com.ciplatform.model.User;

public interface UserDaoInterface {
	public boolean createUser(User user1);
	public boolean storeResetPassToken(PasswordReset prst);
	public List<PasswordReset> validateToken(String Token);
	public User validateUserDetails(String email,String pass);
	public User validateEmail(String email);
	public PasswordReset validateTokenForReset(String token);
	public boolean deleteToken(PasswordReset prst);
	public boolean saveUpdatedPassword(String email,String password);
	public boolean updateUserDetails(User user);
	public City getCityObject(int id);
	public Skill getSkillObject(int id);
	public User fetchUserById(int user_id);
	public Country getCountryObject(int countryId);
	public void deleteAlereadyPresentSkills(int user_id);
	public boolean saveContsctUsDetail(ContactUs contactUs);
	public User validateMobileNumber(String mobileNumber);
	public List<TimeSheet> loadTimesheets(int userId);
	public boolean saveUpdateTimeSheet(TimeSheet sheet);
	public TimeSheet fetchTimeSheetFromId(int timesheetId, int user_id);
	public boolean deleteMyTimesheet(int userId, int timesheetId);
	public List<CmsPage> fetchCmsList();
	public CmsPage findCmsBySlug(String slug);
	public PasswordReset getAlreadyPresentTokenInDb(String email);
	public void saveNotifications(Notifications notifications);
	
}
