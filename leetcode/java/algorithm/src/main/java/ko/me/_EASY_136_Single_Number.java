package ko.me;

import java.util.Arrays;

// BitMask
// https://leetcode.com/problems/single-number
public class _EASY_136_Single_Number {

    // 모든 값을 XOR 하면, 배타적 비트 연산 특성상 최종적으로 하나의 값만 남게 된다.
    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (p, c) -> p ^ c);
    }

    public static void main(String[] args) {
        final int[] nums = {4,1,2,1,2};
        assert singleNumber(nums) == 4;
    }
}
