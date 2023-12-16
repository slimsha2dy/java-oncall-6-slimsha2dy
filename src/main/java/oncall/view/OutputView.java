package oncall.view;

import java.time.LocalDate;
import java.util.List;

import oncall.util.DayOfWeek;
import oncall.util.HolyDay;

public class OutputView {
    private static final OutputView instance = new OutputView();

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
        System.out.print(startDay.getMonthValue() + "월 " + startDay.getDayOfMonth() + "일 ");
        System.out.print(startDayOfWeek.get());
        if (HolyDay.contains(startDay)
                && (startDayOfWeek != DayOfWeek.SATURDAY && startDayOfWeek != DayOfWeek.SUNDAY)) {
            System.out.print("(휴일)");
        }
        System.out.println(" " + name);
    }

    private enum Message {
        OUTPUT_GAME_START("게임을 시작합니다.");

        final String message;

        Message(String message) {
            this.message = message;
        }

        public String get() {
            return this.message;
        }
    }
}
