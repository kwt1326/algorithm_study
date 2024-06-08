package ko.me;

// https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class _lv2_12985_예상_대진표_
{
    public int solution(int n, int a, int b)
    {
        int round = 1;

        while (n > 1) {
            for (int i = 1; i <= n; i += 2) {
                if (i == a && i + 1 == b || i == b && i + 1 == a) {
                    return round;
                }
            }
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            n = n / 2;
            round += 1;
        }

        return round;
    }
}