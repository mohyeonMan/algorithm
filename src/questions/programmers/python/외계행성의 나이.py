def solution(age):
    alp = 'abcdefghij'
    return ''.join(alp[int(x)] for x in str(age))