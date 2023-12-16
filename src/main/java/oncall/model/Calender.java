package oncall.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import oncall.util.DayOfWeek;
import oncall.util.Validator;

public class Calender {
    private LocalDate startDay;
    private DayOfWeek startDayOfWeek;

    public Calender(List<String> input) {
        Validator.validateMonthDay(input);
        int month = Integer.parseInt(input.get(0));
        this.startDay = LocalDate.of(2023, month, 1);
        this.startDayOfWeek = DayOfWeek.getFromString(input.get(1));
    }

    public void setRoster(WorkQueue weekdayQueue, WorkQueue weekendQueue) {
        LocalDate temporaryDay = startDay;
        DayOfWeek temporaryDayOfWeek = startDayOfWeek;
        while (temporaryDay.getMonth() == startDay.getMonth()) {

            temporaryDayOfWeek = DayOfWeek.next(temporaryDayOfWeek);
            temporaryDay = temporaryDay.plusDays(1);
        }
    }
}
