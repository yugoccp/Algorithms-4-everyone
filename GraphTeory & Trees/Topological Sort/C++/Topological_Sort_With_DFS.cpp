#include <stdio.h>
#include <stdlib.h>
#include <vector>
#define N 6

using namespace std;

vector<int> topologicalOrder;
vector<int> connected[N];
bool visited[N];

void dfs_top(int n)
{
	visited[n] = 1;
	for(int i: connected[n])
		if(!visited[i])
			dfs_top(i);
	topologicalOrder.push_back(n);
}

int main()
{
	connected[0].push_back(1);
	connected[0].push_back(2);
	connected[1].push_back(2);
	connected[1].push_back(3);
	connected[2].push_back(3);
	connected[2].push_back(5);
	connected[3].push_back(4);

	fill(visited, visited + N, 0);

	dfs_top(0);

	reverse(topologicalOrder.begin(), topologicalOrder.end());

	for(int i: topologicalOrder)
		printf("%d ", i);
}