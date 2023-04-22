from typing import List

# DFS / 완전탐색
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        result = 0
        visited = [False] * len(rooms)

        def dfs(room, index):
            nonlocal result
            if visited[index] is False:
                visited[index] = True
                result += 1
                for key in room:
                    dfs(rooms[key], key)

        dfs(rooms[0], 0)
        return result == len(rooms)
    
print(Solution().canVisitAllRooms([[1],[2],[3],[]]))
print(Solution().canVisitAllRooms([[1,3],[3,0,1],[2],[0]]))