package _06_Encapsulation_Exercise._04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce – 0.9;
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * getModifier();
    }

    private double getModifier() {
        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce – 0.9;
        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;

        }
    }
}
