package ko.me;

// DFS
// grid 원본 배열에서 방문 칸을 hiding 하는 방법이 visit 배열을 만드는 것보다 공간복잡도 측면에서 효율적이다.
// https://leetcode.com/problems/number-of-islands/description/
public class _200_Number_of_Islands {
    private static final int[] dx = new int[]{1, -1, 0, 0};
    private static final int[] dy = new int[]{0, 0, 1, -1};

    public static void dfs(
            final int x, final int y, // 현재 상태 인덱스
            final int r, final int c, // 행/열 개수
            final char[][] grid
    ) {
        for (int i = 0; i < 4; ++i) {
            final int cx = x + dx[i];
            final int cy = y + dy[i];
            if (cx < c && cy < r && cx > -1 && cy > -1 && grid[cy][cx] == '1') {
                grid[cy][cx] = '0';
                dfs(cx, cy, r, c, grid);
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int answer = 0;
        final int r = grid.length;
        final int c = grid[0].length;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(j, i, r, c, grid);
                    answer += 1;
                }
            }
        }

        dfs(0, 0, r, c, grid);

        return answer;
    }

    public static void main(String[] args) {
        final char[][] grid = new char[][]{
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '1'},
        };
        assert numIslands(grid) == 4;
    }
}
