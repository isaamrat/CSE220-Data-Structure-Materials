class DW_Edge:
    def __init__(self, dest, w):
        self.vertex = dest
        self.weight = w
        self.next = None


def addEdgeDWG(adjList, src, dest, weight):
    head = adjList[src]
    newEdge = DW_Edge(dest, weight)
    newEdge.next = head
    adjList[src] = newEdge


def printAdjList(adjList):
    for i in range(len(adjList)):
        temp = adjList[i]
        print(i,':',end=' ')
        while temp is not None:
            if temp.next is not None:
                print(f"({temp.vertex},{temp.weight})", end=", ")
            else:
                print(f"({temp.vertex},{temp.weight})", end="")
            temp = temp.next
        print()


def outDegreeEdgeWeight(adjList, vertex):
    count = 0
    temp = adjList[vertex]
    while temp is not None:
        count += temp.weight
        temp = temp.next
    return count


def inDegreeEdgeWeight(adjList, vertex):
    count = 0
    i = 0
    while i < len(adjList):
        temp = adjList[i]
        while temp is not None:
            if temp.vertex == vertex:
                count += temp.weight
            temp = temp.next
        i += 1
    return count


n = 6
adjList = [None] * n

addEdgeDWG(adjList, 0, 1, 2)
addEdgeDWG(adjList, 0, 4, 4)
addEdgeDWG(adjList, 1, 5, 7)
addEdgeDWG(adjList, 2, 3, 3)
addEdgeDWG(adjList, 2, 4, 5)
addEdgeDWG(adjList, 4, 5, 1)
addEdgeDWG(adjList, 1, 2, 6)
addEdgeDWG(adjList, 4, 1, 2)

printAdjList(adjList)

v = 4
print("The in-degree-edges-weight of vertex " + str(v) + " : " + str(inDegreeEdgeWeight(adjList, v)))
print("The out-degree-edges-weight of vertex " + str(v) + " : " + str(outDegreeEdgeWeight(adjList, v)))


