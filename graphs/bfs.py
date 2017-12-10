from collections import deque
import sys

class Vertex:
    def __init__(self, mark):
        self.mark = mark

    def __str__(self):
        return str(self.mark)


vs = [Vertex(i) for i in range(7)]

graph = {
    vs[0]: {vs[1], vs[2], vs[3]},
    vs[1]: {vs[0], vs[6]},
    vs[2]: {vs[0], vs[3]},
    vs[3]: {vs[0], vs[2], vs[4], vs[5]},
    vs[4]: {vs[3], vs[6]},
    vs[5]: {vs[3]},
    vs[6]: {vs[1], vs[4]},
    }

def bfs(graph, s):
    for v in vs:
        v.d, v.p, v.c = sys.maxsize, None, 0
    s.d, s.c = 0, 1
    queue = deque([s])
    while queue:
        u = queue.popleft()
        for v in graph.get(u, set()):
            if v.c == 0:
                v.d, v.p, v.c = u.d + 1, u, 1
                queue.append(v)


def print_path(graph, s, v):
    if v == s: print(s, end=" ")
    elif not v.p: print("No path")
    else:
        print_path(graph, s, v.p)
        print(v, end=" ")

bfs(graph, vs[0])
print_path(graph, vs[0], vs[6])