# encoding: utf-8
from collections import Counter

# Counting Hash Table 기법 활용 (collections/Counter - 배열의 요소가 각각 카운팅되어 dictionary 반환)
# 각 요소를 카운팅하여 dictionary 에 저장, 해당 dic 의 key 의 존재 유무로 판단
# slice 비교시 시간초과
def solution(topping):
    answer = 0
    length = len(topping)
    left_dic = Counter()
    right_dic = Counter(topping)
    
    for i in range(0, length):
        key = topping[i]
        if key in left_dic:
            left_dic[key] += 1
        else:
            left_dic[key] = 1

        right_dic[key] -= 1
        if right_dic[key] == 0:
            del right_dic[key]

        if len(left_dic) == len(right_dic):
            answer += 1
    
    return answer

print(solution([1, 2, 1, 3, 1, 4, 1, 2])) # 2
print(solution([1, 2, 1, 3, 4, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9])) # 0