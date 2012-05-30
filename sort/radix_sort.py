def radix_sort(A):
    d = len(A[0])
    for i in range(d - 1, -1, -1):
        A = counting_sort(A, 9, i)
    return A


def counting_sort(A, k, d):
    lenA = len(A)
    C = [0 for _ in range(k + 1)]
    B = [0 for _ in range(lenA)]
    for j in range(lenA):
        C[int(A[j][d])] += 1
    for i in range(1, k + 1):
        C[i] = C[i] + C[i - 1]
    for j in range(lenA - 1, -1, -1):
        B[C[int(A[j][d])] - 1] = A[j]
        C[int(A[j][d])] -= 1
    return B

A = ['329', '457', '657', '839', '436', '720', '355']
print(radix_sort(A))