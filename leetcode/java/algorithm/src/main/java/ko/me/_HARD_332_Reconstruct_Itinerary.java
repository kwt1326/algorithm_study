package ko.me;

import java.util.*;

// DFS, PriorityQueue
// https://leetcode.com/problems/reconstruct-itinerary/description/
public class _HARD_332_Reconstruct_Itinerary {

    public static void dfs(
            final String cur,
            final Map<String, PriorityQueue<String>> map,
            final LinkedList<String> answer
    ) {
        final PriorityQueue<String> pq = map.get(cur);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, answer);
        }
        answer.addFirst(cur);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        final LinkedList<String> answer = new LinkedList<>();
        final Map<String, PriorityQueue<String>> inj = new HashMap<>();

        for (List<String> fromTo : tickets) {
            final PriorityQueue<String> v = inj.getOrDefault(fromTo.get(0), new PriorityQueue<>());
            v.add(fromTo.get(1));
            inj.put(fromTo.get(0), v);
        }
        dfs("JFK", inj, answer);

        return answer;
    }

    public static void main(String[] args) {
        final List<List<String>> tickets = List.of(
                List.of("JFK","KUL"),
                List.of("JFK","NRT"),
                List.of("NRT","JFK")
        );
        final List<String> expect = List.of("JFK","NRT","JFK","KUL");
        assert findItinerary(tickets).equals(expect);
    }
}
