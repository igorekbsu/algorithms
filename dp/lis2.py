def lis(a):
    q = [0] * len(a)
    for k in range(len(a)):
        m = 0
        for i in range(k):
            if a[k] > a[i] and q[i] > m:
                m = q[i]
        q[k] = m + 1
    return max(q)

print(lis([3, 5, 50, 2, 3, 4]))
assert lis([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]) == 6

  