class Solution:
    memo = {}
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        if n not in self.memo:
            self.memo[n] = self.climbStairs(n - 1) + self.climbStairs(n - 2)
        return self.memo[n]
    
print(Solution().climbStairs(2))
print(Solution().climbStairs(3))
print(Solution().climbStairs(5))