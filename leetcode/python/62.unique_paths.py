from collections import deque

class Solution:
    # Runtime 31 ms / Memory 13.8 MB
    # DP - (Bottom-Up, BFS, tabulation)
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[0] * n for _ in range(m)]
        dirs = [(1,0), (0, 1)]
        q = deque()

        if m is 1 or n is 1:
            return 1

        def bfs():
            q.append((0, 0))
            memo[0][0] = 1

            while q:
                x, y = q.popleft()
                for dx, dy in dirs:
                    nx = x + dx
                    ny = y + dy
                    if nx < m and ny < n:
                        _x = 0 if nx - 1 < 0 else nx - 1
                        _y = 0 if ny - 1 < 0 else ny - 1
                        if memo[nx][ny] == 0:
                            memo[nx][ny] = memo[_x][ny] + memo[nx][_y]
                            q.append((nx, ny))
                        
        bfs()
        return memo[m - 1][n - 1]
    
    # Runtime 44 ms / Memory 16.6 MB
    # DP - (Top-Down, DFS, memoization)
    def uniquePaths_dfs(self, m: int, n: int) -> int:
        memo = [[0] * n for _ in range(m)]

        def dfs(m, n):
            if m is 0 or n is 0:
                memo[m][n] = 1
                return memo[m][n]
            if memo[m][n] is not 0:
                return memo[m][n]
            memo[m][n] = dfs(m - 1, n) + dfs(m, n - 1)
            return memo[m][n]

        return dfs(m - 1, n - 1)

print(Solution().uniquePaths(3, 7))
print(Solution().uniquePaths(3, 2))

print(Solution().uniquePaths_dfs(3, 7))
print(Solution().uniquePaths_dfs(3, 2))