package ko.me;

// Bit
public class _EASY_91_Number_of_1_Bits {

    // 1을 뺀 값과 & 연산을 할 때마다 비트가 1 씩 빠지는 특성을 이용한 풀이
    // 최종적으로 n == 0 이 되면 counting 결과를 내보내면 된다.
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= n - 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
