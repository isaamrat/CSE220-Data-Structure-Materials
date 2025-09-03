def addEdgeDUG(adjMatrix, src, dest):
    adjMatrix[src][dest] = 1


def printAdjMatrix(adjMatrix):
    n = len(adjMatrix)

    # header row
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


def countInDegree(adjMatrix, vertex):
    count = 0
    for i in range(len(adjMatrix)):
        count += adjMatrix[i][vertex]
    return count


def countOutDegree(adjMatrix, vertex):
    count = 0
    row = adjMatrix[vertex]
    for i in range(len(row)):
        count += row[i]
    return count


n = 6
adjMatrix = [[0] * n for _ in range(n)]
addEdgeDUG(adjMatrix, 0, 1)
addEdgeDUG(adjMatrix, 0, 4)
addEdgeDUG(adjMatrix, 1, 5)
addEdgeDUG(adjMatrix, 2, 3)
addEdgeDUG(adjMatrix, 2, 4)
addEdgeDUG(adjMatrix, 4, 5)
addEdgeDUG(adjMatrix, 1, 2)
addEdgeDUG(adjMatrix, 4, 1)
addEdgeDUG(adjMatrix, 0, 3)

printAdjMatrix(adjMatrix)
print("The in-degree of vertex 2 : " + str(countInDegree(adjMatrix, 2)))
print("The out-degree of vertex 2 : " + str(countOutDegree(adjMatrix, 2)))


