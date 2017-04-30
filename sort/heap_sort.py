from common import data

class Heap:
    def __init__(self, A):
        self.A = A
        self._build_max_heap()

    def _build_max_heap(self):
        self.heap_size = len(self.A)
        for i in range(len(self.A) // 2, -1, -1):
            self.max_heapify(i)

    def max_heapify(self, i):
        largest, n = -1, i
        while True:
            l, r, A = self.left(n), self.right(n), self.A
            if l < self.heap_size and A[l] > A[n]:
                largest = l
            else: largest = n
            if r < self.heap_size and A[r] > A[largest]:
                largest = r
            if largest != n:
                A[n], A[largest] = A[largest], A[n]
                n = largest
            else: break

    def left(self, i):
        return 2 * i + 1

    def right(self, i):
        return 2 * i + 2

    def __str__(self):
        return "{0}, {1}".format(self.A, self.heap_size)


def heapsort(A):
    heap = Heap(A)
    for i in range(len(A) - 1, 0, -1):
        A[0], A[i] = A[i], A[0]
        heap.heap_size -= 1
        heap.max_heapify(0)

A = data.A2
print(A)
heapsort(A)
print(A)