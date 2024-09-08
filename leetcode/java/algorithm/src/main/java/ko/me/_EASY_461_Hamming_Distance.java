package ko.me;

// Bit
public class _EASY_461_Hamming_Distance {

    // XOR 연산 후, 1의 개수를 구한다.
    // bitCount 메서드를 사용하지 않고 구현하면, 한 자리씩 비트를 shift 한뒤 & 연산을 수행해서 1의 개수를 카운팅 해야 한다.
    static public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        assert hammingDistance(1, 4) == 2;
    }
}
