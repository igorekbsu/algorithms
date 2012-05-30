import sys

N, INF = 3, sys.maxsize
A = [[INF for _ in range(N)] for _ in range(N)]

def insert(*elements):
    for e in elements:
        if A[-1][-1] == INF:
            A[-1][-1] = e
            youngify(N - 1, N - 1)


def youngify(i, j):
    up, left, = -INF, -INF
    if i >= 1:
        up = A[i - 1][j]
    if j >= 1:
        left = A[i][j - 1]
    if up > left:
        il, jl = i - 1, j
    else: il, jl = i, j - 1
    if il >= 0 <= jl and A[il][jl] > A[i][j]:
        A[il][jl], A[i][j] = A[i][j], A[il][jl]
        youngify(il, jl)

insert(9, 16, 3, 2, 4, 8, 5, 14, 12)
print(A)


  