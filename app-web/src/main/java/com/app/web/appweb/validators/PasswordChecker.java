package com.app.web.appweb.validators;

public class PasswordChecker {
	public Boolean PasswordIsValid (String password) {
		//Test if the password has more than 5 characters
		if(password.length() > 5){

			//Test if the password contains an uppercase letter
			boolean hasAnUppercase = false;
			for(int i = 0; i < password.length(); i++){
				if(password.charAt(i) >= 'A' & password.charAt(i) <= 'Z'){
					hasAnUppercase = true;
				}
			}

			if(hasAnUppercase){

				//Test if the password has a special symbol
				//if(password.contains("!") | password.contains("?") | password.contains("@") | password.contains("#") | password.contains("$") | password.contains("%") | password.contains(""))
				boolean hasASpecialSymbol = false;
				for(int i = 0; i < password.length(); i++){
					if(password.charAt(i) >= '!' & password.charAt(i) <= '/'){
						hasASpecialSymbol = true;
					}
				}
				if(hasASpecialSymbol){
					return true;
				}else return false;

			}else return false;

		}else return false;
	}
}
