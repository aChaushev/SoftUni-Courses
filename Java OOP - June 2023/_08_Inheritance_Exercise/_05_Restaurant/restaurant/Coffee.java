package _08_Inheritance_Exercise._05_Restaurant.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    //•	double COFFEE_MILLILITERS = 50
    //•	BigDecimal COFFEE_PRICE = 3.50
    //•	caffeine – double
    private final static double COFFEE_MILLILITERS = 50;
    private final static BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
