package oncall;

import oncall.model.WorkQueue;
import oncall.util.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class DayOfWeekTest {
    @Test
    void getFromNumberTest() {
        assertThat(DayOfWeek.getFromNumber(0)).isEqualTo(DayOfWeek.SUNDAY);
        assertThat(DayOfWeek.getFromNumber(1)).isEqualTo(DayOfWeek.MONDAY);
        assertThat(DayOfWeek.getFromNumber(6)).isEqualTo(DayOfWeek.SATURDAY);
    }

    @Test
    void nextTest() {
        assertThat(DayOfWeek.next(DayOfWeek.TUESDAY)).isEqualTo(DayOfWeek.WEDNESDAY);
        assertThat(DayOfWeek.next(DayOfWeek.SUNDAY)).isEqualTo(DayOfWeek.MONDAY);
        assertThat(DayOfWeek.next(DayOfWeek.SATURDAY)).isEqualTo(DayOfWeek.SUNDAY);
    }
}
