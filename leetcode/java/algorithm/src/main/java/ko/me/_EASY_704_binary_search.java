package ko.me;

// Binary Search
// https://leetcode.com/problems/binary-search
public class _EASY_704_binary_search {
    private static int result = -1;

    private static void recursive(int left, int right, int[] nums, int target) {
        if (left <= right) {
            final int mid = left + (right - left / 2); // blocking stack overflow
            if (nums[mid] == target) {
                result = mid;
                return;
            }
            if (nums[mid] < target) {
                recursive(mid + 1, right, nums, target);
            } else {
                recursive(left, mid - 1, nums, target);
            }
        }
    }

    public static int search(final int[] nums, final int target) {
        recursive(0, nums.length - 1, nums, target);
        return result;
    }

    public static void main(String[] args) {
        final int[] nums = {-1, 0, 3, 5, 9, 12};
        final int target = 9;
        assert search(nums, target) == 4;
    }
}
