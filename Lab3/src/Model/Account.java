package model;

public class Account {
    private String routingNumber;
    private String accountNumber;
    private String bankName;
    private double balance;
    
    public Account() {
        // Default constructor
    }
    
    public Account(String routingNumber, String accountNumber, String bankName, double balance) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }
    
    // Getters
    public String getRoutingNumber() {
        return routingNumber;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setters
    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "routingNumber='" + routingNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                '}';
    }
}