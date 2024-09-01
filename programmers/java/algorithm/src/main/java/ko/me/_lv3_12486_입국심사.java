package ko.me;

import java.util.*;

public class _lv3_12486_입국심사 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(times);

        System.out.println(Arrays.toString(times));

        for (int i = 0; i < times.length; ++i) {
            map.put(i, times[i]);
        }

        while (n > 0) {
            for (int i = 0; i < times.length; ++i) {
                if (map.get(i) > 0) {
                    map.put(i, map.get(i) - 1);
                    if (map.get(i) == 0) {
                        n--;
                        map.put(i, times[i]);
                    }
                }
            }

            answer++;
        }

        return answer;
    }

    public static long solution2(int n, int[] times) {
        long minTime = 1;
        long maxTime = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = maxTime;

        // 시간을 이진 탐색으로 갱신해서 최솟값을 사용하도록 하는 방법
        while (minTime <= maxTime) {
            long midTime = minTime + (maxTime - minTime) / 2;
            long processedPeople = 0;

            // 각 심사관의 심사시간으로 중간값을 나눠서 합산
            for (int time : times) {
                processedPeople += midTime / time;
            }

            // 합산 시간이 남은 사람 수보다 크면 최종 소요시간 (정답) 으로 갱신
            if (processedPeople >= n) {
                answer = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution2(6, new int[]{7, 10});
    }
}
