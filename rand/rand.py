from random import randint
import sys

def rand(a, b):
    p, diff, y = 1, b - a, 2
    while y <= diff:
        y, p = y << 1, p + 1
    r = sys.maxsize
    while r > diff:
        r = 0
        for i in range(1, p + 1):
            r = 2 * r + randint(0, 1)
    return r + a

a, b = 3, 7
stats = [0 for _ in range(b - a + 1)]
for _ in range(100000):
    stats[rand(a, b) - a] += 1
print(stats)


  