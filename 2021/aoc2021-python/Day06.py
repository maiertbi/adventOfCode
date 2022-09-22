# open("input/day06.txt").read()
from collections import defaultdict

data = [int(x) for x in open("../../../../../stuff/smallProjects/adventOfCode/2021/aoc2021-python/input/day06.txt").read().split(",")]


def sol1(length):  # possible for Part1 but not efficient
    fishs = data[:]
    for _ in range(length):
        for x, value in enumerate(fishs):
            if value == 0:
                fishs.append(9)
                fishs[x] = 7
            fishs[x] -= 1
    return len(fishs)


def sol2(length):
    fishs = data.copy()
    diffFishes = defaultdict(int)
    for x in fishs:  # make dictionary for every possible Fish (0-8) and their count
        if x not in diffFishes:
            diffFishes[x] = 0
        diffFishes[x] += 1

    for _ in range(length):
        temp = defaultdict(int)
        for index, fishCount in diffFishes.items():
            if index == 0:
                temp[6] += fishCount
                temp[8] += fishCount
            else:
                temp[index - 1] += fishCount
        diffFishes = temp
    return sum(diffFishes.values())


print("Part 1:", sol1(80))
print("Part 2:", sol2(256))
