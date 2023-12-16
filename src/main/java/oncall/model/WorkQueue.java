package oncall.model;

import java.util.ArrayList;
import java.util.List;

import oncall.util.Validator;
import oncall.util.ErrorMessage;

public class WorkQueue {
    List<String> nameQueue;
    int temporaryIndex;
    boolean isSwitchedFlag;

    public WorkQueue(List<String> input) {
        Validator.validateWorkQueue(input);
        nameQueue = new ArrayList<>();
        for (String string : input) {
            if (nameQueue.contains(string)) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.get());
            }
            nameQueue.add(string);
        }
        this.temporaryIndex = 0;
        this.isSwitchedFlag = false;
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

    public String getNext(String name) {
        // 다음 반환할 멤버가 name과 겹칠 경우 순서를 바꿔서 반환함
        if (isSwitchedFlag) {
            return switchedCase();
        }
        String result = nameQueue.get(temporaryIndex);
        temporaryIndex = (temporaryIndex + 1) % nameQueue.size();
        if (!result.equals(name)) {
            return result;
        }
        result = nameQueue.get(temporaryIndex);
        isSwitchedFlag = true;
        return result;
    }

    public String switchedCase() {
        // 이전에 연속이었던 경우, 이전 것을 반환한 후 다음 것을 반환하기 위해 Index를 조정
        int prevIndex = temporaryIndex - 1;
        if (prevIndex < 0) {
            prevIndex += nameQueue.size();
        }
        String result = nameQueue.get(prevIndex);
        temporaryIndex++;
        isSwitchedFlag = false;
        return result;
    }
}
