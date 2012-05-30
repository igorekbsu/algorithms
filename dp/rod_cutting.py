def recursive_rod_cut(p, n):
    if not n: return 0
    q = -1
    for i in range(1, n + 1):
        q = max(q, p[i] + recursive_rod_cut(p, n - i))
    return q

def bottom_up_cut(p, n):
    r = [0]*(n + 1)
    for j in range(1, n + 1):
        q = -1
        for i in range(1, j + 1):
            q = max(q, p[i] + r[j - i])
        r[j] = q
    return r[n]


p = [0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30]
print(recursive_rod_cut(p, 7))
print(bottom_up_cut(p, 7))
