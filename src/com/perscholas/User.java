package com.perscholas;

import java.util.Scanner;

public class User {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine1 = new CoffeeMachine(1200, 540, 120, 9, 550);
        Scanner input = new Scanner(System.in);
        int actionSelected;
        do {
            System.out.println("Please select an action : ");
            System.out.println("1) Buy Coffee");
            System.out.println("2) Refill Coffee Machine");
            System.out.println("3) Withdraw Money");
            System.out.println("4) Exit");
            actionSelected = input.nextInt();
            switch (actionSelected) {
                case 1:
                    coffeeMachine1.buyCoffee();
                    break;
                case 2:
                    coffeeMachine1.restockMachine();
                    break;
                case 3:
                    coffeeMachine1.withdrawMoney();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please select valid action.");
            }
        } while (actionSelected != 4);

    }
}
