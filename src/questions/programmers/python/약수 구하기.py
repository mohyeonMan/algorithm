import math

def solution(n):
    
    s = {1, n}
    for x in range(2, math.isqrt(n) + 1) :
        if n % x == 0 :
            s.add(x)
            s.add(n//x)
    
    return sorted(list(s))