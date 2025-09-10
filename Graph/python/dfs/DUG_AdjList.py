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



