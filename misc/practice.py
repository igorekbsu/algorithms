class LinkedList:
    class Node:
        def __init__(self, k=None, next=None):
            self.k, self.next = k, next

        def __str__(self):
            return str(self.k)

    def __init__(self):
        self.head = LinkedList.Node()

    def add(self, k):
        next = self.head.next
        new_node = LinkedList.Node(k, next)
        self.head.next = new_node

    def reverse(self):
        node, next = self.head, self.head.next
        while next:
            next_next = next.next
            next.next = node
            node = next
            next = next_next
        head = self.head
        if head.next:
            head.next.next = None
            head.next = node

    def __str__(self):
        entries, node = "", self.head.next
        if node:
            while node:
                entries += node.k + " "
                node = node.next
        return entries


linked_list = LinkedList()
linked_list.add("Igor")
linked_list.add("Vasil")
print(linked_list)
linked_list.reverse()
print(linked_list)
