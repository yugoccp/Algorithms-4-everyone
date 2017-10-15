import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.System.out;

public class Bellman_Ford_Algorithm {
    public static int total_nodes, edges;
    public static LinkedList<Edge> Edges;

    public static int[] bellmanFord(int source) {
        //initialise distance array
        int distances[] = new int[total_nodes + 1];
        //set all distances node maximum as possible
        Arrays.fill(distances, Integer.MAX_VALUE);
        //set source distance 0
        distances[source] = 0;
        for (int i = 0; i < Edges.size(); i++) {

            //if dis(x)+weight < dis(y) , then dis(y)=dis(x)+weight
            if (distances[Edges.get(i).x] != Integer.MAX_VALUE)
                if (distances[Edges.get(i).x] + Edges.get(i).weight < distances[Edges.get(i).y])
                    distances[Edges.get(i).y] = distances[Edges.get(i).x] + Edges.get(i).weight;
        }
        //return distances array
        return distances;

    }

    public static void main(String as[]) {
        Scanner sc = new Scanner(System.in);
        //Process Inputs
        total_nodes = sc.nextInt();
        edges = sc.nextInt();
        //Initialise Edges
        Edges=new LinkedList<>();
        //Add Edge :   from -> next = weight
        while (edges-->0)Edges.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        //print distance array
        out.println(Arrays.toString(bellmanFord(sc.nextInt())));

    }


}
//Custom class for Edge 
class Edge {
    int x, y, weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}
