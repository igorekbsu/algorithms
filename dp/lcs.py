from collections import defaultdict

def memoize(fn):
    cache = dict()

    def wrapped(*v):
        key = tuple(v)
        if key not in cache:
            cache[key] = fn(*v)
        return cache[key]

    return wrapped


@memoize
def lcs(A, B):
    n, m = len(A), len(B)
    if n and m:
        if A[0] == B[0]:
            return A[0] + lcs(A[1:], B[1:])
        else:
            return max(lcs(A[1:], B), lcs(A, B[1:]), key=len)
    else: return ""


def count_lcs_calls(lcs):
    calls = defaultdict(int)

    def wrapped(A, B):
        calls[(A, B)] += 1
        return lcs(A, B)

    return wrapped, calls

lcs, calls = count_lcs_calls(lcs)
lcs('ACCGGTCGAGTGCGCGGAAGCCGGCCGAA', 'GTCGTTCGGAATGCCGTTGCTCTGTAAA')

seq = "character"
print(lcs(seq, seq[::-1]))

