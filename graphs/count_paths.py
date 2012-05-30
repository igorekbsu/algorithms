from common import Vertex

adjacency_list = {
    'm': {'r', 'q', 'x'},
    'n': {'o', 'u', 'q'},
    'o': {'s', 'v', 'r'},
    'p': {'z', 's', 'o'},
    'q': {'t'},
    'r': {'y', 'u'},
    's': {'r'},
    'u': {'t'},
    'v': {'w', 'x'},
    'w': {'z'},
    'y': {'v'},
    }

vs = {v: Vertex(v) for v in 'mnopqrstuvwxyz'}
graph = {vs[v]: {vs[u] for u in adj_v} for v, adj_v in adjacency_list.items()}

def count_paths(s, t):
    for v in vs.values():
        v.c, v.d = False, 0
    sv, tv = vs[s], vs[t]

    def visit(u):
        u.c = True
        for v in graph.get(u, {}):
            if not v.c:
                if v == tv:
                    return 1
                else:
                    visit(v)
            else:
                u.d += v.d


    for u in graph.get(sv, {}):
        if not u.c:
            if u == tv:
                sv.d = 1
            else:
                visit(u)
        else: sv.d += u.d
    return sv.d

assert count_paths('p', 'v') == 4
assert count_paths('p', 'p') == 0
assert count_paths('w', 'z') == 1
