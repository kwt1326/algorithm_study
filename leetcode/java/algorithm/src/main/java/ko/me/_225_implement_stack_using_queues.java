package ko.me;

import java.util.ArrayDeque;
import java.util.Queue;

public class _225_implement_stack_using_queues {
    public static class Stack_ImplUsingQueue<T> {
        private final Queue<T> queue = new ArrayDeque<>();

        public void push(T item) {
            queue.add(item);

            /*
             * 이 부분이 핵심!
             * queue 는 기본적으로 FIFO 구조이기 때문에, 추가하는 순간 맨 앞에 위치해서 순서가 순환되어 LIFO 의 성질을 맞출 수 없다.
             * 따라서 처음부터 큐의 추가/삭제 방향을 스택에 맞추기 위해 데이터를 스택에 넣은 것처럼 정렬해주면 된다.
             * */
            for (int i = 0; i < queue.size() - 1; ++i) {
                queue.add(queue.remove());
            }
        }

        public T pop() {
            return queue.poll();
        }

        public T top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack_ImplUsingQueue<Integer> stack = new Stack_ImplUsingQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.empty()) {
            System.out.println(stack.pop()); // 3 2 1
        }
    }
}