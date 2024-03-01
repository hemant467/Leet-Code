class Solution 
{
  public long countPaths(int n, int[][] edges) 
  {
      //Initialization:
    final boolean[] isPrime = sieveEratosthenes(n + 1);
    List<Integer>[] graph = new List[n + 1];

    for (int i = 1; i <= n; ++i)
      graph[i] = new ArrayList<>();
      //'isPrime' is a boolean array indicating whether each number up to 'n' is prime.
      //'graph' is an adjacency list to represent the input graph.

    //Build Graph:
    for (int[] edge : edges) 
    {
      final int u = edge[0];
      final int v = edge[1];
      graph[u].add(v);
      graph[v].add(u);
    }
    //Populates the adjacency list based on the given edges.

    //Depth-First Search (DFS):
    dfs(graph, 1, /*prev=*/-1, isPrime);
    //Initiates DFS starting from node 1 (root), with the initial previous node set to -1.
    return ans;
  }

  private long ans = 0;

    //DFS Function:
  private Pair<Long, Long> dfs(List<Integer>[] graph, int u, int prev, boolean[] isPrime) 
    //The DFS function takes the current node 'u', the previous node 'prev', and the 'isPrime' array as parameters.
    //It returns a pair of values: ''(countZeroPrimePath, countOnePrimePath)'' representing the number of paths with zero prime vertices and one prime vertex, respectively.
  {
    //DFS Body:
    long countZeroPrimePath = isPrime[u] ? 0 : 1;
    long countOnePrimePath = isPrime[u] ? 1 : 0;

    for (final int v : graph[u]) 
    {
      if (v == prev)
        continue;
      Pair<Long, Long> pair = dfs(graph, v, u, isPrime);
      final long countZeroPrimeChildPath = pair.getKey();
      final long countOnePrimeChildPath = pair.getValue();
      //Initializes the count of paths for the current node 'u'.
      //Iterates through adjacent vertices 'v' of 'u' in the graph.
      //Recursively calls DFS for each neighbor 'v'.

    //Counting Paths:
      ans +=countZeroPrimePath * countOnePrimeChildPath + countOnePrimePath * countZeroPrimeChildPath;
      if (isPrime[u]) 
      {
        countOnePrimePath += countZeroPrimeChildPath;
      } else 
      {
        countZeroPrimePath += countZeroPrimeChildPath;
        countOnePrimePath += countOnePrimeChildPath;
      }
      //Counts the number of paths by updating the 'ans' variable.
      //Considers whether the current node 'u' is prime.
      //Updates the counts based on the parity of prime and non-prime vertices.
    }
    //Return Pair:
    return new Pair<>(countZeroPrimePath, countOnePrimePath);
    //Returns the pair of counts for the current node.
  }
  
  //Sieve of Eratosthenes:
  private boolean[] sieveEratosthenes(int n) 
  //Implements the Sieve of Eratosthenes algorithm to calculate prime numbers up to 'n'.
  {
    //Sieve Body:
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 2; i * i < n; ++i)
      if (isPrime[i])
        for (int j = i * i; j < n; j += i)
          isPrime[j] = false;
    return isPrime;
    //Initializes an array 'isPrime' indicating whether each number up to 'n' is prime.
    //Marks 0 and 1 as non-prime.
    //Iterates through numbers up to the square root of 'n' to mark multiples of prime numbers as non-prime.
  }
}