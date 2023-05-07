# encoding: utf-8
# backjoon - 2042
# 펜윅트리 (BIT)
# 구간 합을 구하면서, 데이터의 변경이 빈번할 경우 사용 (일반적인 구간 합은 데이터 업데이트에서 시간초과)
n = 5
arr = [0, 1,2,3,4,5] # [0] * (n + 1)
tree = [0] * (n + 1)
cmds = [
    (1, 3, 6),
    (2, 2, 5),
    (1, 5, 2),
    (2, 3, 5),
]

def prefix_sum(i):
    result = 0
    while i > 0:
        result += tree[i]
        i -= (i & -i)
    return result

def interval_sum(s, e):
    return prefix_sum(e) - prefix_sum(s - 1)

def update(i, val):
    while i <= n:
        tree[i] += val
        i += (i & -i)

# 초기 값 업데이트, 0 번째 무시
for i in range(1, len(arr)):
    update(i, arr[i])

# 커맨드 업데이트
for cmd in cmds:
    a, b, c = cmd
    if a == 1:
        update(b, c - arr[b]) # 구간 합 업데이트 : 변경된 차이 만큼 업데이트
        arr[b] = c # 원본 값 업데이트
    else:
        print(interval_sum(b, c))