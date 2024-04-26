package ko.me;

import java.util.LinkedList;

public class _622_design_circular_queue {
    public static class CircularQueue {
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final int size;
        private int len;
        private int frontIdx;
        private int rearIdx;

        public CircularQueue(int k) {
            size = k;
            len = 0;
            frontIdx = 0;
            rearIdx = -1;
        }

        public boolean enQueue(Integer value) {
            if (isFull()) return false;

            // rear 가 전체 사이즈를 초과하면 사이즈 만큼 제거된 인덱스가 추출된다.
            rearIdx = (rearIdx + 1) % size;
            queue.add(rearIdx, value);
            len++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;

            // front 도 마찬가지로 전체 사이즈를 초과하면 사이즈 만큼 제거된 인덱스가 추출된다.
            frontIdx = (frontIdx + 1) % size;
            queue.remove(frontIdx);
            len--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue.get(frontIdx);
        }

        public int Rear() {
            return isEmpty() ? -1 : queue.get(rearIdx);
        }

        public boolean isEmpty() {
            return len == 0;
        }

        public boolean isFull() {
            return size == len;
        }
    }
}
