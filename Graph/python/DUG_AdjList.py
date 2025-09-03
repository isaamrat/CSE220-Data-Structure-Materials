class DU_Edge:
    def __init__(self, dest):
        self.vertex = dest
        self.next = None


def addEdgeDUG(adjList, src, dest):
    head = adjList[src]
    newEdge = DU_Edge(dest)
    newEdge.next = head
    adjList[src] = newEdge


def printAdjList(adjList):
    for i in range(len(adjList)):
        temp = adjList[i]
        print(i,':',end=' ')
        while temp is not None:
            if temp.next is not None:
                print(temp.vertex, end=', ')
            else:
                print(temp.vertex, end='')
            temp = temp.next
        print()


def countOutDegree(adjList, target):
    count = 0
    temp = adjList[target]
    while temp is not None:
        count += 1
        temp = temp.next
    return count


def countInDegree(adjList, target):
    count = 0
    i = 0
    while i < len(adjList):
        temp = adjList[i]
        while temp is not None:
            if temp.vertex == target:
                count += 1
            temp = temp.next
        i += 1
    return count


n = 6
adjList = [None] * n

addEdgeDUG(adjList, 0, 1)
addEdgeDUG(adjList, 0, 4)
addEdgeDUG(adjList, 1, 5)
addEdgeDUG(adjList, 2, 3)
addEdgeDUG(adjList, 2, 4)
addEdgeDUG(adjList, 4, 5)
addEdgeDUG(adjList, 1, 2)
addEdgeDUG(adjList, 4, 1)

printAdjList(adjList)

v = 2
print("In-degree(" + str(v) + ")  = " + str(countInDegree(adjList, v)))
print("Out-degree(" + str(v) + ") = " + str(countOutDegree(adjList, v)))


