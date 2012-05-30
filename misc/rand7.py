from random import  randint

def rand7():
    a = [[1, 2, 3, 4, 5],
        [6, 7, 1, 2, 3],
        [4, 5, 6, 7, 1],
        [2, 3, 4, 5, 6],
        [7, 0, 0, 0, 0]]
    result = 0
    while result == 0:
        i, j = randint(1, 5), randint(1, 5)
        result = a[i - 1][j - 1]
    return result


distribution = [0] * 7
for _ in range(1000000):
    distribution[rand7() - 1] += 1
print(distribution)
