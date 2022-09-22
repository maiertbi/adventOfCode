if __name__ == '__main__':
    file = open("inputFiles/day06.txt", "r")
    data = []
    for x in file:
        data.append(x.strip())
    file.close()