package ko.me;

import java.util.HashMap;
import java.util.Objects;

// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class _lv1_42576_완주하지_못한_선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        final HashMap<String, Integer> map = new HashMap<>();

        for (final String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (final String p : participant) {
            boolean isContain = map.containsKey(p);
            if (!isContain || map.get(p) == 0) {
                answer = p;
                break;
            }
            map.put(p, map.get(p) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        assert Objects.equals(solution(participant, completion), "leo");
    }
}
