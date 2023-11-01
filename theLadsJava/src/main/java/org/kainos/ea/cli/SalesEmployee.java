package org.kainos.ea.cli;

import java.math.BigDecimal;
public class SalesEmployee {
    private int SalesEmpID;
    private String Forename;
    private String Surname;
    private BigDecimal Salary;
    private String BAN;
    private String NINumber;
    private BigDecimal ComRate;

    public SalesEmployee(int SalesEmpID, String Forename, String Surname,
                         BigDecimal Salary, String BAN, String NINumber, BigDecimal ComRate) {
        this.SalesEmpID = SalesEmpID;
        this.Forename = Forename;
        this.Surname = Surname;
        this.Salary = Salary;
        this.BAN = BAN;
        this.NINumber = NINumber;
        this.ComRate = ComRate;
    }

    public int getSalesEmpID() {
        return SalesEmpID;
    }

    public void setSalesEmpID(int salesEmpID) {
        SalesEmpID = salesEmpID;
    }

    public String getForename() {
        return Forename;
    }

    public void setForename(String forename) {
        Forename = forename;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        Salary = salary;
    }

    public String getBAN() {
        return BAN;
    }

    public void setBAN(String BAN) {
        this.BAN = BAN;
    }

    public String getNINumber() {
        return NINumber;
    }

    public void setNINumber(String NINumber) {
        this.NINumber = NINumber;
    }

    public BigDecimal getComRate() {
        return ComRate;
    }

    public void setComRate(BigDecimal comRate) {
        ComRate = comRate;
    }
}
