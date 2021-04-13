package com.perscholas;

import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private double money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, double money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void buyCoffee() {

        Scanner input = new Scanner(System.in);
        int itemSelected;
        do {
            System.out.println("Please select from below menu : ");
            System.out.println("1) Espresso");
            System.out.println("2) Latte");
            System.out.println("3) Cappuccino");
            System.out.println("4) Go back to Main Menu");
            itemSelected = input.nextInt();
            System.out.println(itemSelected);
        } while (itemSelected != 1 && itemSelected != 2 && itemSelected != 3 && itemSelected != 4);

        Coffee coffee = null;
        switch (itemSelected) {
            case 1:
                coffee = new Espresso();
                break;
            case 2:
                coffee = new Latte();
                break;
            case 3:
                coffee = new Cappuccino();
                break;
            case 4:
                return;
            default:
                System.out.println("Please select valid menu item.");
        }

        //calculate the maximum number of cups of coffee that the machine can prepare currently
        int maxCupsOfCoffee = Math.min(water / coffee.getWater(), coffeeBeans / coffee.getCoffeeBeans());
        if (itemSelected != 1)
            maxCupsOfCoffee = Math.min(maxCupsOfCoffee, milk / coffee.getMilk());

        //If machine doesn't have enough ingredients to make coffee return back to main menu
        if (maxCupsOfCoffee < 1) {
            System.out.println("Sorry for your inconvenience. The coffee machine is out of ingredients.");
            return;
        }

        //user input for the number of cups of coffee he/she requires and verify if machine can make it
        int cupsOfCoffeeReq;
        do {
            System.out.println("Please enter the number of cups of coffee required : ");
            cupsOfCoffeeReq = input.nextInt();

            if (cupsOfCoffeeReq > maxCupsOfCoffee) {
                System.out.println("No, I can only make " + maxCupsOfCoffee + " of coffee");
                System.out.println("Please reselect the number of cups of coffee required.");
            }
        } while (cupsOfCoffeeReq > maxCupsOfCoffee);

        //update the inventory of coffee machine and make requested cups of coffee
        updateCoffeeMachineSupply(coffee, cupsOfCoffeeReq);
        coffee.makingCoffee();

    }

    private void updateCoffeeMachineSupply(Coffee coffee, int cupsOfCoffeeReq) {
        water -= coffee.getWater() * cupsOfCoffeeReq;
        milk -= coffee.getCoffeeBeans() * cupsOfCoffeeReq;
        coffeeBeans -= coffee.getCoffeeBeans() * cupsOfCoffeeReq;
        cups -= cupsOfCoffeeReq;
        money -= coffee.getPrice();
    }

    public void restockMachine() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many ml of water do you want to add: ");
        water += input.nextInt();
        System.out.println("How many ml of milk do you want to add: ");
        milk += input.nextInt();
        System.out.println("How many grams of coffee beans do you want to add: ");
        coffeeBeans += input.nextInt();
        System.out.println("How many disposable cups of coffee do you want to add: ");
        cups += input.nextInt();
        printStock();
    }

    private void printStock() {
        System.out.println("The coffee machine has:");
        System.out.println(water + "ml of water");
        System.out.println(milk + "ml of milk");
        System.out.println(coffeeBeans + "grams of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + "$ of money");
    }

    public void withdrawMoney() {
        System.out.println(money + "$ has been withdrawn.");
        money = 0;
        printStock();
    }
}
