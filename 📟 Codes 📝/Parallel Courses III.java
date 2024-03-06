class Solution 
{
  public int minimumTime(int n, int[][] relations, int[] time) 
  {
    //Graph Initialization: It initializes an array 'graph' to represent the directed acyclic graph (DAG) where nodes represent tasks, and edges represent dependencies.
    List<Integer>[] graph = new List[n];
    int[] inDegrees = new int[n]; //It initializes arrays inDegrees to store the in-degrees of each node.
    int[] dist = time.clone(); //It initializes arrays dist to store the time required to reach each node.

    for (int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();

    // Build the graph.
    for (int[] r : relations) //It iterates through the given 'relations' array to build the graph.
    {
      final int u = r[0] - 1;
      final int v = r[1] - 1;
      //For each relation '[u, v]', it adds an edge from node 'u - 1' to node 'v - 1' in the graph
      graph[u].add(v);
      ++inDegrees[v]; // increments the in-degree of node 'v - 1'.
    }

    //Topological Sorting and Update Distances:
    // Perform topological sorting.
    Queue<Integer> q = IntStream.range(0, n)
                           .filter(i -> inDegrees[i] == 0)
                           .boxed()
                           .collect(Collectors.toCollection(ArrayDeque::new));
    //It initializes a queue 'q' with nodes having in-degree 0 (nodes without dependencies) to start the topological sorting process.
    //It performs a modified topological sorting using the queue. For each node 'u':
        //It updates the distance of its adjacent nodes 'v' by taking the maximum of the current distance of 'v' and the sum of the distance of 'u' and the time required for 'v'.
        //If the in-degree of 'v' becomes 0 after this update, it adds 'v' to the queue.

    while (!q.isEmpty()) 
    {
      final int u = q.poll();
      for (final int v : graph[u]) 
      //Find Maximum Distance:
      {
        dist[v] = Math.max(dist[v], dist[u] + time[v]); //it returns the maximum value in the 'dist' array, which represents the minimum time needed to complete all tasks.
        if (--inDegrees[v] == 0)
          q.offer(v);
      }
    }

    return Arrays.stream(dist).max().getAsInt();
  }

  //Time Complexity:
    //Building the graph takes O(n + m), where n is the number of nodes and m is the number of relations.
    //Performing topological sorting takes O(n + m) as it processes each node and edge once.
    //The final maximum operation takes O(n).
    //The overall time complexity is O(n + m).

  //Space Complexity:
    //The graph, in-degrees, and distance arrays all use O(n) space.
    //The queue can have at most n elements.
    //The overall space complexity is O(n).
}