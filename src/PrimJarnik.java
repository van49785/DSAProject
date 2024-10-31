import java.util.*;

public class PrimJarnik {
    private int vertices;
    private LinkedList<Edge>[] adjacencyList;

    public PrimJarnik(int vertices) {
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

    public List<Edge> primMST() {
        boolean[] inMST = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<Edge> mst = new ArrayList<>();

        // Bắt đầu từ đỉnh 0
        inMST[0] = true;
        pq.addAll(adjacencyList[0]);

        while(!pq.isEmpty() && mst.size() < vertices -1){
            Edge current = pq.poll();
            if(!inMST[current.target]){
                inMST[current.target] = true;
                mst.add(current);

                for(Edge edge : adjacencyList[current.target]){
                    if(!inMST[edge.target]){
                        pq.add(edge);
                    }
                }
            }
        }

        return mst;
    }
}
