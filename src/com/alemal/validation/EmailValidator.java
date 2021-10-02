package com.alemal.validation;

public class EmailValidator {
    static int maxLengthOfUserName = 64;
    static int[] validChars = new int[127];

    static char[] validSpecialChars = ".!#$%&'*+-/=?^_`{|}~".toCharArray();
    static char[] validSpecialCharsInQuotes = " \"(),:;<>@[\\]".toCharArray();

    public EmailValidator(){
                                //0 - chars is not valid
        for (char c: validSpecialChars){
            validChars[c] = 1;  //1 - valid everywhere
        }
        for (char c: validSpecialCharsInQuotes){
            validChars[c] = 2;  //2 - valid to use only inside quotes
        }
    }

    public boolean validate(String emailAddress){
        if (emailAddress == null || emailAddress.length() < 3) return false;

        boolean checkDomain = false;
        boolean hasDot = false;

        boolean hasEtaSign = false;
        int usernameLength = 0;
        boolean lastCharWasDot = false;
        boolean inDoubleQuotes = false;
        boolean doubleQuotesJustEnded = false;
        boolean firstCharAfterEta = false;

        for (int i = 0; i < emailAddress.length(); i++){
            char c = emailAddress.charAt(i);

            //---checking if domain part is valid---//
            if (checkDomain){
                if (hasEtaSign && firstCharAfterEta){ //if domain starts or ends with '-' return false
                    if (c == '-' || emailAddress.charAt(emailAddress.length() - 1) == '-') return false;
                    firstCharAfterEta = false;
                }
                if (c == '.'){ //checking if there is double dot
                    if (lastCharWasDot) return false;
                    lastCharWasDot = true;
                    hasDot = true;//checking domain has '.' for valid tld
                }
                else lastCharWasDot = false;

                boolean isCharValid = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '-' || c == '.';
                if (!isCharValid){
                    //if domain is given as ip return true
                    return c == '[' && emailAddress.charAt(emailAddress.length() - 1) == ']';
                }
            }

            //---checking if username part is valid---//
            else {
                if (i == 0 && emailAddress.charAt(0) == '.') return false; //if username part starts with dot
                if (doubleQuotesJustEnded) doubleQuotesJustEnded = false;
                if (c == '"') {
                    if (inDoubleQuotes) {
                        doubleQuotesJustEnded = true;
                    }
                    inDoubleQuotes = !inDoubleQuotes;
                }

                if (c == '@') {
                    if (!inDoubleQuotes) {
                        firstCharAfterEta = true;
                        //username ends there, so if lastCharWasDot is true,
                        //that means username ended with dot, which is not allowed
                        hasEtaSign = true;
                        checkDomain = true;
                        if (lastCharWasDot || usernameLength < 1) return false;
                    }
                }
                boolean isLetterOrNumber = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
                if (!isLetterOrNumber) {
                    if (c > 126 || !(validChars[c] == 1 || (validChars[c] == 2 && inDoubleQuotes))) {
                        //char is not valid or is valid only inside double quotes
                        //also checking if it is ending with double quotes or main @ sign
                        boolean isItDoubleQuotes = c == '"' && doubleQuotesJustEnded;

                        if (!(isItDoubleQuotes || c == '@')) return false;
                    }
                }
                usernameLength++;
                if (usernameLength > maxLengthOfUserName) return false;
                if (c == '.') {
                    if (!inDoubleQuotes) {
                        if (lastCharWasDot) return false;
                        lastCharWasDot = true;
                    }
                }
                else lastCharWasDot = false;
            }
        }
        //if @ was not found OR domain had no dot OR there were no closing double quotes
        return !inDoubleQuotes && hasEtaSign && hasDot;
    }
}