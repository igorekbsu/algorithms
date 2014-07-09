from itertools import permutations

n = 4
cols = range(n)
for vec in permutations(cols):
    if n == len(set(vec[i] + i for i in cols)) == len(set(vec[i] - i for i in cols)):
        print(vec)


  