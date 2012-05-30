def counting_sort(A, k):
    lenA = len(A)
    C = [0 for _ in range(k + 1)]
    B = [0 for _ in range(lenA)]
    for j in range(lenA):
        C[A[j]] += 1
    for i in range(1, k + 1):
        C[i] = C[i] + C[i - 1]
    for j in range(lenA - 1, -1, -1):
        B[C[A[j]] - 1] = A[j]
        C[A[j]] -= 1
    return B

A = [2, 5, 3, 0, 2, 3, 0, 3]
print(counting_sort(A, 5))