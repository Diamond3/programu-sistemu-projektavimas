package com.alemal.validation;

public class PasswordChecker {
    static int passwordLength = 8;
    static boolean[] isValidSpecialChar = new boolean[127];
    static char[] validSpecialChars = " !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~".toCharArray();

    public PasswordChecker() {
        //adding all valid special chars to the boolean list
        for (char c: validSpecialChars) {
            isValidSpecialChar[c] = true;
        }
    }

    public boolean validate(String password) {
        if (password == null) return false; //is null
        if (password.length() < passwordLength) return false; //not long enough
        if (password.charAt(0) == 32) return false; //starts with space
        if (password.charAt(password.length() - 1) == 32) return false; //ends with space

        //---check if it has uppercase letter
        boolean hasUppercase = false;
        boolean hasSpecialCharacter = false;

        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (!hasUppercase && c > 64 && c < 91) hasUppercase = true;
            if (!hasSpecialCharacter && c < 127 && isValidSpecialChar[c]) hasSpecialCharacter = true;

            if (hasUppercase && hasSpecialCharacter) return true;
        }
        return false;
    }
}