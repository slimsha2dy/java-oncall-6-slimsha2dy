package oncall;

import oncall.util.DayOfWeek;
import oncall.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
public class ValidatorTest {
    @Test
    void isStringNumberTest1() {
        assertThat(Validator.isStringNumber("asdf")).isEqualTo(true);
    }

    @Test
    void isStringNumberTest2() {
        assertThat(Validator.isStringNumber("웧")).isEqualTo(true);
    }
}
