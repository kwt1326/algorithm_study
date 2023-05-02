# encoding: utf-8
def solution(n,a,b):
    answer = 0
    mid = n
    na = a
    nb = b
    
    while na != nb and mid > 1:
        na = int(na / 2 if na % 2 == 0 else na / 2 + 1)
        nb = int(nb / 2 if nb % 2 == 0 else nb / 2 + 1)
        mid = mid / 2
        answer += 1

    return answer

print(solution(8, 4, 7))