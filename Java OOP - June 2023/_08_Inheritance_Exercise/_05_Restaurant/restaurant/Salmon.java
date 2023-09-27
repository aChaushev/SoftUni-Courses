package _08_Inheritance_Exercise._05_Restaurant.restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    //•	double SALMON_GRAMS = 22

    public final static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
