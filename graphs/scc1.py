class Node:
    def __init__(self, n):
        self.p, self.elements = n, [n]

    @staticmethod
    def root(n):
        if nodes[n].p != n:
            nodes[n].p = Node.root(nodes[n].p)
        return nodes[n].p

    @staticmethod
    def union(n, m):
        x, y = Node.root(n), Node.root(m)
        if x == y: return False
        if len(nodes[x].elements) >= len(nodes[y].elements):
            nodes[y].p = nodes[x].p
            nodes[x].elements.extend(nodes[y].elements)
        else:
            nodes[x].p = nodes[y].p
            nodes[y].elements.extend(nodes[x].elements)

vs = 'abcdefghij'
graph = {
    'a': {'b', 'c'},
    'b': {'a', 'c', 'd'},
    'c': {'a', 'b'},
    'd': {'b'},
    'e': {'f', 'g'},
    'f': {'e'},
    'g': {'e'},
    'h': {'i'},
    'i': {'h'},
    }

nodes = {s: Node(s) for s in vs}
for u in vs:
    for v in graph.get(u, {}):
        Node.union(u, v)
print(list(node.elements for s, node in nodes.items() if s == node.p))

