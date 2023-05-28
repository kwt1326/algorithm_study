# encoding: utf-8

# Backtracking
# N-Queen
# 프로그래머스에서는 일반 DFS - Pre-order 방식으로 풀면 시간초과하여 DP 로 풀어야 함 (백준은 괜찮은 듯)
def solution(n):
    answer = 0
    # 퀸 배치
    row = [0] * n
    # DP 위한 방문 배열
    visit = [False] * n
    
    def check(x):
        for i in range(x):
            # 동일 열, 대각선 이미 퀸 존재시
            if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
                return False
        return True
            
    def bt(x):
        nonlocal answer
        nonlocal visit
        if x == n:
            answer += 1
            return
        
        for i in range(n):
            if visit[i]:
                continue

            row[x] = i # 퀸 배치
            if check(x):
                visit[i] = True
                bt(x + 1)
                visit[i] = False
    bt(0)
    return answer