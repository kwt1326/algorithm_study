package ko.me;

import java.util.*;

// Dijkstra
// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class _MEDIUM_787_Cheapest_Flights_Within_K_Stops {

    public record Edge(int t, int w) {
    }

    public record Node(int v, int d, int visit) {
    }

    public static int dijkstra(
            final Map<Integer, List<Edge>> graph,
            final int src,
            final int dst,
            final int k
    ) {
        final Comparator<Node> comparator = Comparator.comparingInt(node -> node.d);
        final PriorityQueue<Node> pq = new PriorityQueue<>(comparator);
        final Map<Integer, Integer> visits = new HashMap<>();

        // 제약사항 때문에 처음부터 pq 에 모든 노드를 넣어놓지 않는다.
        pq.add(new Node(src, 0, 0));

        // 우선순위 큐 순회시, k 보다 방문 횟수가 작을 때에만 노드를 추가해서 거리를 갱신한다.
        while (!pq.isEmpty()) {
            final Node node = pq.poll();

            // 최종 노드 발견시 이미 엣지 값이 계산되어 있으므로 바로 리턴
            if (node.v == dst) {
                return node.d;
            }

            // 방문 기록
            visits.put(node.v, node.visit);

            if (node.visit <= k) {
                // 방문 수 늘리기
                final int visit = node.visit + 1;

                if (graph.containsKey(node.v)) {
                    for (final Edge e : graph.get(node.v)) {
                        if (!visits.containsKey(e.t) || visit < visits.get(e.t)) {
                            final int alt = node.d + e.w;
                            pq.add(new Node(e.t, alt, visit));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final Map<Integer, List<Edge>> graph = new HashMap<>();

        // 인접 리스트 그래프 구성하기
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int value = flight[2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Edge(to, value));
        }

        return dijkstra(graph, src, dst, k);
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        assert findCheapestPrice(4, flights, 0, 3, 1) == 700;
    }
}
