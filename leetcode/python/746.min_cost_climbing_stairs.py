# 746. Min Cost Climbing Stairs
# 재귀 (Top-down, memoization)
from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        memo = {}

        def dfs(n):
            if n == 0 or n == 1:
                return 0
            if n not in memo:
                memo[n] = min(cost[n - 1] + dfs(n - 1), cost[n - 2] + dfs(n - 2))
            return memo[n]

        return dfs(len(cost))

print(Solution().minCostClimbingStairs([10,15,20]))
print(Solution().minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1]))