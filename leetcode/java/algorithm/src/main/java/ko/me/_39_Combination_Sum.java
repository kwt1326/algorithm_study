package ko.me;

import java.util.*;

// DFS, Backtracking
// https://leetcode.com/problems/combination-sum/description/
public class _39_Combination_Sum {
    private static final List<List<Integer>> output = new ArrayList<>();

    public static void bt(final List<Integer> state, final int idx, final int[] candidates, final int target) {
        final int sum = state.stream().reduce(0, Integer::sum);
        if (sum >= target) {
            if (sum == target) {
                output.add(new ArrayList<>(state));
            }
            return;
        }

        for (int i = idx; i < candidates.length; ++i) {
            final int c = candidates[i];
            state.add(c);
            // 일반 조합과 달리, 중복 조합이기 때문에 i 를 다시 넣어준다.
            bt(state, i, candidates, target);
            state.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        bt(new ArrayList<>(), 0, candidates, target);
        return output;
    }

    public static void main(String[] args) {
        final int[] candidates = new int[]{2, 3, 6, 7};
        final int target = 7;
        final List<List<Integer>> actual = new ArrayList<>(List.of(List.of(2, 2, 3), List.of(7)));
        assert combinationSum(candidates, target).equals(actual);
    }
}
