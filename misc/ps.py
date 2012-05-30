def solve(str):
    i = 0
    for s in str:
        if s == ")":  i -= 1
        elif s == "(": i += 1
        if i < 0: return False
    return i == 0


assert solve("(") == False
assert solve("(") == False
assert solve(")(") == False
assert solve("()") == True
