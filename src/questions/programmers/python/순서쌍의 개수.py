import math
def solution(n):
    
    r = math.isqrt(n)
    answer = 2

    for i in range(2, r + 1) :
        if n % i == 0 :
            answer +=2

    if r * r == n :
        answer -=1
    return answer