from collections import defaultdict
from common import Vertex

vs = {v: Vertex(v) for v in 'abcdefgh'}
adjacency_list = {
    'a': {'b'},
    'b': {'c', 'f', 'e'},
    'c': {'d', 'g'},
    'd': {'h', 'c'},
    'h': {'h'},
    'g': {'h', 'f'},
    'f': {'g'},
    'e': {'f', 'a'},
    }

adjacency_list1 = {
    'a':{'b'},
    'b':{'c'},
    'c':{'d', 'a'},
}

graph = {vs[u]: {vs[v] for v in adj_u} for u, adj_u in adjacency_list.items()}
graph1 = {vs[u]: {vs[v] for v in adj_u} for u, adj_u in adjacency_list1.items()}

def ssc(graph):
    vertices = []
    for u in vs.values(): u.c = False

    def visit(u):
        u.c = True
        for v in graph.get(u, {}):
            if not v.c:
                visit(v)
        vertices.insert(0, u)

    for u in vs.values():
        if not u.c:
            visit(u)

    transposed_graph = defaultdict(set)
    for u, adj_u in graph.items():
        for v in adj_u:
            transposed_graph[v].add(u)
    for u in vs.values(): u.c = False

    def second_visit(u, tree):
        u.c = True
        tree.append(u)
        for v in transposed_graph[u]:
            if not v.c:
                second_visit(v, tree)

    forest = []
    for u in vertices:
        tree = []
        if not u.c:
            second_visit(u, tree)
        if tree:
            forest.append(tree)
    return forest

print(ssc(graph1))
print(ssc(graph))
