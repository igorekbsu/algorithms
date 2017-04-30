from common import data


def insertion_sort(A):
    for i in range(1, len(A)):
        k, j = A[i], i - 1
        # insert k into sorted array A[0..j]
        while j >= 0 and k < A[j]:
            A[j + 1], j = A[j], j - 1
        A[j + 1] = k


insertion_sort(data.A1)
print(data.A1)
insertion_sort(data.A2)
print(data.A2)


# kadanes method
def max_subarray(A):
    max_end, max_so_far = 0, 0
    for a in A:
        max_end = max(0, max_end + a)
        max_so_far = max(max_end, max_so_far)
    return max_so_far


A = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]
print(max_subarray(A))

A = [[1, 2]
    , [0, -1]]
B = [[3, -2]
    , [1, 1]]


def matrix_mult(A, B):
    n = len(A)
    C = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            C[i][j] = 0
            for k in range(n):
                C[i][j] = C[i][j] + A[i][k] * B[k][j]
    return C


print(matrix_mult(A, B))
