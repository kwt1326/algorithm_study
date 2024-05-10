package ko.me;

public class _706_design_hashmap {
    public static class MyHashMap {
        private class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        private Node[] buckets;
        private int capacity;

        public MyHashMap() {
            capacity = 10000; // 초기 용량 디폴트 설정
            buckets = new Node[capacity];
        }

        // 나머지 연산
        private int hash(int key) {
            return Math.abs(key % capacity);
        }

        public void put(int key, int value) {
            int index = hash(key);
            Node current = buckets[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value; // 키가 이미 존재하면 값만 갱신
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode; // 새 노드를 버킷의 시작 부분에 삽입
        }

        public int get(int key) {
            int index = hash(key);
            Node current = buckets[index];
            while (current != null) {
                if (current.key == key) {
                    return current.value; // 일치하는 키를 찾으면 해당 값 반환
                }
                current = current.next;
            }
            return -1; // 키가 맵에 존재하지 않을 때
        }

        public void remove(int key) {
            int index = hash(key);
            Node current = buckets[index];
            Node prev = null;
            while (current != null) {
                if (current.key == key) {
                    if (prev != null) {
                        prev.next = current.next; // 이전 노드가 현재 노드를 건너뛰도록 조정
                    } else {
                        buckets[index] = current.next; // 버킷의 첫 노드를 제거
                    }
                    return;
                }
                prev = current;
                current = current.next;
            }
        }
    }
}
