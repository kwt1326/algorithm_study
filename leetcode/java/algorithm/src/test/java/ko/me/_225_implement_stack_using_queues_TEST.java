package ko.me;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _225_implement_stack_using_queues_TEST {
    @Test
    void 스택_구현_테스트() {
        _225_implement_stack_using_queues.Stack_ImplUsingQueue<Integer> stack = new _225_implement_stack_using_queues.Stack_ImplUsingQueue<>();
        stack.push(1);
        stack.push(2);
        assertThat(stack.top()).isEqualTo(2); // return 2
        assertThat(stack.pop()).isEqualTo(2); // return 2
        assertThat(stack.empty()).isFalse(); // return False
    }
}