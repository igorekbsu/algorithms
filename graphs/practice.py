graph = [
        {2},
        {2, 3, 4},
        {},
        {0, 4},
        {3}]

def out_degree(v):
    return len(graph[v])


def in_degree(vertex):
    return sum(vertex in graph[v] for v in range(len(graph)))


def transpose(graph):
    gt = [set() for _ in range(len(graph))]
    for v in range(len(graph)):
        for adj_v in graph[v]:
            gt[adj_v].add(v)
    return gt




assert out_degree(1) == 3
assert out_degree(2) == 0
assert in_degree(2) == 2
print(transpose(graph))