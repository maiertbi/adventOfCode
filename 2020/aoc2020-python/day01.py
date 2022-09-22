from itertools import combinations

if __name__ == '__main__':
    file = open("inputFiles/day01.txt", "r")
    data = []
    for x in file:
        data.append(int(x.strip()))
    file.close()

    # Part 1
    for x in combinations(data, 2):
        if x[0] + x[1] == 2020:
            part1 = x[0] * x[1]
            break


    # Part 2
    for x in combinations(data, 3):
        if x[0] + x[1] + x[2] == 2020:
            part2 = x[0] * x[1] * x[2]
            break

    print("Part 1:", part1)
    print("Part 2:", part2)
