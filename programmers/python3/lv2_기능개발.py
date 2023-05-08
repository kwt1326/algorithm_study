# encoding: utf-8
def solution(progresses, speeds):
    answer = []
    _max = 100
    work_num = 0
        
    for i in range(len(progresses)):
        remain = progresses[i]
        day = 0
        while remain < 100:
            remain += speeds[i]
            day += 1
        if i == 0:
            _max = day
            work_num = 1
            continue
        if _max >= day:
            work_num += 1
        else:
            answer.append(work_num)
            _max = day
            work_num = 1
    
    if work_num != 0:
        answer.append(work_num)
    
    return answer