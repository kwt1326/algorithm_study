package ko.me;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
public class _lv3_42638_이중우선순위큐 {

    // 최소 힙 자료구조에서는 마지막 값을 보장할 수 없기 때문에 최대 힙을 별도로 구현하여 동기화(syncronize) 시켜야 한다.
    // PriorityQueue 자료구조를 사용하는데, Python 에서는 PriorityQueue 자료형을 사용하면 테스트에 실패하기 때문에 heapq 자료구조를 사용해야 한다.
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] parts = op.split(" ");
            String o = parts[0];
            int v = Integer.parseInt(parts[1]);

            if (o.equals("I")) {
                minHeap.add(v);
                maxHeap.add(v);
            } else if (o.equals("D")) {
                if (v == 1 && !maxHeap.isEmpty()) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (v == -1 && !minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        int[] result = new int[2];
        if (!maxHeap.isEmpty()) {
            result[0] = maxHeap.poll();
        }
        if (!minHeap.isEmpty()) {
            result[1] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] operations = {"I 16", "D 1"};
        int[] result = solution(operations);
        System.out.println(result[0] + " " + result[1]); // Expected output: 0 0
    }
}
