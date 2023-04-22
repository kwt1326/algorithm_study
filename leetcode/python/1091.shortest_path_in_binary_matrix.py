from collections import deque
from typing import List

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        len_path = -1
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        visit = [[False] * m for _ in range(n)]
        q = deque()

        if grid[0][0] is 1:
            return len_path

        q.append((0, 0, 1))
        
        def bfs():
            nonlocal len_path
            while q:
                x, y, d = q.popleft()
                if x is n - 1 and y is m - 1:
                    if len_path is -1 or len_path > d:
                        len_path = d
                for dx, dy in dirs:
                    nx = x + dx
                    ny = y + dy
                    if nx >= 0 and nx < m and ny >= 0 and ny < n:
                        if visit[nx][ny] is False and grid[nx][ny] is 0:
                            visit[nx][ny] = True
                            q.append((nx, ny, d + 1))
        
        bfs()
        return len_path
    
print(Solution().shortestPathBinaryMatrix([[0,1],[1,0]]))
print(Solution().shortestPathBinaryMatrix([[0,0,0],[1,1,0],[1,1,0]]))
print(Solution().shortestPathBinaryMatrix([[1,0,0],[1,1,0],[1,1,0]]))