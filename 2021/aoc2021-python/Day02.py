with open("input/day02.txt") as file:
    data = [line.split() for line in file]

data = [[line[0], int(line[1])] for line in data]

# Part 1 ===
horiz = depth = 0
for x in data:
    word = x[0]
    num = x[1]
    if word == 'forward':
        horiz += num
    elif word == 'down':
        depth += num
    elif word == 'up':
        depth -= num

part1 = horiz * depth

# Part 2 ===
horiz = depth = aim = 0
for x in data:
    word = x[0]
    num = x[1]
    if word == 'forward':
        horiz += num
        depth += (num * aim)
    elif word == 'down':
        aim += num
    elif word == 'up':
        aim -= num

part2 = horiz * depth

print("Part 1:", part1)
print("Part 2:", part2)
