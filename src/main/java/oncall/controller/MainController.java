package oncall.controller;

import java.util.List;

import oncall.view.InputView;
import oncall.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
    }

    private void initializeCalender() {
        List<String> inputs = inputView.readMonthAndDay();
    }
}
