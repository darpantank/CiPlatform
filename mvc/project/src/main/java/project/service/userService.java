package project.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.userDaoInterface;
import project.model.password_reset;
import project.model.user;

@Service
public class userService implements userServiceInterface {
	final static int TOKEN_VALID_TIME = 240;
	@Autowired
	userDaoInterface daoOperation;

	public boolean storeUserData(user user1) {
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

	public user validateUserDetail(String email, String password) {
		return this.daoOperation.validateUserDetails(email, password);
	}

	public boolean validateEmailId(String email) {
		user myuser = this.daoOperation.validateEmail(email);
		if (myuser.getEmail() != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean forgotPasswordImpl(String email) {
		String Token = generateToken.generateNewToken();
		if (sendMail.send(email, Token)) {
			password_reset prst = new password_reset();
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

	public password_reset validateToken(String Token) {
		password_reset prst = new password_reset();
		List<password_reset> prstlist = this.daoOperation.validateToken(Token);
		for (password_reset temp : prstlist) {
			prst = temp;
		}
		return prst;
	}

	public boolean deleteToken(password_reset prst) {
		return this.daoOperation.deleteToken(prst);
	}

	public password_reset isValidToken(String token) {
		return this.daoOperation.validateTokenForReset(token);
	}

	public boolean isPasswordUpdated(String Token, String password) {
		password_reset prst = isValidToken(Token);
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

	public password_reset getEmailFromToken(String token) {
		return this.daoOperation.validateTokenForReset(token);
	}

	public boolean isTokenExpire(password_reset prst) {
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
