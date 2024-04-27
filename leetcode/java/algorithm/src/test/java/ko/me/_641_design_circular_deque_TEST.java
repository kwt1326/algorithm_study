package ko.me;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _641_design_circular_deque_TEST {

    @Test
    void 데크_구현_테스트() {
        _641_design_circular_deque.Deque myCircularDeque = new _641_design_circular_deque.Deque(3);
        assertThat(myCircularDeque.insertLast(1)).isTrue();
        assertThat(myCircularDeque.insertLast(2)).isTrue();
        assertThat(myCircularDeque.insertFront(3)).isTrue();
        assertThat(myCircularDeque.insertFront(4)).isFalse(); // the queue is full.
        assertThat(myCircularDeque.getRear()).isEqualTo(2);
        assertThat(myCircularDeque.isFull()).isTrue();
        assertThat(myCircularDeque.deleteLast()).isTrue();
        assertThat(myCircularDeque.insertFront(4)).isTrue();
        assertThat(myCircularDeque.getFront()).isEqualTo(4);
    }

    @Test
    void 데크_구현_테스트2() {
        _641_design_circular_deque.Deque myCircularDeque = new _641_design_circular_deque.Deque(4);
        assertThat(myCircularDeque.insertFront(80)).isTrue();
        assertThat(myCircularDeque.insertFront(27)).isTrue();
        assertThat(myCircularDeque.deleteLast()).isTrue();
        assertThat(myCircularDeque.insertFront(60)).isTrue(); // the queue is full.
        assertThat(myCircularDeque.insertFront(81)).isTrue();
        assertThat(myCircularDeque.getRear()).isEqualTo(27);
        assertThat(myCircularDeque.getFront()).isEqualTo(81);
        assertThat(myCircularDeque.getRear()).isEqualTo(27);
        assertThat(myCircularDeque.getRear()).isEqualTo(27);
    }
}