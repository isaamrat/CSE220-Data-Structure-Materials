from linkedListQueue import Queue  # imports the local queue.py

def addEdgeDUG(adjMatrix, src, dest):
    """Adds a directed edge from src to dest in the adjacency matrix."""
    adjMatrix[src][dest] = 1

def adjMatrixBuilder(vertices, edges):
    """Builds an adjacency matrix from the list of edges."""
    adjMatrix = [[0 for _ in range(vertices)] for _ in range(vertices)]
    for e in edges:
        addEdgeDUG(adjMatrix, e[0], e[1])
    return adjMatrix

def bfs(graph, source):
    """Breadth-First Search traversal starting from a given source."""
    visited = [0] * len(graph)
    q = Queue()
    q.enqueue(source)
    visited[source] = 1

    while q.isEmpty() != True:
        u = q.dequeue()
        print(u)
        for i in range(len(graph[u])):
            if graph[u][i] != 0:
                if visited[i] != 1:
                    q.enqueue(i)
                    visited[i] = 1

if __name__ == "__main__":
    totalVertice = 7
    edges = [[0,1],[0,3],[1,2],[1,3],[1,5],[2,4],[2,5],[3,4],[4,6],[6,1]]
    adjMatrix = adjMatrixBuilder(totalVertice, edges)
    bfs(adjMatrix, 0)
