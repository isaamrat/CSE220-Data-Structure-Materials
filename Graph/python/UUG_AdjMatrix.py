def addEdgeUUG(adjMatrix, src, dest):
    adjMatrix[src][dest] = 1
    adjMatrix[dest][src] = 1


def printAdjMatrix(adjMatrix):
    n = len(adjMatrix)

    # headers
    header = "    "
    j = 0
    while j < n:
        header += str(j) + " "
        j += 1
    print(header)

    # separator
    sep = "   "
    j = 0
    while j < n:
        sep += "--"
        j += 1
    print(sep)

    # rows
    i = 0
    while i < n:
        row = str(i) + " | "
        j = 0
        while j < n:
            row += str(adjMatrix[i][j]) + " "
            j += 1
        print(row)
        i += 1


def countDegree(adjMatrix, vertex):
    count = 0
    i = 0
    row = adjMatrix[vertex]
    while i < len(row):
        count += row[i]
        i += 1
    return count



n = 6
adjMatrix = [[0] * n for _ in range(n)]
addEdgeUUG(adjMatrix, 0, 5)
addEdgeUUG(adjMatrix, 0, 4)
addEdgeUUG(adjMatrix, 0, 2)
addEdgeUUG(adjMatrix, 5, 4)
addEdgeUUG(adjMatrix, 5, 1)
addEdgeUUG(adjMatrix, 1, 4)
addEdgeUUG(adjMatrix, 2, 4)
addEdgeUUG(adjMatrix, 2, 3)

printAdjMatrix(adjMatrix)
print("The degree of vertex 4 : " + str(countDegree(adjMatrix, 4)))


