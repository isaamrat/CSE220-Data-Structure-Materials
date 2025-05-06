from queue import Queue  # Import Queue class for BFS

# Define the Edge class to represent each edge in the graph
class Edge:
    def __init__(self, ver):
        self.vertice = ver    # Store the destination vertex of the edge
        self.next = None      # Pointer to the next edge in the adjacency list

# Function to add an undirected edge between v1 and v2
def addEdge(graph, v1, v2):
    # Add edge from v1 to v2
    newNode = Edge(v2)
    newNode.next = graph[v1]  # Insert at the head of v1's adjacency list
    graph[v1] = newNode

    # Since the graph is undirected, also add edge from v2 to v1
    newNode = Edge(v1)
    newNode.next = graph[v2]
    graph[v2] = newNode

# Function to print the graph as an adjacency list
def showGraph(graph):
    for i in range(len(graph)):
        print(i, end=' : ')   # Print current vertex
        temp = graph[i]       # Get the head of the adjacency list
        while temp is not None: # Loop through the linked list for the current vertex
            print(f'({temp.vertice})', end=' -> ')  # Print adjacent vertex
            temp = temp.next   # Move to the next adjacent vertex
        print('None')          # End of adjacency list

# Function to perform Breadth-First Search starting from the 'start' vertex
def bfs(graph, start):
    visited = [False] * len(graph)  # Track visited vertices
    queue = Queue()                 # Create a queue for BFS
    queue.put(start)               # Enqueue the starting vertex
    visited[start] = True          # Mark the start as visited

    while not queue.empty():       # Loop until the queue becomes empty
        node = queue.get()         # Dequeue a vertex
        print(node, end=' ')       # Process the vertex
        temp = graph[node]         # Traverse adjacency list of current vertex
        while temp is not None:    # Traverse all adjacent vertices
            if not visited[temp.vertice]:  # If adjacent vertex is not visited
                queue.put(temp.vertice)    # Enqueue the vertex
                visited[temp.vertice] = True  # Mark as visited
            temp = temp.next

# Function to perform Depth-First Search starting from the 'start' vertex
def dfs(graph, start, visited):
    visited[start] = True            # Mark current vertex as visited
    print(start, end=' ')            # Process the vertex
    temp = graph[start]              # Get the adjacency list
    while temp is not None:          # Loop through all adjacent vertices
        if not visited[temp.vertice]:  # If adjacent vertex is not visited
            dfs(graph, temp.vertice, visited)  # Recursively visit it
        temp = temp.next

# Initialize the graph with 8 vertices (0 through 7), all set to None
g1 = [None] * 8

# Add edges to form an undirected, unweighted graph
addEdge(g1, 0, 1)
addEdge(g1, 0, 2)
addEdge(g1, 0, 7)
addEdge(g1, 1, 4)
addEdge(g1, 2, 4)
addEdge(g1, 2, 3)
addEdge(g1, 3, 5)
addEdge(g1, 3, 6)
addEdge(g1, 6, 7)

print("====================================")
print("Graph Representation in Adjacency List")
print("====================================")

# Display the graph
showGraph(g1)

print("====================================")
print("Graph Traversal")
print("====================================")

# Perform and print the result of Breadth-First Search
print("BFS: ", end='')
bfs(g1, 0)
print()

# Perform and print the result of Depth-First Search
print("DFS: ", end='')
visited = [False]*len(g1)  # Reset visited array for DFS
dfs(g1, 0, visited)
