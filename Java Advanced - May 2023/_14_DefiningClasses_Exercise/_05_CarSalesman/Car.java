package _14_DefiningClasses_Exercise._05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //"{CarModel}:
        sb.append(this.model).append(":").append(System.lineSeparator());
        //{EngineModel}:
        sb.append(this.engine.getModel()).append(":").append(System.lineSeparator());
        //Power: {EnginePower}
        sb.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());
        //Displacement: {EngineDisplacement}
        sb.append("Displacement: ");
        if (this.engine.getDisplacement() == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }
        //Efficiency: {EngineEfficiency}
        sb.append("Efficiency: ");
        if (this.engine.getEfficiency() == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }
        //Weight: {CarWeight}
        sb.append("Weight: ");
        if (this.weight == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.weight).append(System.lineSeparator());
        }
        //Color: {CarColor}"
        sb.append("Color: ");
        if (this.color == null) {
            sb.append("n/a").append(System.lineSeparator());
            ;
        } else {
            sb.append(this.color).append(System.lineSeparator());
            ;
        }
        return sb.toString();
    }
}
