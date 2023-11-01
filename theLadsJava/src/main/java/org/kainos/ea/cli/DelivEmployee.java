package org.kainos.ea.cli;

public class DelivEmployee {

    private int delivEmpId;
    private String fName;
    private String lName;
    private double salary;
    private String niNum;
    private String bankAccountNo;


    public DelivEmployee(int delivEmpId, String fName, String lName, double salary, String niNum, String bankAccountNo) {
        this.delivEmpId = delivEmpId;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.niNum = niNum;
        this.bankAccountNo = bankAccountNo;
    }



    public DelivEmployee(String fName, String lName, double salary, String niNum, String bankAccountNo) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.niNum = niNum;
        this.bankAccountNo = bankAccountNo;
    }

    public int getDelivEmpId() {
        return delivEmpId;
    }

    public void setDelivEmpId(int delivEmpId) {
        this.delivEmpId = delivEmpId;
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