# encoding: utf-8
from collections import deque

# Backtracking
# 타겟 넘버
def solution(numbers, target):
    answer = 0
    dp = deque()
    
    def dfs(plus, value, d, h):
        nonlocal answer
        if d == len(numbers):
            if value == target and h not in dp:
                dp.append(h)
                answer += 1
            return
        
        _rv = numbers[d] * (1 if plus else -1)
        _v = value + _rv

        dfs(True, _v, d + 1, h + str(_rv))
        dfs(False, _v, d + 1, h + str(_rv))
        
    dfs(True, 0, 0, "")
    dfs(False, 0, 0, "")
    
    return answer

print(solution([1, 1, 1, 1, 1], 3)) # 5
