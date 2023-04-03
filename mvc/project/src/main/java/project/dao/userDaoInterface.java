package project.dao;

import java.util.List;

import project.model.PasswordReset;
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
}
