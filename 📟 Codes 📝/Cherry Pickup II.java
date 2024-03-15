//The below code implements a dynamic programming approach to solve the Cherry Pickup problem. 

//The problem is described as follows: 
    //Given a grid representing a cherry orchard, where each cell in the grid contains a certain number of cherries, two robots start at the top-left corner of the grid and move towards the bottom-right corner. They can only move down or right at each step, and they can pick up cherries in the grid. The objective is to determine the maximum number of cherries the two robots can pick up while moving through the grid without colliding with each other.

class Solution 
{
  public int cherryPickup(int[][] grid) 
  {
    final int m = grid.length;
    final int n = grid[0].length;
    int[][][] mem = new int[m][n][n];
    //It initializes a 3D memoization array `mem` to store the maximum number of cherries that can be collected for each position `(x, y1, y2)` in the grid. Here, `x` represents the current row, `y1` represents the column of robot 1, and `y2` represents the column of robot 2.


    for (int[][] A : mem)
      Arrays.stream(A).forEach(B -> Arrays.fill(B, -1));

    return cherryPick(grid, 0, 0, n - 1, mem);
  }

  // Returns the maximum cherries we can collect, where robot #1 is on (x, y1)
  // and robot #2 is on (x, y2).
  private int cherryPick(int[][] grid, int x, int y1, int y2, int[][][] mem)
  //It recursively explores all possible paths starting from `(x, y1, y2)` down to the bottom of the grid, updating the memoization array as it goes. At each step, it calculates the maximum number of cherries that can be collected in the current position based on the cherries in the current cell and the movement of the robots.
  
   {
    if (x == grid.length)
      return 0; //It returns the maximum number of cherries that can be collected starting from the top-left corner of the grid.

    if (y1 < 0 || y1 == grid[0].length || y2 < 0 || y2 == grid[0].length) //If a position `(x, y1, y2)` is out of the grid boundaries, or if it has been visited before.
      return 0; //The function returns 0.
    
    //The memoization array ensures that overlapping subproblems are not recomputed, improving the efficiency of the algorithm.
    if (mem[x][y1][y2] != -1)
      return mem[x][y1][y2];

    final int currRow = grid[x][y1] + (y1 == y2 ? 0 : grid[x][y2]);

    for (int d1 = -1; d1 <= 1; ++d1)
      for (int d2 = -1; d2 <= 1; ++d2)
        mem[x][y1][y2] =
            Math.max(mem[x][y1][y2], currRow + cherryPick(grid, x + 1, y1 + d1, y2 + d2, mem)); //The function `cherryPick` recursively explores all possible movements of the two robots, considering all possible combinations of movements `(d1, d2)` for robot 1 and robot 2, where `d1` and `d2` can be -1, 0, or 1 representing movement left, no movement, and movement right, respectively.

    return mem[x][y1][y2];
  }
    //Time Complexity : O(mn^2)
    //Space Complexity : O(mn^2)

    //Overall, the above code efficiently computes the maximum number of cherries that can be collected by the two robots using dynamic programming and memoization.
}