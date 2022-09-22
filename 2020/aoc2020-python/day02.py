if __name__ == '__main__':
    file = open("inputFiles/day02.txt", "r")
    data = []
    for x in file:
        data.append(x.strip())
    file.close()

    # Part 1
    part1 = 0
    for x in data:
        x = x.split()
        numbers = x[0].split(sep="-")

        min = int(numbers[0])
        max = int(numbers[1])

        letter = x[1][0]
        pwd = x[2]

        if min <= pwd.count(letter) <= max:
            part1 += 1

    # Part 2
    part2 = 0
    for x in data:
        x = x.split()
        numbers = x[0].split(sep="-")

        pos1 = int(numbers[0]) - 1
        pos2 = int(numbers[1]) - 1

        letter = x[1][0]
        pwd = x[2]

        first = None
        second = None
        if pwd[pos1] == letter:
            first = pwd[pos1]
        if pwd[pos2] == letter:
            second = pwd[pos1]

        if first != second:  # statt != würde auch ^ gehen (=XOR)
            part2 += 1

    print("Part 1:", part1)
    print("Part 2:", part2)