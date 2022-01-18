package com.app.web.appweb.service;

import com.app.web.appweb.validators.EmailValidator;
import com.app.web.appweb.validators.PasswordChecker;
import com.app.web.appweb.validators.PhoneValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private EmailValidator emailVal;
    private PasswordChecker passVal;
    private PhoneValidator phoneVal;

    public boolean isEmailValid(String email){
        emailVal = new EmailValidator();
        return emailVal.EmailIsValid(email);
    }
    public boolean isPassValid(String pass){
        passVal = new PasswordChecker();
        return passVal.PasswordIsValid(pass);
    }
    public boolean isPhoneValid(String phone){
        phoneVal = new PhoneValidator();
        return phoneVal.PhoneIsValid(phone);
    }
}
