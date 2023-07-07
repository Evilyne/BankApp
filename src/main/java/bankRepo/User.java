package bankRepo;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class User {
    private String accountNum;
    private double balance;
    private String name, gender;
    private LocalDate dateOfBirth;

    public User(String accountNum, double balance, String name, String gender, LocalDate dateOfBirth) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void debit(double amount){
        balance+= amount;
    }
    public void credit (double amount){
        if (amount > balance){
            System.out.println("Not enough funds to withdraw");
        } else {
            balance -= amount;
        }
    }
    public void displayUserBalance(){
        System.out.println("Your account balance is: "+balance);
    }
    public long getUserAge(){
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }
}
