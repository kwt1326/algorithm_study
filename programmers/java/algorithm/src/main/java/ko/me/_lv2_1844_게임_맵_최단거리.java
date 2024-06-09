package ko.me;

import java.util.*;

// BFS, 최단 거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class _lv2_1844_게임_맵_최단거리 {

    // Java 의 구리구리한 클래스를 사용하고 싶지 않아 Record 를 시도해봤지만, 프로그래머스 에서는 지원하지 않는 것 같다..!
    public class Node {
        public int x;
        public int y;
        public int v;

        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1;
        int mr = maps.length;
        int mc = maps[0].length;

        final ArrayDeque<Node> q = new ArrayDeque<>();

        maps[0][0] = 0;
        q.add(new Node(0,0,1));

        final int[] dx = {0,0,-1,1};
        final int[] dy = {-1,1,0,0};

        while (!q.isEmpty()) {
            final Node node = q.poll();
            final int x = node.x;
            final int y = node.y;
            final int v = node.v;

            for (int i=0; i<4; ++i) {
                int cx = dx[i] + x;
                int cy = dy[i] + y;

                if (0 <= cx && 0 <= cy && cy < mr && cx < mc) {
                    if (maps[cy][cx] == 1) {
                        if (cx == mc - 1 && cy == mr - 1) {
                            if (answer != -1) {
                                answer = Math.min(answer, v + 1);
                            } else {
                                answer = v + 1;
                            }
                        }
                        maps[cy][cx] = 0;
                        q.add(new Node(cx, cy, v + 1));
                    }
                }
            }
        }

        return answer;
    }
}
