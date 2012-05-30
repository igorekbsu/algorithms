import sys

def lis(a):
    q = [0] * len(a)
    for i in range(len(a)):
        m = 0
        for j in range(i):
            if a[j] < a[i] and m < q[j]:
                m = q[j]
        q[i] = m + 1
    length, seq, m = max(q), [], sys.maxsize
    for i, s in enumerate(q[::-1]):
        current = a[-1 - i]
        if s == length and m > current:
            seq.append(current)
            m, length = current, length - 1
    return seq[::-1]


A = [4, 10, 1, 2, 0, 9, -1]
assert lis(A) == [1, 2, 9]
print(lis([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]))