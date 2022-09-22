data = [int(line) for line in open("../../../../../stuff/smallProjects/adventOfCode/2021/aoc2021-python/input/day01.txt")]


def solution(window):
    counter = 0
    for x in range(len(data) - window):
        if data[x] < data[x + window]:
            counter += 1

    return counter


print("Part 1:", solution(1))
print("Part 2:", solution(3))

# Part 1 ===
# part1 = 0
# prev1 = data[0]
# for x in data:
#     if x > prev1:
#         part1 += 1
#     prev1 = x


# Part 2 ===
# part2 = 0
# prev2 = sum(data[0:3])
# for counter in range(len(data)-2):
#     window = sum(data[counter:counter+3])
#     if window > prev2:
#         part2 += 1
#     prev2 = window
