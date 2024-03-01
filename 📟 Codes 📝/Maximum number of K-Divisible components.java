class Solution 
{
    //Initialization:
  public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) 
  {
    List<Integer>[] graph = new List[n];

    for (int i = 0; i < n; i++)
      graph[i] = new ArrayList<>();

    for (int[] edge : edges) 
    {
      final int u = edge[0];
      final int v = edge[1];
      graph[u].add(v);
      graph[v].add(u);
    }

    dfs(graph, 0, /*prev=*/-1, values, k);
    return ans;
  }
    //Initializes the graph as an array of lists ('graph') to represent the tree.
    //Calls the DFS function ('dfs') to traverse the tree and calculate the number of valid components.
    //Returns the final result stored in the variable 'ans'.

  private int ans = 0;

    //Depth-First Search (DFS) Function:
  private long dfs(List<Integer>[] graph, int u, int prev, int[] values, int k) 
  {
    long treeSum = values[u];

    for (int v : graph[u])
      if (v != prev)
        treeSum += dfs(graph, v, u, values, k);

    if (treeSum % k == 0)
      ++ans;
    return treeSum;
  }
  //The DFS function takes the graph, current node 'u', previous node 'prev', array of values 'values', and the integer 'k' as parameters.
  //Calculates the sum of values for the current subtree rooted at node 'u' and stores it in the variable 'treeSum'.
  //Iterates through the neighbors of node 'u' in the graph, excluding the previous node.
  //Recursively calls the DFS function for each neighbor and adds their subtree sum to 'treeSum'.
  //Checks if the sum of values in the current subtree ('treeSum') is divisible by 'k'. If true, increments the 'ans' counter.
  //Returns the calculated 'treeSum'.
}