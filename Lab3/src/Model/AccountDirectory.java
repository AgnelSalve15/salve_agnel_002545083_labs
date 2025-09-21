package model;

import java.util.ArrayList;

public class AccountDirectory {
    private ArrayList<Account> accountList;
    
    public AccountDirectory() {
        this.accountList = new ArrayList<Account>();
        
        // Add sample data to match the images
        Account account1 = new Account("889212189", "45454545", "Bank of America", 200.0);
        Account account2 = new Account("889212189", "4546767675", "Citizen Bank", 100.0);
        accountList.add(account1);
        accountList.add(account2);
    }
    
    public ArrayList<Account> getAccountList() {
        return accountList;
    }
    
    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
    
    public Account addAccount() {
        Account account = new Account();
        accountList.add(account);
        return account;
    }
    
    public void deleteAccount(Account account) {
        accountList.remove(account);
    }
    
    public Account searchAccount(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
