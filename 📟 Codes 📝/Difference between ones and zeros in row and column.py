#The below code aims to create a new grid where each cell contains the difference between the count of 1s in its row and the count of 0s in its column in the original grid.
class Solution:
  def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
    #Initialization:
    m = len(grid) #`m` to store the number of rows in the grid,
    n = len(grid[0]) #`n` to store the number of columns in the grid,
    
    ans = [[0] * n for _ in range(m)] #It initializes an empty 2D list `ans` to store the resulting grid, where each cell initially contains 0.

    onesRow = [row.count(1) for row in grid] #It calculates the count of 1s in each row of the original grid and stores them in the list `onesRow` using list comprehension.

    onesCol = [col.count(1) for col in zip(*grid)] #It calculates the count of 1s in each column of the original grid and stores them in the list `onesCol` using the `zip` function along with list comprehension.

#It then iterates over each cell in the original grid using nested loops:

    for i in range(m):
      for j in range(n):
        #For each cell at position `(i, j)`:
        #It calculates the value for the corresponding cell in the new grid `ans[i][j]`

        ans[i][j] = onesRow[i] + onesCol[j] - \
            (n - onesRow[i]) - (m - onesCol[j])

       #ans[i][j] = onesRow[i] + onesCol[j] - (n - onesRow[i]) - (m - onesCol[j])
    
    #This expression computes the difference between the count of 1s in the row `i` and the count of 0s in the column `j`. It subtracts the count of 1s in the column `j` from the total number of cells in the column `j` (which is `m - onesCol[j]`) and subtracts the count of 0s in the row `i` from the total number of cells in the row `i` (which is `n - onesRow[i]`).

    #Return result:
    return ans #Finally, it returns the resulting `ans` grid.
    
    #Time Complexity : O(mn)
    #Space Complexity : O(mn)

#The above code efficiently computes the difference between the count of 1s in each row and the count of 0s in each column in the original grid and stores the results in a new grid.