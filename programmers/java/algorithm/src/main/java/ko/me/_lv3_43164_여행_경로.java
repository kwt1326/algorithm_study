package ko.me;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/43164?language=java
public class _lv3_43164_여행_경로 {

    public static class Solution {
        public void dfs(
                final String cur,
                final Map<String, PriorityQueue<String>> inj,
                final LinkedList<String> answer
        ) {
            final PriorityQueue<String> pq = inj.get(cur);
            while (pq != null && !pq.isEmpty()) {
                dfs(pq.poll(), inj, answer);
            }
            answer.addFirst(cur);
        }

        public String[] solution(String[][] tickets) {
            final LinkedList<String> answer = new LinkedList<>();

            final Map<String, PriorityQueue<String>> inj = new HashMap<>();

            for (final String[] ticket : tickets) {
                inj.putIfAbsent(ticket[0], new PriorityQueue<>());
                inj.get(ticket[0]).add(ticket[1]);
            }

            dfs("ICN", inj, answer);

            return answer.toArray(String[]::new);
        }
    }

    public static void main(String[] args) {
        final String[][] tickets = new String[][]{
                new String[]{"ICN", "JFK"},
                new String[]{"HND", "IAD"},
                new String[]{"JFK", "HND"}
        };
        final String[] expect = new String[]{"ICN", "JFK", "HND", "IAD"};
        assert Arrays.equals(new Solution().solution(tickets), expect);
    }
}
