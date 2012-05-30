coins, target = [1, 2], 5
ways = [1] + [0] * target
for coin in coins:
    for j in range(coin, target + 1):
        ways[j] += ways[j - coin]
print(ways[target])