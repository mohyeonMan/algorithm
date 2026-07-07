def solution(array):
    idx, num = max(enumerate(array),key= lambda x : x[1])
    return [num, idx]