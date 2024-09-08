package ko.me;

// Bit
public class _MEDIUM_371_Sum_of_Two_Integers {

    static public int getSum(int a, int b) {
        // 두 번째 숫자가 0이 아닌 동안 반복
        while (b != 0) {
            // 비트 AND 연산으로 캐리(carry) 비트를 계산
            int carryBits = a & b;

            // 캐리 비트를 왼쪽으로 한 칸 이동 (다음 자리로 이동)
            carryBits <<= 1;

            // XOR 연산으로 두 수의 합을 계산 (캐리 없이)
            a = a ^ b;

            // 두 번째 숫자는 캐리 비트로 설정
            b = carryBits;
        }
        return a;
    }

    public static void main(String[] args) {
        assert getSum(1, 2) == 3;
    }
}
