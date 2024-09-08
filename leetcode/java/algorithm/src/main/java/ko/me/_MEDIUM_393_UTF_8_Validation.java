package ko.me;

// Bit
public class _MEDIUM_393_UTF_8_Validation {

    // UTF-8 에 대한 문제 설명은 문제를 봐서는 직관적으로 이해하기 매우 어려우므로, 관련 영상을 본뒤 문제를 보도록 하자
    public static boolean validUtf8(int[] data) {
        int numberOfBytesToProcess = 0; // 모든 바이트가 처리되었는지 확인

        for (int currentByte : data) {
            // 처음 바이트는 상위 8비트만 필요하므로 비트 연산을 사용하여 8비트로 제한
            if (numberOfBytesToProcess == 0) {
                if ((currentByte >> 5) == 0b110) {
                    numberOfBytesToProcess = 1; // 2바이트 문자
                } else if ((currentByte >> 4) == 0b1110) {
                    numberOfBytesToProcess = 2; // 3바이트 문자
                } else if ((currentByte >> 3) == 0b11110) {
                    numberOfBytesToProcess = 3; // 4바이트 문자
                } else if ((currentByte >> 7) != 0) {
                    // 1바이트 문자는 상위 비트가 0이어야 한다.
                    return false;
                }
            } else {
                // 연속하는 바이트는 '10xxxxxx' 형식이어야 함
                if ((currentByte >> 6) != 0b10) {
                    return false;
                }
                numberOfBytesToProcess--;
            }
        }

        return numberOfBytesToProcess == 0;
    }

    public static void main(String[] args) {
        assert validUtf8(new int[]{197, 130, 1});
    }
}
