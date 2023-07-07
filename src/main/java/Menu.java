import bankRepo.Bank;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private Bank bank;
    private Scanner userReader;

    public Menu(Bank bank) {
        this.bank = bank;
        userReader = new Scanner(System.in);
    }

    public void displayUserChoices(){
        System.out.println("Hello! Welcome to your bank account!");
        System.out.println("1. Register as New User");
        System.out.println("2. Deposit funds into your account");
        System.out.println("3. Withdraw funds from your account");
        System.out.println("4. Display your account balance");
        System.out.println("5. Take a personal loan");
        System.out.println("6. Exit account");
        System.out.println("Please enter your choice"+"\n -----------------------");

    }

    public void userChoices(int option){
        userReader.nextLine();
        switch (option){
            case 1:
                System.out.println("To register please fill in the following fields."+"\n Enter your name:");
                String name = userReader.nextLine();
                System.out.println("Enter your genter please: F/M");
                String gender = userReader.nextLine();
                System.out.println("Please enter your date of birth (YYYY-MM-DD)");
                LocalDate dateOfBirth = LocalDate.parse(userReader.nextLine());
                String accountNum = generateAccountNumber();
                bank.registerNewUser(accountNum, 0.0,name,gender,dateOfBirth);
                System.out.println("Great! You're registered."+"\n Your account number is: "+ accountNum);
                break;

            case 2:
                System.out.println("Please enter the amount you wish to deposit.");
                double debitAmount = userReader.nextDouble();
                bank.depositMoney(debitAmount);
                break;

            case 3:
                System.out.println("Please enter the amount you wish to withdraw.");
                double creditAmount = userReader.nextDouble();
                bank.withdrawMoney(creditAmount);
                break;

            case 4:
                bank.showBalance();
                break;

            case 5:
                System.out.println("Enter the amount you wish to loan");
                double loanAmount = userReader.nextDouble();
                double interestRate = 0.05;
                bank.loan(loanAmount, interestRate);
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Please choose an available option");


        }


    }
    private String generateAccountNumber(){
        StringBuilder accountNum = new StringBuilder("LT");
        for (int i=0; i <12; i ++) {
            int digit = (int) (Math.random()*10);
            accountNum.append(digit);
        }
        return accountNum.toString();
    }
}
