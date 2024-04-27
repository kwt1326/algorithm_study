package ko.me;

// 원형 데크 구현 문제
// https://leetcode.com/problems/design-circular-deque/
public class _641_design_circular_deque {
    /**
     * @implNote
     * Java 의 LinkedList 자료구조가 이미 이중 연결 리스트 이기 때문에 바로 사용하면 구현이 끝나지만,
     * 여기서는 이중 연결 리스트를 직접 구현해서 사용한다.
     * 처음에는 head, tail 을 nullable 하게 해서 연결해보려고 했으나, null check 를 하면서 점점 복잡해지게 되어
     * 테스트 케이스를 여러 번 실패했고, 결국 초기 양방향 연결을 하기 위해 매개체를 만들어야 했다.
     *
     * @apiNote
     * left, right: 연결 리스트의 노드. 연결점이 양쪽이기 때문에 prev, next 이름을 이렇게 변경했다.
     * value: 노드가 가지는 값
     * */
    public static class DoubleLinkedList {
        private DoubleLinkedList left;
        private DoubleLinkedList right;
        private final Integer value;

        public DoubleLinkedList(Integer value) {
            this.value = value;
        }
    }

    public static class Deque {
        // 양방향 연결을 위한 매개체 역할 (실제 크기에는 미포함)
        private DoubleLinkedList head = new DoubleLinkedList(-1);
        private DoubleLinkedList tail = new DoubleLinkedList(-1);
        private final int size;
        private int len = 0;

        public Deque(int k) {
            size = k;
            // 양방향 연결 초기화
            head.right = tail;
            tail.left = head;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            // 새 노드를 양방향 링크할 때는 새 노드에서 기존 링크에 먼저 건 뒤, 기존 리스트의 링크 방향을 새 노드에 옮긴다.
            DoubleLinkedList newNode = new DoubleLinkedList(value);
            newNode.right = head.right;
            newNode.left = head;
            head.right.left = newNode;
            head.right = newNode;
            len += 1;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            DoubleLinkedList newNode = new DoubleLinkedList(value);
            newNode.left = tail.left;
            newNode.right = tail;
            tail.left.right = newNode;
            tail.left = newNode;
            len += 1;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            // 노드 삭제시, 포인터 방향만 전환환다. 참조하던 객체가 링크를 잃어버리면 GC 에서 처리한다.
            head.right.right.left = head;
            head.right = head.right.right;
            len -= 1;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            tail.left.left.right = tail;
            tail.left = tail.left.left;
            len -= 1;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;

            return this.head.right.value;
        }

        public int getRear() {
            if (isEmpty()) return -1;

            return this.tail.left.value;
        }

        public boolean isEmpty() {
            return this.len == 0;
        }

        public boolean isFull() {
            return this.len == size;
        }
    }
}
