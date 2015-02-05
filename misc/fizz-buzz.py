for n in range(101):
    r3, r5 = n % 3, n % 5
    if not r3:
        print('fizz', end='')
    if not r5:
        print('buzz', end='')
    if r3 and r5:
        print(n, end='')
  