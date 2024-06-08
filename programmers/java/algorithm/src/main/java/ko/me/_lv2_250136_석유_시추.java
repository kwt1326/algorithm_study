package ko.me;

import java.util.*;

// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/250136
public class _lv2_250136_석유_시추 {
    // 이 답안은 효율성 테스트 4번이 런타임 에러가 발생합니다. 나머지는 모두 통과합니다.

    // 아이디어:
    // DFS 는 한번만 하도록 하는 최적화가 필요하다. 아니면 효율성 테스트가 모두 실패한다.
    // 석유가 있는 땅을 기억할 수 있게, clustering id 를 하나 만들어서, 어떤 위치의 좌표에 이 id 를 land 대신에 사용한다.
    // mapping id 를 key, 석유의 땅의 크기를 value 로 하는 mapping table 을 하나 더 만들어 둔다.
    public static int clusterDFS(int[][] m, int[][] v, int id, int w, int h, int r, int c) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int state = 1;

        for (int i = 0; i < 4; ++i) {
            int cx = dx[i] + c;
            int cy = dy[i] + r;

            if (0 <= cx && 0 <= cy && cx < w && cy < h) {
                if (v[cy][cx] == 1) {
                    v[cy][cx] = 0;
                    m[cy][cx] = id;
                    state += clusterDFS(m, v, id, w, h, cy, cx);
                }
            }
        }

        return state;
    }

    public static int solution(int[][] land) {
        int answer = 0;
        int height = land.length;
        int width = land[0].length;

        int[][] m = new int[height][width];
        Map<Integer, Integer> clusterMap = new HashMap<>();

        // mapping, land clustering
        int increaseId = 0;
        for (int r = 0; r < height; ++r) {
            for (int c = 0; c < width; ++c) {
                if (land[r][c] == 1) {
                    increaseId++;
                    land[r][c] = 0;
                    m[r][c] = increaseId;
                    int sum = clusterDFS(m, land, increaseId, width, height, r, c);
                    clusterMap.put(increaseId, sum);
                }
            }
        }

        for (int c = 0; c < width; ++c) {
            final Set<Integer> usedIds = new HashSet<>();
            int sum = 0;

            for (int r = 0; r < height; ++r) {
                final int id = m[r][c];
                if (id > 1 && usedIds.add(id)) {
                    sum += clusterMap.get(id);
                }
            }
            answer = Math.max(answer, sum);
            usedIds.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
        assert solution(land) == 16;
    }

    // 같은 아이디어를 사용한 다른 완전히 성공한 구현
    class Solution_Success_Version {

        private int dfs(int[][] land, boolean[][] visited, int r, int c) {
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            int state = 1;
            int height = land.length;
            int width = land[0].length;
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{r, c});
            visited[r][c] = true;

            while (!stack.isEmpty()) {
                int[] current = stack.pop();
                int curR = current[0];
                int curC = current[1];
                for (int i = 0; i < 4; ++i) {
                    int newR = curR + dy[i];
                    int newC = curC + dx[i];
                    if (0 <= newR && newR < height && 0 <= newC && newC < width && land[newR][newC] == 1 && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        stack.push(new int[]{newR, newC});
                        state++;
                    }
                }
            }
            return state;
        }

        public int solution(int[][] land) {
            int height = land.length;
            int width = land[0].length;
            boolean[][] visited = new boolean[height][width];
            Map<Integer, Integer> oilClusterSize = new HashMap<>();
            int clusterId = 2;

            for (int r = 0; r < height; ++r) {
                for (int c = 0; c < width; ++c) {
                    if (land[r][c] == 1 && !visited[r][c]) {
                        int size = dfs(land, visited, r, c);
                        oilClusterSize.put(clusterId, size);
                        markCluster(land, r, c, clusterId);
                        clusterId++;
                    }
                }
            }

            int answer = 0;
            for (int c = 0; c < width; ++c) {
                Set<Integer> seenClusters = new HashSet<>();
                int sum = 0;
                for (int[] ints : land) {
                    if (ints[c] > 1 && seenClusters.add(ints[c])) {
                        sum += oilClusterSize.get(ints[c]);
                    }
                }
                answer = Math.max(answer, sum);
            }

            return answer;
        }

        private void markCluster(int[][] land, int r, int c, int clusterId) {
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            int height = land.length;
            int width = land[0].length;
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{r, c});
            land[r][c] = clusterId;

            while (!stack.isEmpty()) {
                int[] current = stack.pop();
                int curR = current[0];
                int curC = current[1];
                for (int i = 0; i < 4; ++i) {
                    int newR = curR + dy[i];
                    int newC = curC + dx[i];
                    if (0 <= newR && newR < height && 0 <= newC && newC < width && land[newR][newC] == 1) {
                        land[newR][newC] = clusterId;
                        stack.push(new int[]{newR, newC});
                    }
                }
            }
        }
    }
}
