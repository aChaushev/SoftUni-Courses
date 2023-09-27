package _08_Inheritance_Exercise.Demo;

public class Timon extends Lion{

    public Timon(String name, int speed) {
        super(name, speed);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
