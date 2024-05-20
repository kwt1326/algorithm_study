package ko.me;

import java.util.*;

/**
 * DFS, BackTracking
 * 요구하는 숫자에 포함된 모든 스펠링의 정해진 길이의 조합을 만들면 된다.
 * */
public class _17_Letter_Combinations_of_a_Phone_Number {
    public static void dfs(String state, int i, String[] split, Map<Integer, Character[]> map, Set<String> set) {
        if (state.length() == split.length) {
            set.add(state);
            return;
        }

        String cur = split[i];
        Character[] chars = map.get(Integer.valueOf(cur));

        for (Character c : chars) {
            String newStr = state + c;
            dfs(newStr, i + 1, split, map, set);
        }
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, Character[]> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});

        if (digits.isEmpty()) return new ArrayList<>();

        String[] split = digits.split("");

        dfs("", 0, split, map, set);

        return set.stream().toList();
    }

    public static void main(String[] args) {
        final String digits = "23";
        assert List.of("cd","bd","ce","ad","be","cf","ae","bf","af").equals(letterCombinations(digits));
    }
}
