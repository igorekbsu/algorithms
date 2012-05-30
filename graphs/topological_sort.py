from common import Vertex

values = ['undershorts', 'socks', 'watch', 'pants', 'shoes', 'belt', 'shirt', 'tie', 'jacket']
vs = [Vertex(item) for item in values]
adjacency_list = {
    0: {3, 4},
    1: {4},
    3: {4, 5},
    5: {8},
    6: {7, 5},
    7: {8},
    }

graph = {vs[key]: {vs[v] for v in value} for key, value in adjacency_list.items()}

def topological_sort(graph):
    for v in vs:
        v.c = False
    vertices, stack = [], []
    for u in vs:
        if not u.c:
            stack.append(u)
            while stack:
                v, unvisited = stack[-1], None
                v.c = True
                for a in graph.get(v, {}):
                    if not a.c:
                        unvisited = a
                        break
                if unvisited:
                    stack.append(unvisited)
                else:
                    vertices.insert(0, stack.pop())
    return vertices


for v in topological_sort(graph):
    print(v, end=" ")


