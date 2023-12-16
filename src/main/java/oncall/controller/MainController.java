package oncall.controller;

import java.util.List;

import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.model.Calender;
import oncall.model.WorkQueue;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private Calender calender;
    private WorkQueue weekdayWorkQueue;
    private WorkQueue weekendWorkQueue;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeCalender();
        makeWorkQueue();
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

    private void makeWorkQueue() {
        try {
            List<String> input = inputView.readWorkQueueWeekDay();
            this.weekdayWorkQueue = new WorkQueue(input);
            input = inputView.readWorkQueueWeekEnd();
            this.weekendWorkQueue = new WorkQueue(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeWorkQueue();
        }
    }
}
