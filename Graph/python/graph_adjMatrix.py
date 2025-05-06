import numpy as np

def buildGraph(verticeCount):
    graph = np.zeros((verticeCount, verticeCount), dtype=int)
    return graph

def addVertice(graph, src, des, weight=1):
    graph[src][des] = weight

g1 = buildGraph(5)
print(g1)
addVertice(g1, 0, 1, 2)
addVertice(g1, 0, 3, 5)
addVertice(g1, 0, 4, 9)
addVertice(g1, 1, 2, 3)
addVertice(g1, 2, 3, 8)
addVertice(g1, 4, 3, 7)
print('*'*30)
print(g1)