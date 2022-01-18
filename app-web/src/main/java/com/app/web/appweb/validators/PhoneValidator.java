package com.app.web.appweb.validators;

public class PhoneValidator {
	public Boolean PhoneIsValid (String phone) {
		//Testing if the phone number is valid

		boolean hasBadCharacters = false;
		for(int i = 0; i < phone.length(); i++){
			if(phone.charAt(i) > '9' & phone.charAt(i) < '0'){
				hasBadCharacters = true;
			}
		}

		if(!hasBadCharacters){
			//Test if the phone has less than the minimum amount of characters
			if(phone.length() >= 9){
				return true;
			}else return false;
		}else return false;
	}

	public String ChangePhoneToCountryCode (String phone) {
		String phoneWithCountryCode = "+370";
		for(int i = phone.length() - 8; i < phone.length(); i++){
			phoneWithCountryCode += phone.charAt(i);
		}
		return phoneWithCountryCode;
	}
}
