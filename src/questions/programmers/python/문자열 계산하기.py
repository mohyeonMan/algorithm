def solution(my_string):
    my_string = my_string.split()
    
    answer = int(my_string[0])
    for i in range(2, len(my_string), 2):
        cur = int(my_string[i])
        if my_string[i-1] == '+':
            answer += cur
        else : answer -= cur
    
    return answer
