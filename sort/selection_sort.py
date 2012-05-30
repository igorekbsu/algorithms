from data import *
def selection_sort(A):
    for i in range(0, len(A) - 1):
        smallest = i
        for j in range(smallest + 1, len(A)):
            if A[smallest] > A[j]:
                smallest = j
        temp = A[i]
        A[i] = A[smallest]
        A[smallest] = temp
selection_sort(A1)
print(A1)

  