def p(x, y):
    return x / (2 * (x + y)) + (10 - x) / (2 * (20 - x - y))

max_x, max_y, max_val = -1, -1, -1
for x in range(11):
    for y in range(11):
        if x != y != 0 or x != y != 10:
            if p(x, y) > max_val:
                max_val = p(x, y)
                max_x, max_y = x, y
print(max_x, max_y, max_val)

coins, target = {1, 2, 4}, 6
ways = [1] + [0] * target
for coin in coins:
    for i in range(coin, target + 1):
        ways[i] += ways[i - coin]
print(ways[target])

