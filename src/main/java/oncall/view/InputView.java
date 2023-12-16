package oncall.view;

import java.util.List;

import oncall.util.Utility;
import oncall.util.Validator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<String> readMonthAndDay() {
        System.out.print(Message.INPUT_MONTH_DAY.get());
        String input = Console.readLine();
        Validator.validateFirstInput(input);
        return Utility.splitWithComma(input);
    }

    private enum Message {
        INPUT_MONTH_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String get() {
            return this.message;
        }
    }
}
