package ko.me;

import java.util.*;

// Graph, BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class _lv2_가장_먼_노드 {
    public static int solution(int n, int[][] vertex) {
        final int length = n + 1;

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 추가
        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // BFS 초기화
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[length];
        int[] distance = new int[length];

        queue.add(1);
        visited[1] = true;

        // BFS 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distance[neighbor] = distance[current] + 1;
                }
            }
        }

        // 최대 거리 계산
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
            }
        }

        // 가장 멀리 있는 노드 개수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2} };
        assert solution(n, vertex) == 3;
    }
}

