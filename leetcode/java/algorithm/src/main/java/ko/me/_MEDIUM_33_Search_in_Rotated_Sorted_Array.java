package ko.me;

// Binary Search
public class _MEDIUM_33_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 좌-우측 중, 정렬된 부분만 target 을 검사한다. pivot 이 유효한 부분만 정상적으로 탐색이 가능하기 때문이다.
        while (left <= right) {
            // mid 값 overflow 방지
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 좌측 정상 정렬 확인 후 타겟 위치 확인
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 우측 정상 정렬 확인 후 타겟 위치 확인
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
