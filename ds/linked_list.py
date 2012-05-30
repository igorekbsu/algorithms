class LinkedList:
    class Entry:
        def __init__(self, val, next=None):
            self.val = val
            self.next = next

        def __str__(self):
            return str(self.val)

    def __init__(self):
        self.head = LinkedList.Entry(None)

    def insert(self, *elements):
        head = self.head
        for e in elements:
            entry = LinkedList.Entry(e, head.next)
            head.next = entry

    def print(self):
        node = self.head.next
        while node.next:
            print(node, end=" ")
            node = node.next
        print(node.val)

    def reverse(self):
        prev, node = None, self.head.next
        while node.next:
            next, node.next = node.next, prev
            prev, node = node, next
        node.next = prev
        self.head.next = node


linked_list = LinkedList()
linked_list.insert("Igor", "Vasil", "Ivan", "Someone")
linked_list.print()
linked_list.reverse()
linked_list.print()

