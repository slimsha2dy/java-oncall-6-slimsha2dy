package oncall.util;

import java.util.List;
import java.util.Arrays;

public class Utility {
    public static List<String> splitWithComma(String input) {
        String[] splitted = input.split(Regex.COMMA.getRegex());
        return Arrays.asList(splitted);
    }

    private enum Regex {
        COMMA(",");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }

        public String getRegex() {
            return this.regex;
        }

        public char getChar() {
            return this.regex.charAt(0);
        }
    }
}
