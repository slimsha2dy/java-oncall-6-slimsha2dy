package oncall.view;

import java.time.LocalDate;
import java.util.List;

import oncall.util.DayOfWeek;
import oncall.util.HolyDay;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String MONTH_MESSAGE = "월 ";
    private static final String DATE_MESSAGE = "일 ";
    private static final String HOLYDAY_MESSAGE = "(휴일)";
    private static final String SPACE = " ";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public static void printResult(DayOfWeek startDayOfWeek, LocalDate startDay, List<String> roster) {
        for (String name : roster) {
            printOneDay(startDayOfWeek, startDay, name);
            startDayOfWeek = DayOfWeek.next(startDayOfWeek);
            startDay = startDay.plusDays(1);
        }
    }

    public static void printOneDay(DayOfWeek startDayOfWeek, LocalDate startDay, String name) {
        System.out.print(startDay.getMonthValue() + MONTH_MESSAGE + startDay.getDayOfMonth() + DATE_MESSAGE);
        System.out.print(startDayOfWeek.get());
        if (HolyDay.contains(startDay)
                && (startDayOfWeek != DayOfWeek.SATURDAY && startDayOfWeek != DayOfWeek.SUNDAY)) {
            System.out.print(HOLYDAY_MESSAGE);
        }
        System.out.println(SPACE + name);
    }
}
