package oncall.util;

public enum DayOfWeek {
    SUNDAY("일"),
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토");

    private final String value;

    DayOfWeek(String value) {
        this.value = value;
    }

    public String get() {
        return this.value;
    }

    public static boolean contains(String other) {
        for (DayOfWeek dayOfWeek : values()) {
            if (other.equals(dayOfWeek.value)) {
                return true;
            }
        }
        return false;
    }

    public static DayOfWeek getFromString(String day) {
        for (DayOfWeek dayOfWeek : values()) {
            if (day.equals(dayOfWeek.value)) {
                return dayOfWeek;
            }
        }
        return null;
    }
}
