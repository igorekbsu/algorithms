class BitVector:
    def __init__(self, length):
        self.length = length
        self.n = 0

    def insert(self, x):
        if x < self.length:
            self.n |= 1 << x

    def delete(self, x):
        if x < self.length:
            self.n ^= 1 << x

    def contains(self, x):
        return self.n & (1 << x) != 0

    def print(self):
        for i in range(self.length + 1):
            if self.contains(i):
                print(i, end=" ")
        print()

vector = BitVector(10)
vector.insert(7)
vector.insert(3)
vector.insert(2)
vector.print()
vector.delete(7)
vector.insert(8)
vector.print()


