package _14_DefiningClasses_Exercise._05_CarSalesman;

public class Engine {
    private String model;
    private int power; //мощност
    private int displacement; //работен обем
    private String efficiency; // ефективност


    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine() {

    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
