class Solution 
{
    //Method:
    //The 'isValidSudoku' method takes a 9x9 Sudoku board represented as a 2D array of characters.
    //It uses a set ('seen') to keep track of unique values seen in rows, columns, and 3x3 subgrids.
  public boolean isValidSudoku(char[][] board) 
  {
    //Validation Logic:
    //The method iterates through each cell of the Sudoku board using two nested loops.
    //For each cell, it checks whether the value is '.' (empty cell) or a valid digit (1 to 9).
    //If it's an empty cell, it continues to the next iteration.

    Set<String> seen = new HashSet<>();

    for (int i = 0; i < 9; ++i)
      for (int j = 0; j < 9; ++j)
      {
        if (board[i][j] == '.')
          continue;
        final char c = board[i][j];
        //For each digit found, it checks three conditions:
        if (!seen.add(c + "@row" + i) || //
            !seen.add(c + "@col" + j) || //
            !seen.add(c + "@box" + i / 3 + j / 3))
        //Row Condition: It adds the digit with a unique identifier for the row ('c + "@row" + i') to the set.
        //Column Condition: It adds the digit with a unique identifier for the column ('c + "@col" + j') to the set.
        //Box Condition: It adds the digit with a unique identifier for the 3x3 subgrid (c + "@box" + i / 3 + j / 3) to the set.
          
          return false;
          //If any of the three conditions are violated, i.e., if the digit is already present in the set for the corresponding row, column, or box, the method returns 'false' as the board is invalid.
      }

    return true;
  }
    //Return Value: If the board passes all the validations, the method returns 'true', indicating that the Sudoku board is valid.

    //Time Complexity: The time complexity of the algorithm is O(1) since it always iterates over a constant-size 9x9 Sudoku board.

    //Space Complexity: The space complexity is also O(1) since the set ('seen') has a constant size regardless of the input size.
}