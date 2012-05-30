def get_most_work(folders, workers):
    low, high = max(folders), sum(folders)
    while low < high:
        mid = low + (high - low) // 2
        required, current_load = 1, 0
        for i in range(len(folders)):
            if current_load + folders[i] <= mid:
                current_load += folders[i]
            else:
                required += 1
                current_load = folders[i]
        if required <= workers:
            high = mid
        else:
            low = mid + 1
    return low

assert get_most_work([1, 3, 1, 9], 1) == 14
assert get_most_work([10, 20, 30, 40, 50, 60, 70, 80, 90], 5) == 110
assert get_most_work([568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782], 4) == 1785
assert get_most_work([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000], 2) == 1000


  