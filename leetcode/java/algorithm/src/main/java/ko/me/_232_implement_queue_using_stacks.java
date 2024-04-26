package ko.me;

import java.util.ArrayDeque;

public class _232_implement_queue_using_stacks {
    public static class Queue_ImplUsingStack<T> {

        private final ArrayDeque<T> stack = new ArrayDeque<>(); // Stack 자료구조는 Java 특성상 사용하지 않는다
        private final ArrayDeque<T> pollStack = new ArrayDeque<>();

        public void push(T item) {
            stack.push(item);
        }

        public T pop() {
            reverseStack();
            return pollStack.pop();
        }

        public T peek() {
            reverseStack();
            return pollStack.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && pollStack.isEmpty();
        }

        /*
         * stack 은 LIFO, 즉 항상 마지막에 넣은 것을 보고 꺼낸다. 그 성질을 이용하면, 역순으로 저장해서 같은 방식으로 사용할 수 있다.
         * 스택을 2개를 사용해서 추출용 스택으로 역순으로 저장해 놓아야 한다.
         * 정렬할 때는 pollStack 이 비었을 때만 수행해야 정렬 순서가 꼬이지 않는다.
         * */
        private void reverseStack() {
            if (pollStack.isEmpty()) {
                while (!stack.isEmpty()) {
                    pollStack.push(stack.pop());
                }
            }
        }
    }
}