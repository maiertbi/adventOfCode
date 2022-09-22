import statistics
from collections import defaultdict

data = [int(x) for x in "16,1,2,0,4,2,7,1,2,14".split(",")]


def sol1():
    median = int(statistics.median(data))
    return sum(map(lambda x: abs(x - median), data))
    # fuel = 0
    # for x in data:
    #     fuel += abs(x-median)
    # return fuel


def sol2():
    diffDistance = defaultdict(int)
    for x in data:
        if x not in diffDistance:
            diffDistance[x] = 0
        diffDistance[x] += 1

    distance = max(diffDistance.keys()) - min(diffDistance.keys())

    fuel = defaultdict(int)
    for x in range(distance + 1):
        fuel[x] = 0

    fuelLoss = [0, 1]
    while len(fuelLoss) <= distance:  # calculates sum of fuelAdd per Distance
        fuelLoss.append(fuelLoss[-1] + len(fuelLoss))

    for x in range(distance + 1):
        for i in diffDistance.keys():
            fuel[x] += fuelLoss[abs(x - i)] * diffDistance[i]

    return min(fuel.values())


print("Part 1:", sol1())
print("Part 2:", sol2())
