package ko.me;

import java.util.Arrays;

public class _MEDIUM_167_Two_Sum_II_Input_Array_Is_Sorted {

    // 이진 탐색으로 정렬된 배열의 두 인덱스를 찾는 경우, (target - 현재 값)을 찾아야 하는데
    // 현재 값을 구하는데 사용된 중복 값 인덱스 필터링을 위해 이진 탐색 범위를 (현재 값 + 1 ~ 최대 인덱스) 로 지정한다.
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int findTarget = target - numbers[i];
            int searchIdx = Arrays.binarySearch(numbers, i + 1, numbers.length, findTarget);
            if (searchIdx >= 0) {
                return new int[]{i + 1, searchIdx + 1};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }
}
