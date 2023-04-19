package project.dao;

import java.util.List;

import project.model.City;
import project.model.ContactUs;
import project.model.Country;
import project.model.PasswordReset;
import project.model.Skill;
import project.model.TimeSheet;
import project.model.User;

public interface UserDaoInterface {
	public boolean createUser(User user1);
	public String storeResetPassToken(PasswordReset prst);
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
	
}
