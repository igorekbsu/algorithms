class Node:
    def __init__(self, n):
        self.size, self.p = 1, n

    @staticmethod
    def union(n, m):
        x, y = Node.root(n), Node.root(m)
        if x == y: return False
        if nodes[x].size >= nodes[y].size:
            nodes[y].p = nodes[x].p
            nodes[x].size += nodes[y].size
        else:
            nodes[x].p = nodes[y].p
            nodes[y].size += nodes[x].size
        return True


    @staticmethod
    def root(n):
        if nodes[n].p != n:
            nodes[n].p == Node.root(nodes[n].p)
            return nodes[n].p
        return n

nodes = [Node(i) for i in range(10)]
Node.union(1, 5)
Node.union(2, 4)
Node.union(1, 9)
print(nodes[Node.root(5)].size)

