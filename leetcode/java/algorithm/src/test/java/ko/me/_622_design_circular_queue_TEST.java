package ko.me;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _622_design_circular_queue_TEST {

    @Test
    void 원형_큐_구현_테스트() {
        _622_design_circular_queue.CircularQueue circularQueue = new _622_design_circular_queue.CircularQueue(3);
        assertThat(circularQueue.enQueue(1)).isTrue(); // return True
        assertThat(circularQueue.enQueue(2)).isTrue(); // return True
        assertThat(circularQueue.enQueue(3)).isTrue(); // return True
        assertThat(circularQueue.enQueue(4)).isFalse(); // return False
        assertThat(circularQueue.Rear()).isEqualTo(3);    // return 3
        assertThat(circularQueue.isFull()).isTrue();   // return True
        assertThat(circularQueue.deQueue()).isTrue();  // return True
        assertThat(circularQueue.enQueue(4)).isTrue(); // return True
        assertThat(circularQueue.Rear()).isEqualTo(4);     // return 4
    }
}
