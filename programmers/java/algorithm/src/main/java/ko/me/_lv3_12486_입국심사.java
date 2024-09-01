package ko.me;

public class _lv3_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        Arrays.sort(times);

        for (int i = 0; i < times.length; ++i) {
            map.put(i, false);
        }

        while (n > 0) {
            for (int i = 0; i < times.length; ++i) {
                if (map.get(i) == 0) {
                    n--;
                    map.put(i, times[i]);
                }
                else if (map.get(i) > 0) {
                    map.put(i, map.get(i) - 1);
                }
            }

            answer++;
        }

        return answer;
    }
}
