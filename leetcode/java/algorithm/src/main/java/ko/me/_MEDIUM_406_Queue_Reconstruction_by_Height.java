package ko.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Greedy
// https://leetcode.com/problems/queue-reconstruction-by-height
public class _MEDIUM_406_Queue_Reconstruction_by_Height {

    public static int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        for (int[] ps : people) {
            pq.add(ps);
        }

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            result.add(p[1], p);
        }

        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] expect = {{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}};
        assert Arrays.deepEquals(reconstructQueue(people), expect);
    }
}
