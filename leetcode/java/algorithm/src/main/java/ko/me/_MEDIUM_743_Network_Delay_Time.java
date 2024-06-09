package ko.me;

import java.util.*;

// [Dijkstra], BFS, PriorityQueue, Greedy
// https://leetcode.com/problems/network-delay-time/
public class _MEDIUM_743_Network_Delay_Time {

    // 다익스트라 핵심인 간선 정보
    public record Edge(
            int t, // 간선의 목적지(to) 정점 번호
            int w  // 가중치 (항상 양수)
    ) {
    }

    // 우선순위 큐에서 사용할 노드
    public record Node(
            int v,  // 정점
            int d // 거리
    ) {
    }

    public static int dijkstra(
            final Map<Integer, List<Edge>> graph,
            final int start,
            final int n
    ) {
        // 원래 다익스트라 알고리즘 그대로 구현하려면 이전 노드도 기록해야 하지만, 이 문제는 dist 만으로 충분하다.
        final Map<Integer, Integer> dist = new HashMap<>();
        final Comparator<Node> comparator = Comparator.comparingInt(node -> node.d);
        final PriorityQueue<Node> pq = new PriorityQueue<>(comparator); // 거리 순으로 정렬하는 우선순위 큐 사용

        // 거리 테이블 및 우선순위 큐 초기화
        for (final int v : graph.keySet()) {
            final int d = start == v ? 0 : Integer.MAX_VALUE;
            dist.put(v, d);
            pq.add(new Node(v, d));
        }

        // 우선순위 큐 순회하며 거리 갱신하기
        while (!pq.isEmpty()) {
            final Node node = pq.poll();

            for (final Edge e : graph.get(node.v)) {
                final int alt = e.w + dist.get(node.v);

                if (alt < dist.get(e.t)) {
                    dist.put(e.t, alt);
                    pq.add(new Node(e.t, alt));
                }
            }
        }

        // 전체 방문 크기를 반환해야 하기 때문에 최대값을 리턴한다.
        if (dist.containsKey(n)) {
            final int d = Collections.max(dist.values());
            return d < 0 || d == Integer.MAX_VALUE ? -1 : d;
        }
        return -1;
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        final Map<Integer, List<Edge>> graph = new HashMap<>();

        // 인접 리스트 초기화. to 에 대한 리스트가 없으면 탐색이 불가하기 때문에 빈 리스트를 넣어준다.
        for (int[] t : times) {
            final int from = t[0];
            final int to = t[1];
            final int w = t[2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Edge(to, w));
            graph.putIfAbsent(to, new ArrayList<>());
        }

        return dijkstra(graph, k, n);
    }

    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}, {2, 1, 3}};
        int n = 2, k = 2;
        assert networkDelayTime(times, n, k) == 3;
    }
}
