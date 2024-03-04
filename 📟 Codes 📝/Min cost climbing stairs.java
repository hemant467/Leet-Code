class Solution 
{
  public int minCostClimbingStairs(int[] cost) 
  {
    //Input:
    //cost: An array representing the cost of each step. 'cost[i]' is the cost of the 'i-th' step.
    final int n = cost.length;

    //Algorithm Explanation:
    for (int i = 2; i < n; ++i)
    //The loop starts from 'i = 2' since the minimum cost for the first two steps is the same as their individual costs.
      
      cost[i] += Math.min(cost[i - 1], cost[i - 2]);
      //For each step i, update the cost to reach that step ('cost[i]') by adding the minimum cost of reaching the previous two steps ('cost[i - 1]' and 'cost[i - 2]').
      //This is because you can either climb one step from the previous one or two steps from the one before that, and you want to choose the path with the minimum cost.
        //At the end of the loop, the 'cost' array will be modified, and the minimum cost to reach the top will be the minimum between the last two elements ('cost[n - 1]' and 'cost[n - 2]').
      

    return Math.min(cost[n - 1], cost[n - 2]);
    //Finally, it returns the minimum cost to reach the top, which is the minimum between the last two elements in the modified 'cost' array.
  }
    //Time Complexity: The time complexity of this algorithm is O(n), where n is the length of the 'cost' array. This is because each element in the array is processed once in a linear loop.

    //Space Complexity: The space complexity is O(1) since the algorithm uses a constant amount of extra space regardless of the input size. The dynamic programming approach modifies the input array in-place.
}