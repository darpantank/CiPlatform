package project.service;

import javax.servlet.http.HttpSession;

import project.dto.UserProfileDto;
import project.model.PasswordReset;
import project.model.User;

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
}
