class Counter:
    def __init__(self, low, high):
        self.low, self.high = low, high

    def __iter__(self):
        return self

    def __next__(self):
        if self.low > self.high:
            raise StopIteration
        self.low+=1
        return self.low - 1

for i in Counter(4, 10):
    print(i)