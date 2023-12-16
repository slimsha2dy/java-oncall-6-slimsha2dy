package oncall.util;

public class Validator {
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
