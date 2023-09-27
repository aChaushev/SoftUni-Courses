package _08_Inheritance_Exercise._04_NeedForSpeed;

public class Vehicle {
    //•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
    //•	fuelConsumption – double
    //•	fuel – double
    //•	horsePower – int
    //•	Getters and Setters for the fields
    //•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
    //•	void drive(double kilometers)
    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public void drive(double kilometers){
        double requiredFuel = kilometers * fuelConsumption;
        if(fuel >= requiredFuel){
            fuel -= requiredFuel;
        }

    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


}
