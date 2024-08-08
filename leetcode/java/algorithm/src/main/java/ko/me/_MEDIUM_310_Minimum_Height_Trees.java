package ko.me;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/description/
public class _MEDIUM_310_Minimum_Height_Trees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n <= 0) {
            return result;
        } else if (n == 1) {
            result.add(0);
            return result;
        }

        // 그래프와 각 노드의 차수(degree) 초기화
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // 초기 리프 노드들을 큐에 추가
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }

        // 트리를 줄여나가며 리프 노드를 제거
        while (n > 2) {
            final int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                final int leaf = queue.poll();
                for (int neighbor : graph.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) queue.offer(neighbor);
                }
            }
        }

        // 최종적으로 남은 노드들이 최소 높이 트리의 루트
        result.addAll(queue);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        assert findMinHeightTrees(n, edges).equals(expect);
    }
}
