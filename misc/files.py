import random

lines = []
with open("random_lines") as f:
    lines = [line for line in f]
random.shuffle(lines)
with open("random_lines", 'w') as f:
    f.write("".join(lines))
  