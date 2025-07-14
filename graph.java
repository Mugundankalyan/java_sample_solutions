import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class graph {
    private HashMap<Integer,List<Integer>> adjList;
    public graph() {
        adjList = new HashMap<>();
    }
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    public void printgraph() {
        for (int key : adjList.keySet()) {
            System.out.print(key + " -> ");
            for (int neighbor : adjList.get(key)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    public void dfs(int node, boolean[] visited, HashMap<Integer, List<Integer>> adjList) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList);
            }
        }
    }
    public int connectedComponentsCount(HashMap<Integer, List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size() + 1];
        int count = 0;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, adjList);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        graph g = new graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        System.out.println("Connected Components Count: " + g.connectedComponentsCount(g.adjList));
        boolean[] visited = new boolean[g.adjList.size() + 1];
        System.out.print("DFS Traversal: ");
        g.dfs(1, visited, g.adjList);
        System.out.println();
        System.out.println("Graph representation:");
        g.printgraph();
        System.out.println("Total nodes: " + g.adjList.size());
    }
}
    
