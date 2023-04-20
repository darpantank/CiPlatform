package com.ciplatform.dto;

public class ChangePasswordDto {
	private String oldPassWord;
	private String newPassWord;
	private String confirmNewPassWord;
	public String getOldPassWord() {
		return oldPassWord;
	}
	public void setOldPassWord(String oldPassWord) {
		this.oldPassWord = oldPassWord;
	}
	public String getNewPassWord() {
		return newPassWord;
	}
	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}
	public String getConfirmNewPassWord() {
		return confirmNewPassWord;
	}
	public void setConfirmNewPassWord(String confirmNewPassWord) {
		this.confirmNewPassWord = confirmNewPassWord;
	}
	@Override
	public String toString() {
		return "ChangePasswordDto [oldPassWord=" + oldPassWord + ", newPassWord=" + newPassWord
				+ ", confirmNewPassWord=" + confirmNewPassWord + "]";
	}
	
}
