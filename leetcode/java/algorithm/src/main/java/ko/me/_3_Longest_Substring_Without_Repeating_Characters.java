package ko.me;

import java.util.HashMap;

/**
 * Sliding Window & Two Pointer 문제
 * 투 포인터 기법으로 윈도우 범위를 움직여 가장 긴 부분 문자열을 추출한다.
 * */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        final HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            // left 는 0 혹은 이미 등장한 문자열이 갱신된 인덱스 + 1
            // 새 문자가 이미 윈도우 안에서 발견됐다면, left 를 아예 새 문자 다음 인덱스로 옮긴다.
            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            } else {
                max = Math.max(max, r - l + 1);
            }
            // 문자 : 인덱스 삽입 후 right 지속적으로 움직이기
            map.put(c, r);
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        final String s1 = "abcabcbb";
        final String s2 = "bbbbb";
        final String s3 = "pwwkew";
        final String s4 = " ";
        assert lengthOfLongestSubstring(s1) == 3: lengthOfLongestSubstring(s1); // 3
        assert lengthOfLongestSubstring(s2) == 1: lengthOfLongestSubstring(s2); // 1
        assert lengthOfLongestSubstring(s3) == 3: lengthOfLongestSubstring(s3); // 3
        assert lengthOfLongestSubstring(s4) == 1: lengthOfLongestSubstring(s4); // 1
        System.out.println("Success");
    }
}
