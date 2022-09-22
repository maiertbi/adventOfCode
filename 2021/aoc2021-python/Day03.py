data = [line.strip() for line in open("../../../../../stuff/smallProjects/adventOfCode/2021/aoc2021-python/input/day03.txt")]


# improved PLoC by TechnoTone(github)
def zeroCounter(input, pos):
    return len(list(filter(lambda a: a[pos] == "0", input)))  # returns how many lines with 0 on pos


# Part 1 ===
gamma = epsilon = ""

for a in range(len(data[0])):
    if zeroCounter(data, a) * 2 > len(data):
        gamma += "0"
        epsilon += "1"
    else:
        gamma += "1"
        epsilon += "0"

part1 = int(gamma, 2) * int(epsilon, 2)


# Part 2 ===
dataCopy = data

def solution2(input, pos, searching):
    opp = "0" if searching == "1" else "1"

    if zeroCounter(input, pos) * 2 > len(input):
        return [num for num in input if num[a] != searching]
    else:
        return [num for num in input if num[a] != opp]


for a in range(len(data[0])): # o2
    if len(data) == 1: break
    data = solution2(data, a, "1")

for a in range(len(dataCopy[0])): # co2
    if len(dataCopy) == 1: break
    dataCopy = solution2(dataCopy, a, "0")

part2 = int(data[0], 2) * int(dataCopy[0], 2)


print("Part 1:", part1)
print("Part 2:", part2)
