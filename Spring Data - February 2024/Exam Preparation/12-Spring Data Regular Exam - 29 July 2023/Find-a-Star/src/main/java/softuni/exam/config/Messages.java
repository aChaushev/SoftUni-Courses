package softuni.exam.config;

public enum Messages {
    ;
    public static final String INVALID_CONSTELLATION = "Invalid constellation";
    public static final String VALID_CONSTELLATION = "Successfully imported constellation %s - %s";

    public static final String INVALID_STAR = "Invalid star";
    public static final String VALID_STAR = "Successfully imported star %s - %.2f light years";

    public static final String INVALID_ASTRONOMER = "Invalid astronomer";
    public static final String VALID_ASTRONOMER = "Successfully imported astronomer %s %s - %.2f";
    public static final String EXPORT_NON_OBSERVED_STARS = "Star: %s\n" +
            "   *Distance: %.2f light years\n" +
            "   **Description: %s\n" +
            "   ***Constellation: %s";
}
