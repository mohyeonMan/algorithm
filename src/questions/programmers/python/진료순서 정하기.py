def solution(emergency):
    e = {v : (i + 1) for i,v in enumerate(sorted(emergency,reverse=True))}
    return [e[v] for v in emergency]