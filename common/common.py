def binary_search(A, key):
    low, high = 0, len(A)
    while low <= high:
        mid = low + (high - low) // 2
        if A[mid] == key: return mid
        if A[mid] < key: low = mid + 1
        else: high = mid - 1
    return None


class Vertex:
    def __init__(self, label):
        self.label = label

    def __str__(self):
        return str(self.label)

    def __repr__(self):
        return self.__str__()



  