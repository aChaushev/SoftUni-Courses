package _08_Inheritance_Exercise.Demo;

public class Animal {

    private String name;
    private int speed;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Animal(String name, int speed) {
        setName(name);
        setSpeed(speed);


    }
}
