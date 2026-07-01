def solution(price):
    d = 0
    if price >= 500000 : d = 0.2
    elif price >= 300000 : d = 0.1
    elif price >= 100000 : d = 0.05
    
    return int(price - (price * d))
