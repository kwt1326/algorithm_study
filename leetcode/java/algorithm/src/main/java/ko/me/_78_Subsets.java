package ko.me;

import java.util.*;

// DFS, Backtracking
// https://leetcode.com/problems/subsets/description/
public class _78_Subsets {
    private static final List<List<Integer>> output = new ArrayList<>();

    public static void bt(final List<Integer> state, final int idx, final int n, final int[] nums) {
        if (state.size() == n) {
            output.add(new ArrayList<>(state));
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            state.add(nums[i]);
            bt(state, i + 1, n, nums);
            state.removeLast();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; ++i) {
            bt(new ArrayList<>(), 0, i, nums);
        }
        return output;
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{1, 2, 3};
        final List<List<Integer>> actual = new ArrayList<>(
                List.of(
                        List.of(),
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of(1, 2),
                        List.of(1, 3),
                        List.of(2, 3),
                        List.of(1, 2, 3)
                )
        );
        assert subsets(nums).equals(actual);
    }
}
