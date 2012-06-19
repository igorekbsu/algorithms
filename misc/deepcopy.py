class Node:
    def __init__(self, data=None, next=None):
        self.data, self.next = data, next

    def __str__(self):
        return "({}, {}, {})".format(id(self), id(self.data), id(self.next))


def print_list(node):
    while node:
        print(node, end=" ")
        node = node.next


def deep_copy(root):
    copy_dict, node = {}, root
    while node:
        copy_dict[node], node = Node(), node.next
    node = root
    while node:
        new_node = copy_dict[node]
        new_node.data = copy_dict.get(node.data, None)
        new_node.next = copy_dict.get(node.next, None)
        node = node.next
    return copy_dict[root]


first, second, third = Node(), Node(), Node()
first.next, second.next = second, third
first.data, third.data = second, first
print_list(first)
print("")
print_list(deep_copy(first))


