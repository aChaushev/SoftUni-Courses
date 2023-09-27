package _08_Inheritance_Exercise._06_Animals.animals;

public class Tomcat extends Cat{

    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
