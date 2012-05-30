from copy import copy

values, W, counter = [(10, 60), (20, 100), (30, 120)], 50, 0

def maximize(values, W):
    global counter
    counter += 1
    m = 0
    for val in values:
        new_values = copy(values)
        new_values.remove(val)
        if W - val[0] >= 0:
            result = val[1] + maximize(new_values, W - val[0])
            if result > m:
                m = result
    return m


print(maximize(values, W), counter)
  