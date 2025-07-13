import java.util.*;

class Dijkstra {
    static class Edge{
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }
    static class Node implements Comparable<Node>{
        int vertex;
        int distance;

        Node(int vertex,int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.distance,other.distance);
        }
    } 
    public static int[] dijkstra(List<List<Edge>>graph,int source){
        int V=graph.size();
        int []dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0));
        while(!pq.isEmpty()){
            Node current =pq.poll();
            int u= current.vertex;
            int d= current.distance;
            if(d > dist[u]) continue;
            for(Edge edge:graph.get(u)){
                int v = edge.to;
                int weight = edge.weight;
                if(dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        List<List<Edge>> graph = new ArrayList<>();
        
        graph.add(Arrays.asList(new Edge(1, 4), new Edge(2, 1))); // Node 0
        graph.add(Arrays.asList(new Edge(0, 4), new Edge(2, 2), new Edge(3, 5))); // Node 1
        graph.add(Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(3, 8))); // Node 2
        graph.add(Arrays.asList(new Edge(1, 5), new Edge(2, 8), new Edge(4, 3))); // Node 3
        graph.add(Arrays.asList(new Edge(3, 3), new Edge(5, 6))); // Node 4
        graph.add(Arrays.asList(new Edge(4, 6))); // Node 5
        graph.add(Arrays.asList(new Edge(4, 6))); // Node 6 
        int[] distances = dijkstra(graph, 0);
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To " + i + ": " + distances[i]);
        }
    }
}
