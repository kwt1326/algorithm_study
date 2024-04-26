package ko.me;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _232_implement_queue_using_stacks_TEST {

    @Test
    void 큐_구현_테스트() {
        _232_implement_queue_using_stacks.Queue_ImplUsingStack myQueue = new _232_implement_queue_using_stacks.Queue_ImplUsingStack();
        myQueue.push(1); // queue is: [1]
        assertThat(myQueue.peek()).isEqualTo(1);
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertThat(myQueue.peek()).isEqualTo(1);
        assertThat(myQueue.pop()).isEqualTo(1);
        assertThat(myQueue.empty()).isFalse();
    }
}
