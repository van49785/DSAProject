import java.util.*;

public class Dijkstra {
    private int vertices;
    private LinkedList<Edge>[] adjacencyList;

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i=0;i<vertices;i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    static class Edge {
        int target;
        int weight;
        Edge(int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }

    public void addEdge(int source, int target, int weight){
        adjacencyList[source].add(new Edge(target, weight));
        adjacencyList[target].add(new Edge(source, weight)); // Nếu đồ thị vô hướng
    }

    public int[] shortestPath(int start) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int dist = current[1];

            for(Edge edge : adjacencyList[u]) {
                int v = edge.target;
                int weight = edge.weight;
                if(dist + weight < distances[v]){
                    distances[v] = dist + weight;
                    pq.add(new int[]{v, distances[v]});
                }
            }
        }

        return distances;
    }
}
