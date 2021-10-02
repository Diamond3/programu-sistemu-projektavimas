package com.alemal.validation;

public class PhoneValidator {
    static int numLengthNoPlus = 9; //for LT phone numbers
    static int numLengthWithPlus = 12; //for LT phone numbers

    public boolean validate(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 1) return false; //is null

        boolean hasPlusSign = phoneNumber.charAt(0) == '+';
        if (!hasPlusSign && phoneNumber.length() != numLengthNoPlus) return false; //length is not valid
        else if (hasPlusSign && phoneNumber.length() != numLengthWithPlus) return false; //length is not valid

        for (int i = 0; i < phoneNumber.length(); i++){
            if ((i != 0 && phoneNumber.charAt(i) < 48 || phoneNumber.charAt(i) > 57) //if number has not a number
                || (i==0 && !hasPlusSign)){ //if number has not a number on the first char and that char is not a plus sign
                return false;
            }
        }
        return true;
    }
    public String convert(PhoneNumber.CountryCode code, String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 1) return phoneNumber;
        char[] temp = phoneNumber.toCharArray();
        switch (code){
            case LT:
                if (phoneNumber.charAt(0) != '8') return phoneNumber;
                temp[0] = '0';
                return "+37" + String.valueOf(temp);
            case UK:
                if (phoneNumber.charAt(0) != '0') return phoneNumber;
                temp[0] = '4';
                return "+4" + String.valueOf(temp);
            default:
                return phoneNumber;
        }
    }
}