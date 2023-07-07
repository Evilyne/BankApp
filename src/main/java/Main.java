import bankRepo.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Menu menu = new Menu(bank);
        Scanner userInputReader = new Scanner(System.in);

        while (true){
            menu.displayUserChoices();
            int choice = userInputReader.nextInt();
            menu.userChoices(choice);
            System.out.println();
        }

    }
}
