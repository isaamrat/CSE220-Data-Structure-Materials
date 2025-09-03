class UU_Edge:
    def __init__(self, dest):
        self.vertex = dest
        self.next = None


def addEdgeUUG(adjList, src, dest):
    # src -> dest
    temp = adjList[src]
    newEdge = UU_Edge(dest)
    newEdge.next = temp
    adjList[src] = newEdge
    # dest -> src
    temp = adjList[dest]
    newEdge = UU_Edge(src)
    newEdge.next = temp
    adjList[dest] = newEdge


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


def countDegree(adjList, target):
    count = 0
    temp = adjList[target]
    while temp is not None:
        count += 1
        temp = temp.next
    return count


n = 6
adjList = [None] * n
addEdgeUUG(adjList, 0, 5)
addEdgeUUG(adjList, 0, 4)
addEdgeUUG(adjList, 0, 2)
addEdgeUUG(adjList, 5, 4)
addEdgeUUG(adjList, 5, 1)
addEdgeUUG(adjList, 1, 4)
addEdgeUUG(adjList, 2, 4)
addEdgeUUG(adjList, 2, 3)

printAdjList(adjList)
print("The degree of vertex 4 : " + str(countDegree(adjList, 4)))


