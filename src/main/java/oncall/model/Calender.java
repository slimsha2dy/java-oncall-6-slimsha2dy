package oncall.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import oncall.util.DayOfWeek;
import oncall.util.HolyDay;
import oncall.util.Validator;

public class Calender {
    private LocalDate startDay;
    private DayOfWeek startDayOfWeek;
    private List<String> roster;

    public Calender(List<String> input) {
        Validator.validateMonthDay(input);
        int month = Integer.parseInt(input.get(0));
        this.startDay = LocalDate.of(2023, month, 1);
        this.startDayOfWeek = DayOfWeek.getFromString(input.get(1));
        roster = new ArrayList<>();
    }

    public void setRoster(WorkQueue weekdayQueue, WorkQueue weekendQueue) {
        LocalDate temporaryDay = startDay;
        DayOfWeek temporaryDayOfWeek = startDayOfWeek;
        while (temporaryDay.getMonth() == startDay.getMonth()) {
            String lastElement = "";
            if (!roster.isEmpty()) {
                lastElement = roster.get(roster.size() - 1);
            }
            if (isHolyDay(temporaryDay, temporaryDayOfWeek)) {
                roster.add(weekendQueue.getNext(lastElement));
            }
            if (!isHolyDay(temporaryDay, temporaryDayOfWeek)) {
                roster.add(weekdayQueue.getNext(lastElement));
            }
            temporaryDayOfWeek = DayOfWeek.next(temporaryDayOfWeek);
            temporaryDay = temporaryDay.plusDays(1);
        }
    }

    private boolean isHolyDay(LocalDate temporaryDay, DayOfWeek temporaryDayOfWeek) {
        if (temporaryDayOfWeek == DayOfWeek.SATURDAY
                || temporaryDayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }
        if (HolyDay.contains(temporaryDay)) {
            return true;
        }
        return false;
    }

    public DayOfWeek getStartDayOfWeek() {
        return this.startDayOfWeek;
    }

    public LocalDate getStartDay() {
        return this.startDay;
    }

    public List<String> getRoster() {
        return this.roster;
    }
}
