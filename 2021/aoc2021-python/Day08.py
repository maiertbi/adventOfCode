data = []
for x in open("../../../../../stuff/smallProjects/adventOfCode/2021/aoc2021-python/input/day08.txt").readlines():
    patterns, outputs = x.split(" | ")
    patterns = [set(a) for a in patterns.strip().split(" ")]
    outputs = [set(a) for a in outputs.strip().split(" ")]
    data.append((patterns, outputs, {}))


def sol1():
    countDigits = 0
    possibleLengths = [2, 3, 4, 7]  # number 1, 7, 4, and 8
    for display in data:
        countDigits += sum(map(lambda x: 1 if len(x) in possibleLengths else 0, display[1]))
        # for digit in x[1]:
        #     if len(digit) in possibleLengths:
        #         countDigits += 1
    return countDigits

# Solution from Ian Findlay
def sol2():
    countDigits = 0
    for display in data:
        patterns, outputs, mappings = display

        for pattern in patterns:
            if len(pattern) == 2:
                mappings[1] = pattern
            elif len(pattern) == 3:
                mappings[7] = pattern
            elif len(pattern) == 4:
                mappings[4] = pattern
            elif len(pattern) == 7:
                mappings[8] = pattern

        for n in (1, 4, 7, 8):
            patterns.remove(mappings[n])

        # 6: only 6 letter signal without all of 7 in it = segment c
        segment_c = None

        for pattern in patterns:
            if len(pattern) == 6:
                diff_to_7 = mappings[7].difference(pattern)
                if diff_to_7:
                    mappings[6] = pattern
                    patterns.remove(pattern)
                    segment_c = diff_to_7.pop()
                    break
        # 3: is 5 letter signal that contains all of 7
        for pattern in patterns:
            if len(pattern) == 5 and len(mappings[7].intersection(pattern)) == 3:
                mappings[3] = pattern
                patterns.remove(pattern)
                break

        # 5: letter signals left (2 and 5) differ in terms of 'c' segment
        for pattern in patterns:
            if len(pattern) == 5:
                if segment_c in pattern:
                    mappings[2] = pattern
                else:
                    mappings[5] = pattern
        patterns.remove(mappings[2])
        patterns.remove(mappings[5])

        # 9: is 5 but with 'c' segment
        mappings[9] = mappings[5].copy()
        mappings[9].add(segment_c)
        patterns.remove(mappings[9])

        # 0: is only pattern left
        mappings[0] = patterns.pop()

        output_value = ''
        for output in outputs:
            for digit, pattern in mappings.items():
                if pattern == output:
                    output_value += str(digit)

        countDigits += int(output_value)

    return countDigits


print("Part1:", sol1())
print("Part2:", sol2())
