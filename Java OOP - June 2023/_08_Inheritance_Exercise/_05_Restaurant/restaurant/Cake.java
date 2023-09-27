package _08_Inheritance_Exercise._05_Restaurant.restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert{
    //•	double CAKE_GRAMS = 250
    //•	double CAKE_CALORIES = 1000
    //•	BigDecimal CAKE_PRICE = 5
    public final static double CAKE_GRAMS = 250;
    public final static double CAKE_CALORIES = 1000;
    public final static BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
