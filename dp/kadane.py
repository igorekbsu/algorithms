def max_subarray_sum(A):
    max_ending = max_so_far = 0
    for e in A:
        max_ending = max(e, max_ending + e)
        max_so_far = max(max_ending, max_so_far)
    return max_so_far

A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
assert max_subarray_sum(A) == 6