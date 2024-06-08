package ko.me;

import java.util.*;

// https://leetcode.com/problems/course-schedule/description/
public class _MEDIUM_207_Course_Schedule {
    public static boolean isCycle(
            final int cur,
            final boolean[] processed,
            final boolean[] processing,
            final Map<Integer, List<Integer>> inj
    ) {
        processed[cur] = true;
        processing[cur] = true;
        final List<Integer> nodes = inj.getOrDefault(cur, List.of());

        for (final Integer node : nodes) {
            // 해당 노드가 이미 처리되었을 경우, 빠져나옴
            if (processing[node]) {
                return true;
            }
            // 아직 해당 노드가 처리되지 않았을 경우, 다음 깊이 탐색
            if (!processed[node]) {
                if (isCycle(node, processed, processing, inj)) {
                    return true;
                }
            }
        }
        processing[cur] = false;
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        final Map<Integer, List<Integer>> inj = new HashMap<>();
        final boolean[] processed = new boolean[numCourses];
        final boolean[] processing = new boolean[numCourses];

        if (prerequisites.length == 0) {
            return true;
        }

        for (final int[] p : prerequisites) {
            inj.putIfAbsent(p[1], new ArrayList<>());
            inj.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (!processed[i]) {
                if (isCycle(i, processed, processing, inj)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{new int[]{1, 0}};
        assert canFinish(numCourses1, prerequisites1);

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        assert !canFinish(numCourses2, prerequisites2);
    }
}
