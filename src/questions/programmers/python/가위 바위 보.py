def solution(rsp):
    t = {'2':'0', '5':'2', '0':'5'}
    return ''.join([t[x] for x in rsp])