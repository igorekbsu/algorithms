from common import Vertex

adj_list = {
    0: {1, 3},
    1: {4},
    2: {4, 5},
    3: {1},
    4: {3},
    5: {5},
    }

vs = [Vertex(i) for i in range(6)]

def graph(adj_list):
    return {vs[u]: {vs[v] for v in adj_u} for u, adj_u in adj_list.items()}

G = graph(adj_list)

def dfs(G):
    for v in vs:
        v.c, v.p = 1, None
    time = 0

    def dfs_visit(G, u):
        nonlocal time
        time += 1
        u.d, u.c = time, 0
        for v in G[u]:
            if v.c:
                v.p = u
                dfs_visit(G, v)
        time += 1
        u.f = time

    for u in vs:
        if u.c: dfs_visit(G, u)


dfs(G)
print("Hello")

