package oncall.util;

import java.util.List;
import oncall.model.WorkQueue;

public class Validator {
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int FIRST_INPUT_LENGTH = 2;
    private static final int NAME_MAX = 5;
    private static final int QUEUE_MIN = 5;
    private static final int QUEUE_MAX = 35;
    private static final int MONTH_INDEX = 0;
    private static final int DAY_OF_WEEK_INDEX = 1;

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
        if (splitted.length != FIRST_INPUT_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
    }

    public static void validateMonthDay(List<String> input) {
        if (input.size() != FIRST_INPUT_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        if (!isStringNumber(input.get(MONTH_INDEX))
                || Integer.parseInt(input.get(MONTH_INDEX)) < MIN_MONTH
                || Integer.parseInt(input.get(MONTH_INDEX)) > MAX_MONTH) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        if (!DayOfWeek.contains(input.get(DAY_OF_WEEK_INDEX))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
    }

    public static void validateWorkQueue(List<String> input) {
        if (input.isEmpty() || input.size() < QUEUE_MIN || input.size() > QUEUE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        for (String string : input) {
            validateName(string);
        }
    }

    public static void validateTwoQueue(WorkQueue first, WorkQueue second) {
        if (first.size() != second.size()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
        if (!first.haveEqualMember(second)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
        }
    }

    public static void validateName(String input) {
        if (input.isEmpty() || input.length() > NAME_MAX) {
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
