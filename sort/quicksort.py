import data

def quicksort(A, p, r):
    work = [(p, r)]
    while work:
        item = work.pop(0)
        if item[0] < item[1]:
            q = partition(A, item[0], item[1])
            work.insert(0, (item[0], q - 1))
            work.insert(0, (q + 1, item[1]))


def partition(A, p, r):
    x, i = A[r], p - 1
    for j in range(p, r):
        if A[j] <= x:
            i += 1
            A[i], A[j] = A[j], A[i]
    A[i + 1], A[r] = A[r], A[i + 1]
    return i + 1

A = data.A2
quicksort(A, 0, len(A) - 1)
print(A)
  