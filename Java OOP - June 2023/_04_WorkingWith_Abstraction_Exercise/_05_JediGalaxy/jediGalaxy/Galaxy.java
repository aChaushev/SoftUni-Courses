package _04_WorkingWith_Abstraction_Exercise._05_JediGalaxy.jediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;

    private EvilPower evilPower;

    public Galaxy(Field field, Jedi jedi,EvilPower evilPower) {
        this.field = field;
        this.jedi = jedi;
       this.evilPower = evilPower;
    }

    public int moveJedi() {
        return jedi.move(field);
    }

    public void moveEvil() {
        evilPower.move(field);
    }
}
