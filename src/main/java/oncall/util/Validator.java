package oncall.util;

import java.util.List;

public class Validator {
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    public static void validateInput(String input) {
        if (input.isEmpty() || isEndWithComma(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }

        String[] splitted = input.split(Regex.COMMA.getRegex());
        for (String string : splitted) {
            if (string.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
            }
        }
    }

    public static void validateFirstInput(String input) {
        validateInput(input);
        String[] splitted = input.split(Regex.COMMA.getRegex());
        if (splitted.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
    }

    public static void validateMonthDay(List<String> input) {
        if (input.size() != 2) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        if (!isStringNumber(input.get(0))
                || Integer.parseInt(input.get(0)) < MIN_MONTH
                || Integer.parseInt(input.get(0)) > MAX_MONTH) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        if (!DayOfWeek.contains(input.get(1))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
    }

    public static void validateWorkQueue(List<String> input) {
        if (input.isEmpty() || input.size() < 5 || input.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        for (String string : input) {
            validateName(string);
        }
    }

    public static void validateName(String input) {
        if (input.isEmpty() || input.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
    }

    public static boolean isStringNumber(String input) {
        for (int i = 0; i < input.length() - 1; ++i) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isEndWithComma(String input) {
        if (input.charAt(input.length() - 1) == Regex.COMMA.getChar()) {
            return true;
        }
        return false;
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
