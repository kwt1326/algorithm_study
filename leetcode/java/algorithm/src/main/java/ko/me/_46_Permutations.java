package ko.me;

import java.util.*;

// DFS, 순열 구하기
// C++ 의 경우 next_permutation 메서드가 std 라이브러리에 존재하지만, Java 에서는 직접 구현해야만 한다. (불편!) 하지만 비교적 간단하다.
// https://leetcode.com/problems/permutations/description/
public class _46_Permutations {
    private static final List<List<Integer>> result = new ArrayList<>();

    public static void dfs(List<Integer> state, int[] nums) {
        if (state.size() == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }

        for (int num : nums) {
            if (state.contains(num)) {
                continue;
            }

            state.add(num);
            dfs(state, nums);
            state.removeLast();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList<>(), nums);
        final List<List<Integer>> answer = new ArrayList<>(result);
        result.clear(); // 리트코드 에서는 테스트 케이스를 돌릴 때 기존 result 가 남아있음
        return answer;
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{1, 2, 3};
        final List<List<Integer>> accept = List.of(
                List.of(1,2,3),
                List.of(1,3,2),
                List.of(2,1,3),
                List.of(2,3,1),
                List.of(3,1,2),
                List.of(3,2,1)
        );
        assert permute(nums).equals(accept);
    }
}
