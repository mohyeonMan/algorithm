from collections import Counter

def solution(array):
    mc = Counter(array).most_common(2)
    return mc[0][0] if len(mc) == 1 or mc[0][1] != mc[1][1] else -1