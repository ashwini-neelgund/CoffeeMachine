package com.perscholas;

public class Cappuccino extends Coffee {

    public Cappuccino() {
        super.setWater(200);
        super.setMilk(100);
        super.setCoffeeBeans(12);
        super.setPrice(6);
    }

    @Override
    public void makingCoffee() {
        System.out.println("Starting to make a Cappuccino");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Cappuccino is ready!");
    }
}
