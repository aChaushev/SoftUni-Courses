package _03_WorkingWith_Abstraction_Lab._04_HotelReservation;

public enum DiscountType {
    VIP("VIP", 20),
    SECOND_VISIT("SecondVisit", 10),
    NONE("None", 0);

    private String name;
    private double percent;

    DiscountType(String name, double percent) {
        this.name = name;
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

}
