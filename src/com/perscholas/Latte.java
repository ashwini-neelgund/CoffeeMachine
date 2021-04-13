package com.perscholas;

public class Latte extends Coffee {

    public Latte() {
        super.setWater(350);
        super.setMilk(75);
        super.setCoffeeBeans(20);
        super.setPrice(7);
    }

    @Override
    public void makingCoffee() {
        System.out.println("Starting to make a Latte");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Latte is ready!");
    }
}
