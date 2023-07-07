package bankRepo;

import java.time.LocalDate;

public class Bank {
    private User user;

    public void registerNewUser(String accountNum, double balance, String name, String gender, LocalDate dateOfBirth) {
        user = new User(accountNum, balance, name, gender, dateOfBirth);
    }

    public void depositMoney(double amount) {
        if (user != null) {
            user.debit(amount);
            System.out.println("You've successfully deposited " + amount + " to your account.");
        } else {
            System.out.println("No active user");
        }
    }

    public void withdrawMoney(double amount) {
        if (user != null) {
            user.credit(amount);
            System.out.println("You've withdrawn " + amount + " from your bank account");
        } else {
            System.out.println("No active user");
        }
    }

    public void showBalance() {
        if (user != null) {
            user.displayUserBalance();
        } else {
            System.out.println("No active user");
        }
    }

    public void loan(double amount, double interestRate) {
        if (user != null) {
            long age = user.getUserAge();
            if (age >= 18) {
                double loanAmount = amount + interestRate*amount;
                user.debit(amount);
                System.out.println("You've received loan of " + amount + ". You're expected to pay back " + loanAmount + " over the next 12 months.");
            } else {
                System.out.println("Loans are not available to minors.");
            }
        } else {
            System.out.println("No active user");
        }
    }

}


