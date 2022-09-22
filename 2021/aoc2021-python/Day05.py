from collections import defaultdict

part1 = defaultdict(int)
part2 = defaultdict(int)
for line in open("../../../../../stuff/smallProjects/adventOfCode/2021/aoc2021-python/input/day05.txt", "r"):
    start, end = line.split(" -> ")
    x1, y1 = start.split(",")
    x2, y2 = end.split(",")
    x1, y1, x2, y2 = int(x1), int(y1), int(x2), int(y2)

    dx = x2 - x1
    dy = y2 - y1

    # for-loop by Jonathan Paulson
    for i in range(1 + max(abs(dx), abs(dy))):
        x = x1 + (1 if dx > 0 else (-1 if dx < 0 else 0)) * i
        y = y1 + (1 if dy > 0 else (-1 if dy < 0 else 0)) * i
        if dx == 0 or dy == 0:
            part1[(x, y)] += 1
        part2[(x, y)] += 1

print("Part1: ", len([k for k in part1 if part1[k] > 1]))
print("Part2: ", len([k for k in part2 if part2[k] > 1]))
