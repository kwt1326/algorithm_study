# https://www.acmicpc.net/problem/16236
# 삼성 SW / 아기 상어 / BFS

import sys
from collections import deque

input=sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

# N = 6
# arr = [
#     [5, 4, 3, 2, 3, 4],
#     [4, 3, 2, 3, 4, 5],
#     [3, 2, 9, 5, 6, 6],
#     [2, 1, 2, 3, 4, 5],
#     [3, 2, 1, 6, 5, 4],
#     [6, 6, 6, 6, 6, 6]
# ]

def baby_shark():

    # 1. 물고기는 M 마리, 상어는 1마리, 상어는 처음 크기 2, 초기 위치는 "9" 가 있는 위치이다.
    # 2. 상어는 1초에 한칸씩 상하좌우로 움직인다.
    # 3. 자기보다 작은 물고기만 먹으면서 이동이 가능, 같은 크기는 먹지 못하고 지나가기는 가능하다.

    # 아이디어
    # 1. 아기상어 위치를 먼저 구한 뒤, 해당 위치부터 시작해서 가까운 물고기를 거리와 함께 찾아둔다.
    # 2. 조건 순으로 정렬한 뒤, 상어가 먹을 수 있는 물고기를 차례로 탐색한다.
    # 3. 물고기 위치에 도달하면, 타이머를 업데이트 한 뒤 1~2 번 과정을 반복한다.

    # 북, 남, 서, 동
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    eaten = 0
    timer = 0
    shark = 2

    def find_shark():
        for i in range(N):
            for j in range(N):
                if arr[i][j] == 9:
                    arr[i][j] = 0
                    return (i, j)

    def find_fishes(shark_c, shark_r):
        visit = [[False] * N for _ in range(N)]
        visit[shark_r][shark_c] = True
        q = deque()
        q.append((shark_c, shark_r, 0))
        fishes = []

        while q:
            x, y, d = q.popleft()

            for i in range(4):
                cx, cy, cd = x + dx[i], y + dy[i], d + 1
                fish = (cx, cy, cd)

                if cx < N and cy < N and cx >= 0 and cy >= 0 and not visit[cy][cx]:
                    size = arr[cy][cx]
                    if size <= shark:
                        visit[cy][cx] = True
                        if 0 < size < shark:
                            fishes.append(fish)
                        else:
                            q.append(fish)

        # 거리에 가까운 게 1순위, 위에 있는게 2순위, 왼쪽에 있는게 3순위
        sorted_fishes = sorted(fishes, key=lambda f: (f[2], f[1], f[0]))
        return sorted_fishes[0] if len(sorted_fishes) > 0 else None

    # 처음 상어 위치 찾기
    shark_r, shark_c = find_shark()

    while True:
        # 매번 새 상어 위치에서 시작해서 물고기를 탐색해야 한다.
        target_fish = find_fishes(shark_c, shark_r)
        if target_fish is None:
            break

        fish_c, fish_r, d = target_fish
        timer += d
        eaten += 1
        shark_c = fish_c
        shark_r = fish_r
        # 현재 상어 크기에 맞게 먹으면 사이즈 업
        if eaten == shark:
            eaten = 0
            shark += 1
        # 물고기 비우기
        arr[fish_r][fish_c] = 0

    return timer

print(baby_shark())
