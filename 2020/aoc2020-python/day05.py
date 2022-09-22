if __name__ == '__main__':
    file = open("inputFiles/day05.txt", "r")
    data = []
    for x in file:
        data.append(x.strip())
    file.close()

    # Part 1
    seats = []
    for psprt in data:
        lower = 0  # F
        upper = 127  # B

        # Row
        for i in range(7):
            mid = (lower + upper) / 2
            if psprt[i] == "F":
                upper = int(mid)
            elif psprt[i] == "B":
                if not mid.is_integer():  # / ungerade Nummer --> Rest; +1 um richtig zu kürzen
                    mid += 1
                lower = int(mid)
        row = lower

        # Col
        lower = 0  # L
        upper = 7  # R

        for i in range(7, 10):
            mid = (lower + upper) / 2
            if psprt[i] == "L":
                upper = int(mid)
            elif psprt[i] == "R":
                if not mid.is_integer():
                    mid += 1
                lower = int(mid)

        col = lower
        seat_id = row * 8 + col
        seats.append(seat_id)

    # Part 2
    seats.sort()
    counter = seats[0]
    for i in range(len(seats)):
        if counter != seats[i]:
            break
        counter += 1

    print("Part 1:", max(seats))
    print("Part 2:", counter)