import java.io.*;

public class BankAccount implements Serializable{

    private String number;
    private double balance;
    private String fullName;
    private String pinCode;

    public BankAccount(String number, double balance, String fullName, String pinCode) {
        this.number = number;
        this.balance = balance;
        this.fullName = fullName;
        this.pinCode = pinCode;
    }

    public BankAccount() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}