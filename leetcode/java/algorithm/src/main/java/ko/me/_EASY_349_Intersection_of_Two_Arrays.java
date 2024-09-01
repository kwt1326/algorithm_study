package ko.me;

import java.util.*;

// Binary Search, Two Pointer
public class _EASY_349_Intersection_of_Two_Arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        nums1 = Arrays.stream(nums1).sorted().toArray();
        nums2 = Arrays.stream(nums2).sorted().toArray();
        Map<Integer, Integer> result = new HashMap<>();

        for (int t : nums1) {
            int l = 0;
            int r = nums2.length - 1;
            int mid;

            while (l <= r) {
                mid = l + (r - l) / 2;
                int cur = nums2[mid];
                if (cur == t && result.get(t) == null) {
                    result.put(t, 1);
                    break;
                }
                if (t < cur) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return result.keySet().stream().mapToInt(k -> k).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4, 6})));
    }
}
