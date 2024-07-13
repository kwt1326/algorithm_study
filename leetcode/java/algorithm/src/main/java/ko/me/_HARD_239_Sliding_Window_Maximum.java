package ko.me;

import java.util.*;

// Sliding Window
// https://leetcode.com/problems/sliding-window-maximum
public class _HARD_239_Sliding_Window_Maximum {

    // 일반 브루트포스 시간초과, 우선순위 큐 사용해도 시간초과.
    // max 를 순회하면서 구하는 동작을 우회해서 최적화 해야 한다.
    // 구간 별로 가장 큰 값을 제외한 나머지 값의 인덱스를 저장하고, 삭제한다.
    // 첫 인덱스는 윈도우 이동시 삭제하기 위해 삭제 메서드가 필요
    // Deque, LinkedList 를 사용하면 인덱스의 삽입 위치를 보존하면서 삽입/삭제하기 좋다.

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!linkedList.isEmpty() && linkedList.peekFirst() < i - k + 1) {
                linkedList.pollFirst();
            }

            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] < nums[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);

            if (i >= k - 1 && !linkedList.isEmpty()) {
                result.add(nums[linkedList.peekFirst()]);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] expect = {3,3,5,5,6,7};
        assert Arrays.equals(maxSlidingWindow(nums, 3), expect);
    }
}
