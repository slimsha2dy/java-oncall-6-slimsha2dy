package oncall.util;

public enum ErrorMessage {
    INPUT_ERROR("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
