package oncall.controller;

import java.util.List;

import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.model.Calender;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private Calender calender;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeCalender();
    }

    private void initializeCalender() {
        try {
            List<String> input = inputView.readMonthAndDay();
            this.calender = new Calender(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeCalender();
        }
    }
}
