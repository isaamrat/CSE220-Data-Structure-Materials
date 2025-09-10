from DUG_AdjList import addEdgeDUG, printAdjList  # import edge adder and optional printer for the linked-list adjacency
from stack import Stack                             # import custom Stack with push/pop/isEmpty

def adjListBuilder(vertex, edges):                  # build adjacency list from (vertex count, edge list)
    adjList = [None] * vertex                       # initialize one head pointer (None) per vertex
    for i in range(len(edges)):                     # iterate through each edge
        addEdgeDUG(adjList, edges[i][0], edges[i][1])  # prepend edge edges[i][0] -> edges[i][1] into the linked list
    return adjList                                  # return the completed adjacency list

def dfsTraversal(graph, src):                       # iterative DFS starting from src
    visited = [0] * len(graph)                      # visited flags for each vertex (0 = not visited, 1 = visited)
    stck = Stack()                                  # create an explicit stack for DFS
    stck.push(src)                                  # push the source vertex onto the stack
    visited[src] = 1                                # mark source as visited (so it won't be pushed again)

    while stck.isEmpty() != True:                   # continue until the stack becomes empty
        u = stck.pop()                              # pop next vertex to process
        print(u)                                    # "visit" the vertex (print like the BFS file)
        v = graph[u]                                # get head of u's adjacency linked list
        while v is not None:                        # traverse neighbors via linked list
            if visited[v.vertex] != 1:              # if neighbor not visited yet
                stck.push(v.vertex)                 # push neighbor to stack for later processing
                visited[v.vertex] = 1               # mark neighbor visited at push time to avoid duplicates
            v = v.next                              # move to next edge node in the adjacency list

if __name__ == "__main__":                          # run example when executed directly
    totalVertex = 7                                 # number of vertices: 0..6
    edges = [                                      # directed edges (same set as BFS example)
        [0, 1], [0, 3], [1, 2], [1, 3], [1, 5],
        [2, 4], [2, 5], [3, 4], [4, 6], [6, 1],
    ]
    adjList = adjListBuilder(totalVertex, edges)    # build adjacency list
    # printAdjList(adjList)                         # (optional) visualize adjacency before DFS
    dfsTraversal(adjList, 0)                        # perform DFS starting at vertex 0
