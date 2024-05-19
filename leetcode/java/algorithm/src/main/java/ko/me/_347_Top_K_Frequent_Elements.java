package ko.me;

import java.util.*;

/**
 * Hash Map 문제
 * 출력이 귀찮은 문제이다.
 * */
public class _347_Top_K_Frequent_Elements {
    public record Pair(int k, int v) {}

    public static int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> counter = new HashMap<>();
        final List<Pair> list = new ArrayList<>();

        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        for (int key : counter.keySet()) {
            list.add(new Pair(key, counter.get(key)));
        }

        list.sort((Pair a, Pair b) -> b.v - a.v);

        return list.subList(0, k).stream().map(pair -> pair.k)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        final int[] nums1 = new int[]{1,1,1,2,2,3};
        final int k1 = 2;
        final int[] nums2 = new int[]{1};
        final int k2 = 1;
        assert Arrays.equals(topKFrequent(nums1, k1), new int[]{1, 2});
        assert Arrays.equals(topKFrequent(nums2, k2), new int[]{1});
    }
}
