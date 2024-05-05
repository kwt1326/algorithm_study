from collections import Counter
from itertools import combinations

def solution(orders, course):
    answer = []
    
    # 조건
    # 1. 가장많이 주문한 단품메뉴로 코스요리 구성
    # 2. 최소 2가지 이상
    # 3. 최소 2명 이상의 손님에게 주문된 단품메뉴 조합만 허용
    # 4. 각 손님은 단품을 2개 이상 주문해야 함, A-Z 표기
    # 5. 사전 순 오름차순 정렬해서 반환
    
    # 아이디어
    # 1. course 에 맞는 조합을 만들기
    # 2. 길이 2 이상, 2명 이상 채택을 받은 조합을 필터링
    # 3. 중요!!! 각 코스의 최대 주문 수와 같은 길이의 코스를 결과로 추출
    
    for c in course:
        collect_arr = []
        
        # order 하나에 포함된 스펠링의 조합을 만듬
        # 조합 생성 시, 순서가 다른 조합은 같이 카운팅 하기 때문에 소스를 정렬해서 삽입
        for order in orders:
            collect_arr += combinations(sorted(order), c)
            
        # 카운팅 배열로 주문 수를 카운팅 하고 2번 이상 주문한 조합을 필터링
        cnt = Counter(collect_arr)
        keys = filter(lambda k : cnt[k] > 1, cnt.keys())
        
        # 각 코스당 최대 주문 수와 같은 조합을 추출
        if len(cnt.values()) > 0:
            max_value = max(cnt.values())
            for k in keys:
                pair = ''.join(k)
                if cnt[k] == max_value:
                    answer.append(pair)

    return sorted(answer)