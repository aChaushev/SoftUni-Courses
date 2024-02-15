package _14_DefiningClasses_Exercise._09_CatLady;

public class Siamese extends Cat { // тип Котка
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name); // подаваме го на конструктора на Cat
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", getName(), earSize);
    }
}
