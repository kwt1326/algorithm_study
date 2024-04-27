package ko.me;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

// 우선순위 큐로 쉽게 풀수 있는 문제
// http://leetcode.com/problems/k-closest-points-to-origin/
public class _973_k_closest_points_to_origin {

    public static int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> comparator = (o1, o2) -> {
            int a = o1[1];
            int b = o2[1];
            return Integer.compare(a, b);
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

        // 유클리드 거리 계산상 sqrt()(제곱근) 값을 비교하지만, 성능상 제곱한 값으로 비교하는 것이 훨씬 빠르고 정확도에 차이가 없다.
        for (int i = 0; i < points.length; ++i) {
            int[] point = points[i];
            int[] data = {i, (int) Math.round(Math.pow(point[0], 2) + Math.pow(point[1], 2))};
            pq.add(data);
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; ++i) {
            int idx = Objects.requireNonNull(pq.poll())[0];
            result[i] = points[idx];
        }

        return result;
    }
}
