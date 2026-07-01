def solution(hp):
    ants = [5, 3, 1]
    answer = 0

    for x in ants :
        cnt = hp // x
        hp -= cnt * x
        answer += cnt
    
    return answer