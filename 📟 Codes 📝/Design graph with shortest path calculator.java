//The Java class `Graph` represents a weighted graph and provides functionality to initialize the graph with given edges and find the shortest path between two nodes using Dijkstra's algorithm.
class Graph 
{
    //Constructor: The constructor initializes the graph with `n` nodes and adds edges based on the given `edges` array.
  public Graph(int n, int[][] edges) 
  {
    graph = new List[n]; //It initializes an array of lists (`graph`) to represent the adjacency list of the graph. Each element of the array represents a node, and the list contains pairs representing adjacent nodes and their weights.
    for (int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();
    for (int[] edge : edges) //It then iterates through the `edges` array and adds each edge using the `addEdge` method.
      addEdge(edge);
  }

    //`addEdge` method :
  public void addEdge(int[] edge) 
  {
    final int u = edge[0];
    final int v = edge[1];
    final int w = edge[2];
    //This method adds an edge to the graph. It takes an array `edge` representing an edge in the format `[u, v, w]`, where `u` and `v` are nodes and `w` is the weight of the edge.
    graph[u].add(new Pair<>(v, w));
    //It extracts `u`, `v`, and `w` from the `edge` array and adds `v` with weight `w` to the adjacency list of node `u`.
  }

    //`shortestPath` method :
  public int shortestPath(int node1, int node2) //This method finds the shortest path between two nodes `node1` and `node2` using Dijkstra's algorithm.
  {
    int[] dist = new int[graph.length]; //It initializes an array `dist` to store the shortest distances from `node1` to all other nodes.
    Arrays.fill(dist, Integer.MAX_VALUE); //All distances are initially set to `Integer.MAX_VALUE`.

    // (d, u)
    Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey)); //It initializes a min-heap (`PriorityQueue`) to store pairs of distances and nodes. The priority is based on the distance.

    dist[node1] = 0; //It sets the distance of `node1` to itself as `0` and adds it to the min-heap.
    minHeap.offer(new Pair<>(dist[node1], node1));

    while (!minHeap.isEmpty()) {
      final int d = minHeap.peek().getKey();
      final int u = minHeap.poll().getValue();
      if (u == node2) //It repeatedly extracts the node with the minimum distance (`u`) from the min-heap. If `u` is equal to `node2`, it returns the shortest distance to `node2`.
        return d;
      for (Pair<Integer, Integer> pair : graph[u]) 
      {
        final int v = pair.getKey();
        final int w = pair.getValue();
        if (d + w < dist[v]) {
          dist[v] = d + w;
          minHeap.offer(new Pair<>(dist[v], v)); //It iterates through all adjacent nodes of `u` and relaxes the distances if a shorter path is found. The updated distances are added to the min-heap.
        }
      }
    }

    return -1; //If the min-heap becomes empty before reaching `node2`, it means there is no path from `node1` to `node2`, so it returns `-1`.
  }

    //`graph` array :
  private List<Pair<Integer, Integer>>[] graph; //This array of lists represents the adjacency list of the graph. Each element of the array corresponds to a node, and the list contains pairs representing adjacent nodes and their weights.

    //The code efficiently constructs a weighted graph and finds the shortest path between two nodes using Dijkstra's algorithm. It has a time complexity of O(E log V), where E is the number of edges and V is the number of vertices in the graph.
}