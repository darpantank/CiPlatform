package project.service;

import project.model.password_reset;
import project.model.user;

public interface userServiceInterface {
	public boolean storeUserData(user user1);
	public user validateUserDetail(String email, String password);
	public boolean validateEmailId(String email);
	public boolean forgotPasswordImpl(String email);
	public password_reset validateToken(String Token);
	public boolean deleteToken(password_reset prst);
	public password_reset isValidToken(String token);
	public boolean isPasswordUpdated(String Token,String password);
	public password_reset getEmailFromToken(String token);
	public boolean isTokenExpire(password_reset prst);
}
