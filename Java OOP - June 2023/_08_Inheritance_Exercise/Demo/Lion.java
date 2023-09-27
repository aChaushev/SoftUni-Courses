package _08_Inheritance_Exercise.Demo;

public class Lion extends Animal {
    private int roarStrength;

    public Lion(String name, int speed) {
        super(name, speed);
    }

    public void setRoarStrength(int roarStrength) {
        this.roarStrength = roarStrength;
    }

    @Override
    public String toString() {
        return getName() + " has " + roarStrength ;
    }
}
