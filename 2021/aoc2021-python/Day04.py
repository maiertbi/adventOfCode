def getFile():
    lines = open("../../../../../stuff/smallProjects/adventOfCode/2021/aoc2021-python/input/day04.txt").read().split("\n\n")
    ORDER = map(int, lines[0].split(","))
    # 3-nested list comprehension
    BOARDS = [[[int(x) for x in map(str.strip, row.split(" ")) if x != ""]
               for row in line.split("\n")] for line in lines[1:]]
    INVERT = []
    for board in BOARDS:
        INVERT.append(list(map(list, zip(*board))))
    return [ORDER, BOARDS, INVERT]


temp = getFile()
ORDER = temp[0]
BOARDS = temp[1]
INVERT = temp[2]


def solution():  # game logic and win
    won = []
    checkWin = [-1] * 5

    for n in ORDER:
        for board in range(len(BOARDS)):
            for line in range(5):
                for num in range(5):
                    if n == BOARDS[board][line][num]:
                        BOARDS[board][line][num] = -1
                    if n == INVERT[board][line][num]:
                        INVERT[board][line][num] = -1

                # checkwin
                if BOARDS[board][line] == checkWin:
                    won.append(calcSum(BOARDS[board], n))
                    markAsSeen(board)
                elif INVERT[board][line] == checkWin:
                    won.append(calcSum(INVERT[board], n))
                    markAsSeen(board)

    return [x for x in won if x != 0]


def calcSum(board, n):
    return sum(sum(num for num in line if num != -1) for line in board) * n


def markAsSeen(board):
    BOARDS[board] = [[-1 for _ in line] for line in BOARDS[board]]
    INVERT[board] = [[-1 for _ in line] for line in INVERT[board]]


sol = solution()
print("Part 1:", sol[0])
print("Part 2:", sol[-1])
