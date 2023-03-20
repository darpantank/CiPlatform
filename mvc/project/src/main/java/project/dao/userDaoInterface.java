package project.dao;

import java.util.List;

import project.model.password_reset;
import project.model.user;

public interface userDaoInterface {
	public boolean createUser(user user1);
	public String storeResetPassToken(password_reset prst);
	public List<password_reset> validateToken(String Token);
	public user validateUserDetails(String email,String pass);
	public user validateEmail(String email);
	public password_reset validateTokenForReset(String token);
	public boolean deleteToken(password_reset prst);
	public boolean saveUpdatedPassword(String email,String password);
}
