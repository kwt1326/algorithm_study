package ko.me.dataStructure;

import java.util.ArrayList;
import java.util.List;

// 이진 힙 (최소 힙)
public class BinaryHeap {

    private final List<Integer> heap = new ArrayList<>();

    public BinaryHeap() {
        heap.add(null); // start index 1
    }

    public void insert(final int n) {
        heap.add(n);
        bubbleUp(); // 마지막 노드 추가 후 힙 균형 유지 작업 수행
    }

    public int extract() {
        final int root = heap.get(1); // 루트 노드 추출
        final int lastIdx = heap.size() - 1;
        heap.set(1, heap.get(lastIdx)); // 마지막 값을 루트로 지정
        heap.remove(lastIdx); // 루트로 이동 후 마지막 값 삭제
        bubbleDown(1); // 이진 힙 균형 유지 작업 수행, 루트 노드 부터 수행
        return root;
    }

    //region Private Methods

    // 이진 힙을 구성하기 위한 부모 노드와의 재귀적 swap 수행하여 균형 유지
    private void bubbleUp() {
        int curIdx = heap.size() - 1; // start last index
        int parentIdx = curIdx / 2;

        while (parentIdx > 0) {
            // 최소 힙이면 부모보다 자식이 작으면 swap 하지만, "최대 힙"이면 부호가 반대가 된다.
            if (heap.get(parentIdx) > heap.get(curIdx)) {
                swap(curIdx, parentIdx);
            }
            curIdx = parentIdx;
            parentIdx = parentIdx / 2;
        }
    }

    // 노드 추출 후 이진 힙 특성을 유지하기 위한 반대 방향 swap 수행
    private void bubbleDown(final int startIdx) {
        int lastIdx = heap.size() - 1;
        int leftIdx = startIdx * 2; // 이진 힙은 현재 위치의 2배마다 자식의 인덱스가 존재한다.
        int rightIdx = startIdx * 2 + 1;
        int smallestIdx = startIdx;

        // 왼쪽 자식노드가 존재하고, 자식이 부모보다 작을 경우 왼쪽 자식노드를 가장 작은 노드로 지정
        // 최소 힙이면 부모보다 자식이 작으면 swap 하지만, "최대 힙"이면 부호가 반대가 된다.
        if (leftIdx <= lastIdx && heap.get(leftIdx) < heap.get(smallestIdx)) {
            smallestIdx = leftIdx;
        }
        // 오른쪽 자식노드가 존재하고, 자식이 부모보다 작을 경우 오른쪽 자식노드를 가장 작은 노드로 지정
        // 최소 힙이면 부모보다 자식이 작으면 swap 하지만, "최대 힙"이면 부호가 반대가 된다.
        if (rightIdx <= lastIdx && heap.get(rightIdx) < heap.get(smallestIdx)) {
            smallestIdx = rightIdx;
        }

        // 가장 작은 노드의 인덱스가 시작 인덱스와 다르면 swap 처리 후 반복 수행
        if (smallestIdx != startIdx) {
            swap(smallestIdx, startIdx);
            bubbleDown(smallestIdx);
        }
    }

    private void swap(final int s, final int t) {
        int temp = heap.get(s);
        heap.set(s, heap.get(t));
        heap.set(t, temp);
    }
    //endregion
}
