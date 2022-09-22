if __name__ == '__main__':
    file = open("inputFiles/day04.txt", "r")
    data = []
    for x in file:
        data.append(x.strip())
    file.close()
    data.append("")  # needed for parsing

    REQUIRED = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"}

    # from data into dictionary
    passports, passport = [], {}
    for line in data:
        if line == "":
            passports.append(passport)
            passport = {}
        else:
            fields = line.split()
            for field in fields:
                field = field.split(":")
                passport[field[0]] = field[1]

    # Part 1
    part1 = 0
    for passport in passports:
        if all(x in passport for x in REQUIRED):
            part1 += 1

    # Part 2
    part2 = 0
    for passport in passports:

        try:
            byr = 2002 >= int(passport["byr"]) >= 1920
            iyr = 2020 >= int(passport["iyr"]) >= 2010
            eyr = 2030 >= int(passport["eyr"]) >= 2020
            hcl = passport["hcl"].startswith("#") and len(passport["hcl"]) == 7
            ecl = passport["ecl"] in {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"}
            pid = len(passport["pid"]) == 9 and passport["pid"].isnumeric()

            int(passport["hcl"][1:], 16)  # Convert to int from hex

            height = int(passport["hgt"][:-2])
            if passport["hgt"].endswith("cm"):
                hgt = 193 >= height >= 150

            elif passport["hgt"].endswith("in"):
                hgt = 76 >= height >= 59

            else:
                hgt = False

            if all((byr, iyr, eyr, hgt, hcl, ecl, pid)):
                part2 += 1

        except:
            pass

    print("Part 1:", part1)
    print("Part 2:", part2)