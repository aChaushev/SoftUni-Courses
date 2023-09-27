package _03_WorkingWith_Abstraction_Lab._04_HotelReservation;

public enum Season {
    // 4 сезона -> 4 константни обекта
    AUTUMN("Autumn", 1),
    SPRING("Spring", 2),
    WINTER("Winter", 3),
    SUMMER("Summer", 4);
    private String name;
    private int multiplyCoefficient;

    Season(String name, int multiplyCoefficient) {
        this.name = name;
        this.multiplyCoefficient = multiplyCoefficient;
    }

    public int getMultiplyCoefficient() {
        return multiplyCoefficient;
    }

}
