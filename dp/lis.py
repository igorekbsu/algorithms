def subsequence(seq):
    M = [None] * len(seq)    # offset by 1 (j -> j-1)
    P = [None] * len(seq)
    L, M[0] = 1, 0
    for i in range(1, len(seq)):
        lower, upper = 0, L
        if seq[M[upper - 1]] < seq[i]:
            j = upper
        else:
            while upper - lower > 1:
                mid = (upper + lower) // 2
                if seq[M[mid - 1]] < seq[i]:
                    lower = mid
                else:
                    upper = mid
            j = lower    # this will also set the default value to 0
        P[i] = M[j - 1]
        if j == L or seq[i] < seq[M[j]]:
            M[j] = i
            L = max(L, j + 1)
    result = []
    pos = M[L - 1]
    for _ in range(L):
        result.append(seq[pos])
        pos = P[pos]

    return result[::-1]

#print(subsequence([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]))
print(subsequence([3, 4, 0, 1, 2]))

  