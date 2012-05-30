class Bst:
    class Node:
        def __init__(self, key, p=None, left=None, right=None):
            self.key, self.p, self.left, self.right = key, p, left, right

    def __init__(self, key):
        self.root = Bst.Node(key)

    def insert(self, *keys):
        for key in keys:
            node = self.root
            while node:
                x = node
                if node.key < key:
                    node = node.right
                else:
                    node = node.left
            new_node = Bst.Node(key, x)
            if x.key < key:
                x.right = new_node
            else:
                x.left = new_node

    def inorder(self, node):
        if node:
            self.inorder(node.left)
            print(node.key, end=" ")
            self.inorder(node.right)

    def iter_inorder(self):
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

    def iter_postorder(self):
        child, parent = [bst.root], []
        while child:
            node = child.pop()
            parent.append(node)
            if node.left:
                child.append(node.left)
            if node.right:
                child.append(node.right)
        while parent:
            print(parent.pop().key, end=" ")


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
            if node.key < key:
                node = node.right
            if node.key > key:
                node = node.left
        return node

    def min(self, node):
        while node.left:
            node = node.left
        return node

    def max(self, node):
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

bst = Bst(10)
bst.insert(5, 15, 2, 6, 18, 20, 17, 16, 35)
print("\nInorder walk")
bst.inorder(bst.root)
print("\nIter inorder walk")
bst.iter_inorder()
print("\npostorder walk")
bst.postorder(bst.root)
print("\niter_postorder walk")
bst.iter_postorder()
print("\npreorder walk")
bst.preorder(bst.root)
print("\niter_preorder walk")
bst.iter_preorder()
print("\nBst search")
print(bst.search(18).key)
print("\nBst min")
print(bst.min(bst.root).key)
print("\nBst max")
print(bst.max(bst.root).key)
print("\nBst successor")
assert bst.successor(bst.search(6)) == bst.search(10)
assert bst.successor(bst.search(15)) == bst.search(16)


