package org.kainos.ea.core;

import org.kainos.ea.cli.DelivEmpRequest;

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
        if (!delivEmp.getBankAccountNo().matches("^\\d{20}$")) {
            return "Bank account number is not valid.";
        }
        if (!delivEmp.getNiNum().matches("^[A-CEGHJ-PR-TW-Z][A-CEGHJ-NPR-TW-Z]\\d{6}[A-D]$")) {
            return "National Insurance number is invalid.";
        }
        return null;
    }
}