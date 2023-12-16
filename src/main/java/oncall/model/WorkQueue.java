package oncall.model;

import java.util.ArrayList;
import java.util.List;

import oncall.util.Validator;
import oncall.util.ErrorMessage;

public class WorkQueue {
    List<String> nameQueue;

    public WorkQueue(List<String> input) {
        Validator.validateWorkQueue(input);
        nameQueue = new ArrayList<>();
        for (String string : input) {
            if (nameQueue.contains(string)) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
            }
            nameQueue.add(string);
        }
    }

    public int size() {
        return this.nameQueue.size();
    }

    public boolean haveEqualMember(WorkQueue other) {
        for (String name : nameQueue) {
            if (!other.nameQueue.contains(name)) {
                return false;
            }
        }
        return true;
    }
}
