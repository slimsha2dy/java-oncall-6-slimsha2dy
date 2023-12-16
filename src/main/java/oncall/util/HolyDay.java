package oncall.util;

import java.time.LocalDate;

public enum HolyDay {
    SIN_JEONG(1, 1),
    SAMIL_JEOL(3, 1),
    CHILD_DAY(5, 5),
    HYEON_CHOONG_IL(6, 6),
    GWANG_BOK_JEOL(8, 15),
    GAE_CHEON_JEOL(10, 3),
    HAN_GUEL_NAL(10, 9),
    CHRISTMAS(12, 25);

    private final LocalDate day;

    HolyDay(int month, int date) {
        day = LocalDate.of(2023, month, date);
    }

    public static boolean contains(LocalDate localDate) {
        for (HolyDay holyDay : values()) {
            if (holyDay.day.isEqual(localDate)) {
                return true;
            }
        }
        return false;
    }
}
