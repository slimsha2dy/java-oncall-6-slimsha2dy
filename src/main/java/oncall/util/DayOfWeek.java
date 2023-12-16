package oncall.util;

public enum DayOfWeek {
    SUNDAY("일", 0),
    MONDAY("월", 1),
    TUESDAY("화", 2),
    WEDNESDAY("수", 3),
    THURSDAY("목", 4),
    FRIDAY("금", 5),
    SATURDAY("토", 6);

    private final String value;
    private final int number;

    DayOfWeek(String value, int number) {
        this.value = value;
        this.number = number;
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

    public static DayOfWeek getFromNumber(int number) {
        for (DayOfWeek dayOfWeek : values()) {
            if (number == dayOfWeek.number) {
                return dayOfWeek;
            }
        }
        return null;
    }

    public static DayOfWeek next(DayOfWeek dayOfWeek) {
        int number = dayOfWeek.number;
        number = (number + 1) % 7;
        return getFromNumber(number);
    }
}
