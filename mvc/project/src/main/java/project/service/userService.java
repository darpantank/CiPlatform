package project.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.UserDaoInterface;
import project.model.PasswordReset;
import project.model.User;

@Service
public class UserService implements UserServiceInterface {
	final static int TOKEN_VALID_TIME = 240;
	@Autowired
	UserDaoInterface daoOperation;

	public boolean storeUserData(User user1) {
		user1.setCreated_at(new Date());
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user1.getEmail());
		if (user1.getPassword().length() >= 8 && matcher.matches() && user1.getPhone_number().length() == 10
				&& user1.getFirst_name() != "" && user1.getLast_name() != "") {
			System.out.println("Pass Email Validation true");
			if (this.daoOperation.createUser(user1)) {
				return true;
			}
			System.out.println("dao not successfully done");
			return false;
		} else {
			System.out.println("Basic Validation Fiailed");
			return false;
		}
	}

	public User validateUserDetail(String email, String password) {
		return this.daoOperation.validateUserDetails(email, password);
	}

	public boolean validateEmailId(String email) {
		User myuser = this.daoOperation.validateEmail(email);
		if (myuser.getEmail() != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean forgotPasswordImpl(String email) {
		String Token = GenerateToken.generateNewToken();
		if (SendMail.send(email, Token)) {
			PasswordReset prst = new PasswordReset();
			prst.setEmail(email);
			prst.setToken(Token);
			prst.setCreated_at(new Date());
			if (this.daoOperation.storeResetPassToken(prst) != "") {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public PasswordReset validateToken(String Token) {
		PasswordReset prst = new PasswordReset();
		List<PasswordReset> prstlist = this.daoOperation.validateToken(Token);
		for (PasswordReset temp : prstlist) {
			prst = temp;
		}
		return prst;
	}

	public boolean deleteToken(PasswordReset prst) {
		return this.daoOperation.deleteToken(prst);
	}

	public PasswordReset isValidToken(String token) {
		return this.daoOperation.validateTokenForReset(token);
	}

	public boolean isPasswordUpdated(String Token, String password) {
		PasswordReset prst = isValidToken(Token);
		if (prst.isValidObject()) {
			String email = prst.getEmail();
			if (this.daoOperation.saveUpdatedPassword(email, password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public PasswordReset getEmailFromToken(String token) {
		return this.daoOperation.validateTokenForReset(token);
	}

	public boolean isTokenExpire(PasswordReset prst) {
		Date d1 = prst.getCreated_at();
		Date d2 = new Date();
		long diff = d2.getTime() - d1.getTime();
		TimeUnit time = TimeUnit.MINUTES;
		long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		System.out.println();
		if (diffrence > TOKEN_VALID_TIME) {
			System.out.println(diffrence);
			return true;
		} else {
			return false;
		}
	}
}
