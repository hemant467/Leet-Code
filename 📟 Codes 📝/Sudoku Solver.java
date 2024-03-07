//The goal is to find a valid assignment for each empty cell while adhering to the rules of Sudoku.
class Solution 
{
    //solveSudoku Method:This is the main method that initiates the Sudoku-solving process.It calls the recursive 'DFS' method dfs to start the backtracking.
  public void solveSudoku(char[][] board) 
  {
    //The 'dfs' method is a recursive function that attempts to fill in the Sudoku grid. It takes the current state of the board and the index 's', representing the position to be filled (ranging from 0 to 80 for a 9x9 Sudoku grid).
    dfs(board, 0);
  }

  private boolean dfs(char[][] board, int s) 
  {
    if (s == 81) //If 's' reaches 81, it means the entire grid has been filled, and the method returns 'true', indicating a successful solution.
      return true;

    //The method calculates the row 'i' and column 'j' based on the index 's'.
    final int i = s / 9;
    final int j = s % 9;

    if (board[i][j] != '.')
      return dfs(board, s + 1);
    //If the current cell ('board[i][j]') is not empty (contains a digit from '1' to '9'), the method moves to the next cell ('s + 1').

    //If the current cell is empty, it attempts to fill it with digits from '1' to '9' one by one.

    //If filling the cell with a digit 'c' is valid (i.e., it doesn't violate any Sudoku rules), it sets 'board[i][j] = c' and recursively calls 'dfs(board, s + 1)'.
    for (char c = '1'; c <= '9'; ++c)
      if (isValid(board, i, j, c)) 
      {
        board[i][j] = c;
        if (dfs(board, s + 1))
          return true;  //If the recursive call returns 'true', indicating a successful solution, the method returns true.
        board[i][j] = '.';
      }

    return false;   //If the recursive call returns 'false', it means the current assignment didn't lead to a solution, and the method backtracks by setting the current cell back to '.' and trying the next digit.

    //If no valid digit is found for the current cell, the method returns 'false'.
  }

    //isValid Method: The 'isValid' method checks if placing a digit 'c' in a specific cell ('row', 'col') violates the Sudoku rules.
    
    //It checks three conditions:
    //No repetition of digit 'c' in the same row.
    //No repetition of digit 'c' in the same column.
    //No repetition of digit 'c' within the 3x3 subgrid.
    //If any of these conditions is violated, the method returns 'false'; otherwise, it returns 'true'.

  private boolean isValid(char[][] board, int row, int col, char c) 
  {
    for (int i = 0; i < 9; ++i)
      if (board[i][col] == c || board[row][i] == c ||
          board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    return true;
  }
  //The backtracking process explores different combinations of digits for each empty cell until a valid solution is found or all possibilities are exhausted. If a solution is found, the original Sudoku grid is modified in place.

  //Time Complexity:
        //The time complexity is exponential, as it involves trying different possibilities for each empty cell. In the worst case, it explores all possible combinations.
        //However, the actual time complexity is influenced by the characteristics of the input Sudoku puzzle and the efficiency of the 'isValid' method.
        //In practice, many Sudoku puzzles can be solved efficiently with this approach.

    //Space Complexity:
        //The space complexity is constant O(1) since the modifications are made in place, and the recursion depth is limited to the number of empty cells.

    //The backtracking algorithm efficiently explores the solution space, attempting different digit assignments until a valid solution is found.
}