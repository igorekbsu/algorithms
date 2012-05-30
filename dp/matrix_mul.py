from sys import maxsize

def matrix_mul(p, i, j, dp):
    if dp[i][j] < maxsize: return dp[i][j]
    if i == j: return 0
    q = maxsize
    for k in range(i, j):
        t = matrix_mul(p, i, k, dp) + matrix_mul(p, k + 1, j, dp) + p[i - 1] * p[k] * p[j]
        if q > t:
            s[i][j] = k
            q = t
    dp[i][j] = q
    return q


def parenthesize(s, i, j):
    if i == j:
        return "A{}".format(i)
    else:
        return "({}{})".format(parenthesize(s, i, s[i][j]), parenthesize(s, s[i][j] + 1, j))

p = [30, 35, 15, 5, 10, 20, 25]
s, dp = [[0 for _ in range(len(p))] for _ in range(len(p))], [[maxsize for _ in range(len(p))] for _ in
                                                                                               range(len(p))]
print(matrix_mul(p, 1, len(p) - 1, dp))
print(parenthesize(s, 1, len(p) - 1))
