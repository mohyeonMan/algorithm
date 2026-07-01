def solution(num_list):
    t = sum(x % 2 ==0 for x in num_list)
    return [t, len(num_list) - t]