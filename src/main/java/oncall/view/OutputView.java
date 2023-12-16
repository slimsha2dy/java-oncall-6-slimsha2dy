package oncall.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
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
