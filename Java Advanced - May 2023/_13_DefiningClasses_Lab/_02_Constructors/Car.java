package _13_DefiningClasses_Lab._02_Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String toString() {
        return String.format("The car is: %s %s - %d HP.", brand, model, horsepower);
    }
}
