package _14_DefiningClasses_Exercise._03_SpeedRacing;

public class Car {
    //полета -> характеристики на обекта
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    //методи действия
    //контреуктор -> метод, чрез който създаваме обекти от класа

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }


    public boolean drive(int amountOfKm) {
        // 1.нужно количество гориво, за да преминем дадените километри (amountOfKm);
        double needFuel = amountOfKm * this.fuelCostPerKm;
        if (this.fuelAmount >= needFuel) {
            this.fuelAmount -= needFuel;
            this.distanceTraveled += amountOfKm;
            return true;
        }
        return false;
    }

    @Override
    //"{Model} {fuelAmount} {distanceTraveled}"
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
