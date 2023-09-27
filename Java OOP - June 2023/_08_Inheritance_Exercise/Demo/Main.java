package _08_Inheritance_Exercise.Demo;

public class Main {
    public static void main(String[] args) {


        Animal animal = new Animal("Bai Hui", 5);
        System.out.println(animal.toString());
        Lion lion = new Lion("Pumba",14);
        lion.setRoarStrength(200);
        System.out.println(lion.toString());
        Timon timon = new Timon("Timon", 20);
        timon.setName("BadBoy");
        timon.setRoarStrength(1231);
        System.out.println(timon.toString());

    }
}
