class Solution 
{
  public int paintWalls(int[] cost, int[] time) 
  {
    final int n = cost.length;
    int[][] mem = new int[n][n + 1];
    return paintWalls(cost, time, 0, time.length, mem);
  }

  private static final int kMax = 500_000_000;

  // Returns the minimum cost to paint j walls by painters[i..n).
  
  //Input Parameters:
  private int paintWalls(int[] cost, int[] time, int i, int walls, int[][] mem) 
    //'cost': An array representing the cost of painting each wall.
    //'time': An array representing the time required to paint each wall.
    //'i': The index of the current painter.
    //'walls': The number of walls remaining to be painted.
    //'mem': A memoization table to store previously computed results.
  {
    //Recursive Depth-First Algorithm :
    //The algorithm uses recursive depth-first search with memoization to explore all possible combinations of picking and skipping walls for each painter.

    //The base cases handle the following scenarios:
        //If 'walls' is less than or equal to 0, return 0, indicating that the painting is complete.
        //If 'i' reaches the end of the array ('cost.length'), return a large constant ('kMax') as an indicator of an invalid state.
        //If the result for the current state is already stored in the memoization table ('mem'), return that result.

    //Recursive Calculation:
    //The recursive calculation is divided into two cases: 'pick' & 'skip'

    if (walls <= 0)
      return 0;
    if (i == cost.length)
      return kMax;
    if (mem[i][walls] > 0)
      return mem[i][walls];
      //Picking the Current Wall (pick):
    final int pick = cost[i] + paintWalls(cost, time, i + 1, walls - time[i] - 1, mem);//Increment the cost by cost[i].
    //Recursively call paintWalls for the next painter (i + 1) with the reduced number of walls (walls - time[i] - 1).

    //Skipping the Current Wall (skip):
    final int skip = paintWalls(cost, time, i + 1, walls, mem);
    //Recursively call paintWalls for the next painter (i + 1) with the same number of walls (walls).
    return mem[i][walls] = Math.min(pick, skip);
  }
}