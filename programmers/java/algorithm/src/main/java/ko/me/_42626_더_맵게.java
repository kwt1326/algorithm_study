package ko.me;

import java.util.PriorityQueue;

// 우선순위 큐로 쉽게 풀수 있는 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class _42626_더_맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (!pq.isEmpty()) {
            final int first = pq.poll();

            if (first >= K) {
                return answer;
            }

            if (pq.isEmpty()) break;

            final int second = pq.poll();
            final int newValue = first + (second * 2);
            answer += 1;
            pq.add(newValue);
        }

        return -1;
    }

    public static void main(String[] args) {
        // input
        final int K = 7;
        final int[] scoville = new int[]{1, 2, 3, 9, 10, 121};
        System.out.println(solution(scoville, K));
    }
}
