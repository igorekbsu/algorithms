class Bst:
    class Node:
        def __init__(self, key, p=None, left=None, right=None):
            self.key = key
            self.p, self.left, self.right = p, left, right

        def __str__(self):
            return str(self.key)


    def __init__(self, root_key):
        self.root = Bst.Node(root_key)

    def insert(self, *elements):
        for e in elements:
            x = self.root
            while x != None:
                y = x
                if x.key >= e:
                    x = x.left
                else: x = x.right
            node = Bst.Node(e, y)
            if y.key >= e:
                y.left = node
            else: y.right = node

    def inorder(self):
        node = self.root
        while node.left:
            node = node.left
        while node:
            print(node.key, end=" ")
            if node.right:
                node = node.right
                while node.left:
                    node = node.left
            else:
                while node.p and node.p.right == node:
                    node = node.p
                node = node.p

    def postorder(self, node):
        if node:
            self.postorder(node.left)
            self.postorder(node.right)
            print(node.key, end=" ")

    def iter_postorder(self, node):
        child, parent = [node], []
        while child:
            node = child.pop()
            parent.append(node)
            if node.left:
                child.append(node.left)
            if node.right:
                child.append(node.right)
        while parent:
            print(parent.pop(), end=" ")

    def preorder(self, node):
        if node:
            print(node.key, end=" ")
            self.preorder(node.left)
            self.preorder(node.right)

    def iter_preorder(self):
        stack = [self.root]
        while stack:
            node = stack.pop()
            print(node.key, end=" ")
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)


    def search(self, key):
        node = self.root
        while node and node.key != key:
            if node.key > key:
                node = node.left
            else: node = node.right
        return node


    def min(self, sub_tree):
        node = sub_tree
        while node.left:
            node = node.left
        return node

    def max(self, sub_tree):
        node = sub_tree
        while node.right:
            node = node.right
        return node

    def successor(self, node):
        if node.right:
            return self.min(node.right)
        p = node.p
        while p and p.right == node:
            node = p
            p = node.p
        return p


    def predecessor(self, node):
        if node.left:
            return self.max(node.left)
        p = node.p
        while p and p.left == node:
            node = p
            p = node.p
        return p


bst = Bst(15)
bst.insert(6, 18, 3, 7, 17, 20, 2, 4, 13, 9)
print('\nIn order:')
bst.inorder()

print("\nPost Order")
bst.postorder(bst.root)
print()
bst.iter_postorder(bst.root)

print("\nPreorder:")
bst.preorder(bst.root)
print()
bst.iter_preorder()

print("\nMinimum Maximum")
print(bst.min(bst.root), bst.max(bst.root))

print("Successor")
assert bst.successor(bst.search(6)) == bst.search(7)
assert bst.successor(bst.search(13)) == bst.search(15)

print("Predecessor")
assert bst.predecessor(bst.search(15)) == bst.search(13)
assert bst.predecessor(bst.search(6)) == bst.search(4)
assert bst.predecessor(bst.search(9)) == bst.search(7)

  