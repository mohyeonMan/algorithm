def solution(my_string):
    t = ['a', 'e', 'i', 'o', 'u']
    for x in t :
        my_string = my_string.replace(x,'')

    return my_string