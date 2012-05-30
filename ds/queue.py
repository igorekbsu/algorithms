class Queue:
    def __init__(self, n):
        self.A = [0] * (n + 1)
        self.size = (n + 1)
        self.head, self.tail = 0, 0

    def enqueue(self, e):
        new_tail = (self.tail + 1) % self.size
        if new_tail == self.head:
            print("Overflow")
        else:
            self.A[self.tail] = e
            self.tail = new_tail


    def dequeue(self):
        if self.head == self.tail:
            print("Underflow")
        else:
            e = self.A[self.head]
            self.head = (self.head + 1) % self.size
            return e


    def print(self):
        i, elements = self.head, []
        while i != self.tail:
            elements.append(self.A[i])
            i = (i + 1) % self.size
        print(elements)


queue = Queue(3)
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(4)
queue.dequeue()
queue.dequeue()
queue.enqueue(5)
queue.print()