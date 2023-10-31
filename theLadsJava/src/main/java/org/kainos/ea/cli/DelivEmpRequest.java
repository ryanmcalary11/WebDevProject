package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DelivEmpRequest {
    private String fName;
    private String lName;
    private double salary;
    private String niNum;
    private String bankAccountNo;


    @JsonCreator
    public DelivEmpRequest(
            @JsonProperty("fName") String fName,
            @JsonProperty("lName") String lName,
            @JsonProperty("salary") double salary,
            @JsonProperty("niNum") String niNum,
            @JsonProperty("bankAccountNo") String bankAccountNo)
    {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.niNum = niNum;
        this.bankAccountNo = bankAccountNo;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNiNum() {
        return niNum;
    }

    public void setNiNum(String niNum) {
        this.niNum = niNum;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

}