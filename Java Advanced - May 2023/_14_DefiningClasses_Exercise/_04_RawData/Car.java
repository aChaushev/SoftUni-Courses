package _14_DefiningClasses_Exercise._04_RawData;

import java.util.List;

public class Car {
    //model, engine, cargo, and a collection of exactly 4 tires
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public void extractCar(String command) {
        if(command.equals("fragile")){
            for (Tire tire : tires) {
                if(tire.getPressure() < 1){
                    System.out.println(model);
                    break;
                }
            }

        } else if(command.equals("flamable")){
            if(this.engine.getEnginePower() > 250){
                System.out.println(model);
            }

        }
    }
}
