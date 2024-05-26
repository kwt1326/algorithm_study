package ko.me;

import java.util.*;

// DFS, Backtracking
// https://leetcode.com/problems/combinations/
public class _77_Combinations {
    private static final List<List<Integer>> output = new ArrayList<>();

    public static void bt(final List<Integer> state, final int i, final int n, final int k) {
        if (state.size() == k) {
            output.add(new ArrayList<>(state));
            return;
        }

        for (int j = i; j <= n; ++j) {
            state.add(j);
            bt(state, j + 1, n, k);
            state.removeLast();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        bt(new ArrayList<>(), 1, n, k);

        return output;
    }

    public static void main(String[] args) {
        final List<List<Integer>> actual = new ArrayList<>(
                List.of(
                        List.of(1, 2),
                        List.of(1, 3),
                        List.of(1, 4),
                        List.of(2, 3),
                        List.of(2, 4),
                        List.of(3, 4)
                )
        );
        assert combine(4, 2).equals(actual);
    }
}
