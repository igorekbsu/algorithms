from data import *

def merge(A, B):
    C = []
    while A and B:
        if A[0] < B[0]: C.append(A.pop(0))
        else: C.append(B.pop(0))
    C.extend(A)
    C.extend(B)
    return C

print(merge(sorted(A1), sorted(A2)))
  