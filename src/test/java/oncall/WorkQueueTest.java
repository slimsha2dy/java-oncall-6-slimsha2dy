package oncall;

import oncall.*;

import oncall.model.WorkQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkQueueTest {

    @DisplayName("WorkQueue.getNext가 잘 작동하는지 확인")
    @Test
    void getNextWell() {
        WorkQueue workQueue = new WorkQueue(List.of("안녕", "하세", "요구", "루트", "아줌"));
        assertThat(workQueue.getNext("하세")).isEqualTo("안녕");
        assertThat(workQueue.getNext("하세")).isEqualTo("요구");
        assertThat(workQueue.getNext("안녕")).isEqualTo("하세");
        assertThat(workQueue.getNext("안녕")).isEqualTo("루트");
    }

    @DisplayName("WorkQueue.getNext가 잘 작동하는지 확인")
    @Test
    void getNextWell2() {
        WorkQueue workQueue = new WorkQueue(List.of("안녕", "하세", "요구", "루트", "아줌"));
        for (int i = 0; i < 5; ++i) {
            workQueue.getNext("하이");
        }
        assertThat(workQueue.getNext("하이")).isEqualTo("안녕");
    }

    @DisplayName("WorkQueue.getNext가 잘 작동하는지 확인")
    @Test
    void getNextWell3() {
        WorkQueue workQueue = new WorkQueue(List.of("안녕", "하세", "요구", "루트", "아줌"));
        workQueue.getNext("하세");
        workQueue.getNext("하세");
        workQueue.getNext("하이");
        workQueue.getNext("하이");
        workQueue.getNext("하이");
        workQueue.getNext("하이");
        assertThat(workQueue.getNext("하이")).isEqualTo("하세");
        assertThat(workQueue.getNext("하이")).isEqualTo("요구");
    }

    @DisplayName("WorkQueue.getNext가 잘 작동하는지 확인")
    @Test
    void getNextWell4() {
        WorkQueue workQueue = new WorkQueue(List.of("안녕", "하세", "요구", "루트", "아줌"));
        workQueue.getNext("하세");
        workQueue.getNext("하세");
        workQueue.getNext("하이");
        workQueue.getNext("하이");
        workQueue.getNext("하이");
        workQueue.getNext("하이");
        assertThat(workQueue.getNext("하세")).isEqualTo("요구");
        assertThat(workQueue.getNext("하이")).isEqualTo("하세");
        assertThat(workQueue.getNext("하이")).isEqualTo("루트");
        assertThat(workQueue.getNext("하이")).isEqualTo("아줌");
    }
}
