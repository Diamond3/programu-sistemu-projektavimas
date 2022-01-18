package com.app.web.appweb.validators;

public class EmailValidator {
	public Boolean EmailIsValid (String email) {

		// Tests if the email contains the symbol @. This takes care of the second test
		if(email.contains("@")){

			//Test if the email has no invalid symbols. This takes care of the third test
			//This is a very inefficient way without using Regexes or StringUtils to find if there is another @ in the email :/
			String dummy = "";
			for(int i = 0; i < email.length(); i++){
				if(email.charAt(i) == '@'){
					continue;
				}
				else dummy += email.charAt(i);
			}
			if(dummy.contains("@")){
				return false;
			}
			//Few variables needed to check the email. Local part is -TEST-@email.com and domain part is test@-EMAIL.COM-
			String localPart = "";
			String domainPart = "";

			//Getting localPart
			for(int i = 0; i < email.length(); i++){
				if(email.charAt(i) != '@'){
					localPart += email.charAt(i);
				}
				else break;
			}

			//Getting domainPart
			boolean foundAt = false;
			for(int i = 0; i < email.length(); i++){
				if(foundAt){
					domainPart += email.charAt(i);
				}
				if(email.charAt(i) == '@'){
					foundAt = true;
				}
			}
			//This if covers few of the requirements, requirements taken from https://mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/ 2. Email Regex – Strict Validation.
			if(email.charAt(0) == '.' | email.contains("..") | domainPart.charAt(0) == '.' | domainPart.charAt(domainPart.length()-1) == '.' | localPart.charAt(0) == '.' | localPart.charAt(localPart.length() -1) == '.' | email.contains("!")){
				return false;
			}else{
				//Checking for few requirements for the domainPart. This takes care of the first test
				if(!domainPart.contains(".")){
					return false;
				}
				else{
					//Testing if the domain is correct
					//The For statement bellow extracts the TLD part of the domain
					String tldPart = "";
					for(int i = domainPart.length(); i > 0; i--){
						if(domainPart.charAt(i-1) != '.') {
							tldPart += domainPart.charAt(i-1);
						}else break;
					}

					if(domainPart.length() > 63 | domainPart.length() < 1 | domainPart.charAt(0) == '-' | domainPart.charAt(domainPart.length() - 1) == '-' | tldPart.length() > 6 | tldPart.length() < 2){
						return false;
					}
					else return	true;
				}
			}
		}
		else return false;
	}
}
