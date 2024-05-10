package ko.me;

import java.util.HashMap;

public class _771_jewels_and_stone {
    public static int numJewelsInStones(String jewels, String stones) {
        final HashMap<String, Integer> map = new HashMap<>();

        for (String s : stones.split("")) {
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
                continue;
            }
            map.put(s, 1);
        }

        int answer = 0;

        for (String j : jewels.split("")) {
            if (map.containsKey(j)) {
                answer += map.get(j);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final String jewels = "aA";
        final String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones) == 3);
    }
}
