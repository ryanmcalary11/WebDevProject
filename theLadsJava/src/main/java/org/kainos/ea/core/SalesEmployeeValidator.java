package org.kainos.ea.core;

import org.kainos.ea.cli.SalesEmployeeRequest;

import java.math.BigDecimal;

public class SalesEmployeeValidator {
    public String isValidSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {
        if(salesEmployeeRequest.getForename().length() > 50){
            return "First name is greater than 50";
        }
        if(salesEmployeeRequest.getSurname().length() > 50){
            return "Last name is greater than 50";
        }


        if (!salesEmployeeRequest.getBAN().matches("^\\d{20}$")) {
            return "Bank account number is not valid.";
        }
        if (!salesEmployeeRequest.getNINumber().matches("^[A-CEGHJ-PR-TW-Z][A-CEGHJ-NPR-TW-Z]\\d{6}[A-D]$")) {
            return "National Insurance number is invalid.";
        }
        return null;
    }

}
