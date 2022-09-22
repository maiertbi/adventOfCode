def check(right, bottom):
    x, y = 0, 0
    counter = 0

    while not y >= len(field) - 1:
        x += right
        y += bottom

        if x >= width:
            x -= width
        if field[y][x] == "#":
            counter += 1

    return counter


if __name__ == '__main__':
    file = open("inputFiles/day03.txt", "r")
    field = []
    for line in file:
        field.append(line.strip())

    width = len(field[0])

    part1 = check(3, 1)
    part2 = check(1, 1) * check(3, 1) * check(5, 1) * check(7, 1) * check(1, 2)

    print("Part 1:", part1)
    print("Part 2:", part2)
