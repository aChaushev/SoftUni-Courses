public enum AccountType {
    FREE("FREE"),
    TRIAL("TRIAL"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
