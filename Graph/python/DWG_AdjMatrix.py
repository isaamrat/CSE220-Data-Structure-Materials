def addEdgeDWG(adjMatrix, src, dest, weight):
    adjMatrix[src][dest] = weight


def printAdjMatrix(adjMatrix):
    n = len(adjMatrix)

    # header
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


def inDegreeEdgeWeight(adjMatrix, vertex):
    count = 0
    for i in range(len(adjMatrix)):
        count += adjMatrix[i][vertex]
    return count


def outDegreeEdgeWeight(adjMatrix, vertex):
    count = 0
    row = adjMatrix[vertex]
    for i in range(len(row)):
        count += row[i]
    return count


n = 6
adjMatrix = [[0] * n for _ in range(n)]
addEdgeDWG(adjMatrix, 0, 1, 2)
addEdgeDWG(adjMatrix, 0, 4, 4)
addEdgeDWG(adjMatrix, 1, 5, 7)
addEdgeDWG(adjMatrix, 2, 3, 3)
addEdgeDWG(adjMatrix, 2, 4, 5)
addEdgeDWG(adjMatrix, 4, 5, 1)
addEdgeDWG(adjMatrix, 1, 2, 6)
addEdgeDWG(adjMatrix, 4, 1, 2)

printAdjMatrix(adjMatrix)
print("The in-degree-edges-weight of vertex 4 : " + str(inDegreeEdgeWeight(adjMatrix, 4)))
print("The out-degree-edges-weight of vertex 4 : " + str(outDegreeEdgeWeight(adjMatrix, 4)))


