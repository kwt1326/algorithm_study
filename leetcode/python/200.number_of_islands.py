from typing import List
from collections import deque

# BFS / 완전탐색
# m = 행 수 n = 열 수
# x 가 열을 이동하는 것처럼 생각할 수 있지만, 행 인덱스 이다
class Solution:
  def numIslands(self, grid: List[List[str]]) -> int:
    result = 0
    m = len(grid)
    n = len(grid[0])
    visited = [[False] * n for _ in range(m)]

    def bfs(i, j):
      dir = [(1, 0), (-1, 0), (0, 1), (0, -1)] # 동서남북 # 대각선의 경우 더 추가하면 됨
      q = deque()
      q.append((i, j))
      visited[i][j] = True
      
      while q:
        _x, _y = q.popleft()
        for _dx, _dy in dir:
          x = _dx + _x
          y = _dy + _y
          if x >= 0 and x < m and y >= 0 and y < n: # Grid - out of lange 방지
            if grid[x][y] == "1" and not visited[x][y]: # 조건에 맞으면서 방문안했으면 Queue append
              visited[x][y] = True
              q.append((x, y))

    for i in range(m):
      for j in range(n):
        if grid[i][j] == "1" and not visited[i][j]:
          bfs(i, j)
          result += 1

    return result

print(Solution().numIslands([
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]))

print(Solution().numIslands([
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]))