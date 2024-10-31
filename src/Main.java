
import java.util.List;

//TIP To <b>R</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void main(String[] args) {
//        Stack stack = new Stack(5);  // Create a stack with capacity 5
//
//        // Push elements onto the stack
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//
//        // Peek at the top element
//        System.out.println("Top element is: " + stack.peek());
//
//        // Pop elements from the stack
//        stack.pop();
//        stack.pop();
//
//        // Check if the stack is empty
//        System.out.println("Is the stack empty? " + stack.isEmpty());
//
//        // Attempt to pop from an empty stack to demonstrate exception handling
//        stack.pop();  // This will throw an exception if the stack becomes empty
//    }
public static void main(String[] args) {
    // Ví dụ với Dijkstra
    Dijkstra dijkstra = new Dijkstra(5);
    dijkstra.addEdge(0, 1, 10);
    dijkstra.addEdge(0, 2, 3);
    dijkstra.addEdge(1, 2, 1);
    dijkstra.addEdge(1, 3, 2);
    dijkstra.addEdge(2, 1, 4);
    dijkstra.addEdge(2, 3, 8);
    dijkstra.addEdge(2, 4, 2);
    dijkstra.addEdge(3, 4, 7);
    dijkstra.addEdge(4, 3, 9);

    int[] distances = dijkstra.shortestPath(0);
    System.out.println("Khoảng cách từ đỉnh 0 (Dijkstra's Algorithm):");
    for(int i=0;i<distances.length;i++) {
        System.out.println("Đỉnh " + i + ": " + distances[i]);
    }

    // Ví dụ với Prim-Jarnik
    PrimJarnik prim = new PrimJarnik(5);
    prim.addEdge(0, 1, 2);
    prim.addEdge(0, 3, 6);
    prim.addEdge(1, 2, 3);
    prim.addEdge(1, 3, 8);
    prim.addEdge(1, 4, 5);
    prim.addEdge(2, 4, 7);
    prim.addEdge(3, 4, 9);

    List<PrimJarnik.Edge> mst = prim.primMST();
    System.out.println("\nCây Khung Nhỏ Nhất (Prim-Jarnik Algorithm):");
    int totalWeight = 0;
    for(PrimJarnik.Edge edge : mst){
        System.out.println("Từ đỉnh " + edge.target + " với trọng số " + edge.weight);
        totalWeight += edge.weight;
    }
    System.out.println("Tổng trọng số: " + totalWeight);
}
}
