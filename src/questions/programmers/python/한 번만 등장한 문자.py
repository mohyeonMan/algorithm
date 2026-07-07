from collections import Counter

def solution(s):
    return ''.join(sorted([k for k,c in Counter(s).items() if c == 1]))