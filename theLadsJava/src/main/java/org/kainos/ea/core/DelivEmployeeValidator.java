package org.kainos.ea.core;

import org.kainos.ea.cli.DelivEmpRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelivEmployeeValidator {

    public String isDelivEmployeeValid(DelivEmpRequest delivEmp){
        if(delivEmp.getfName().length() > 50){
            return "First name is greater than 50";
        }
        if(delivEmp.getlName().length() > 50){
            return "Last name is greater than 50";
        }
        if(delivEmp.getSalary() > 9999999){
            return "Salary is greater than company policy of £9,999,999";
        }
        if (!delivEmp.getBankAccountNo().matches("^\\d{16}$")) {
            return "Bank account number is not valid.";
        }
        if(!isValidNINum(delivEmp.getNiNum())){
            return "National Insurance number is not valid.";
        }
        return null;
    }

    public boolean isValidNINum(String NINum){
        // Define the regular expression pattern
        String pattern = "^[A-Z]{2}\\d{6}[A-Z]$";

        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regex.matcher(NINum);

        // Check if the input matches the pattern
        return matcher.matches();
    }
}