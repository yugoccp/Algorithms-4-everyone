"""
This snippet implements dijkstra's algorithm in Python.
Currently it works only with graphs defined by integers for both directed and undirected graphs
It doesn't work with negative weight edges.
Python version: 3.5.2

Possible improvements (I think so, not sure):
    Remove dependency of integer type and sys.maxsize, using comparable types and logic instead
    Add test cases to an unit test class as seen here: https://docs.python.org/2/library/unittest.html
    Add more test cases
"""

import sys

"""
utility function to find the minimun value between values that aren't processed yet

param dist_array: Array of integers with the distances from the vertex vert
param processed: Array of booleans with True for processed values, False otherwise 
return min: the index of the shortest distance vertex that is not processed, -1 if all the values are already processed
"""
def min_dist_index(dist_array, processed):
    vert = -1
    min = sys.maxsize # Maximum value for int value in python 3.0

    for i in range(len(dist_array)):
        if not(processed[i]) and min > dist_array[i]:
            min = dist_array[i]
            vert = i

    return vert

"""
Algorithm to find the shortest distance from all vertex in a graph to the vertex vert

param adj: Adjancency matrix of the graph, non-existing edges should be represented by -1
param vert: The vertex from which the distance will be calculated
return distance: Array with the shortest path from vert to all other vertices
"""
def dijsktra(adj, vert):
    distance = [0] * len(adj[vert])
    processed = [False] * len(adj[vert])

	# Initializes the distance array of initial vertex with values from the adjacency matrix
	# if the edge is unexistent (-1), sets the distance as maxsize
    for i in range(len(adj[vert])):
        if adj[vert][i] == -1:
            distance[i] = sys.maxsize
        else:
            distance[i] = adj[vert][i]

    # initializes distance to initial vertex as 0
    distance[vert] = 0
    processed[vert] = True

    # It keeps running until all minimum distances between vertex have been calculated
    while True:

        v = min_dist_index(distance, processed)

        if v == -1: break

        processed[v] = True

        # Ternary operator to determine the shortest path between:
        # initial vertex (vert) -> ith vertex and
        # initial vertex (vert) -> current closest vertex (v) -> ith vertex
        for i in range(len(distance)):
            distance[i] = distance[i] if distance[i] < distance[v] + adj[v][i] else distance[v] + adj[v][i]

    return distance

def printSolution(dist):
    print ("Vertex Distance from source")
    for d, i in zip(dist, range(len(dist))):
        print (str(i) + " tt " + str(d))

def test_undirect():
    adj =  [[0, 4, -1, -1, -1, -1, -1, 8, -1],
            [4, 0, 8, -1, -1, -1, -1, 11, -1],
            [-1, 8, 0, 7, -1, 4, -1, -1, 2],
            [-1, -1, 7, 0, 9, 14, -1, -1, -1],
            [-1, -1, -1, 9, 0, 10, -1, -1, -1],
            [-1, -1, 4, 14, 10, 0, 2, -1, -1],
            [-1, -1, -1, -1, -1, 2, 0, 1, 6],
            [8, 11, -1, -1, -1, -1, 1, 0, 7],
            [-1, -1, 2, -1, -1, -1, 6, 7, 0]]

    for i in range(len(adj)):
        for j in range(len(adj[i])):
            if adj[i][j] == -1:
                adj[i][j] = sys.maxsize

    print ("Testing undirected graph")
    print ("Results: ")
    shortest = dijsktra(adj, 0)
    printSolution(shortest)

def test_directed():
    adj =  [[0, 2, -1, 1, -1, -1, -1],
            [-1, 0, -1, 3, 10, -1, -1],
            [4, -1, 0, -1, -1, 5, -1],
            [-1, -1, 2, 0, 2, 8, 4],
            [-1, -1, -1, -1, 0, -1, 6],
            [-1, -1, -1, -1, -1, 0, -1],
            [-1, -1, -1, -1, -1, 1, 0]]

    for i in range(len(adj)):
        for j in range(len(adj[i])):
            if adj[i][j] == -1:
                adj[i][j] = sys.maxsize

    print ("Testing directed graph... ")
    print ("Result: ")
    shortest = dijsktra(adj, 0)
    printSolution(shortest)

test_undirect()
test_directed()
