package _08_Inheritance_Exercise._05_Restaurant.restaurant;

import java.math.BigDecimal;

public class Dessert extends Food{

    public double calories;

    public Dessert(String name, BigDecimal price, double grams,double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
