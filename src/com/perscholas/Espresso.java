package com.perscholas;

public class Espresso extends Coffee {

    public Espresso() {
        super.setWater(250);
        super.setCoffeeBeans(16);
        super.setPrice(4);
    }

    @Override
    public void makingCoffee() {
        System.out.println("Starting to make an Espresso");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring Espresso into the cup");
        System.out.println("Espresso is ready!");
    }
}
