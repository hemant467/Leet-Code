class Solution 
{
    //Input Parameter:
  public List<Integer> getRow(int rowIndex) 
  //'rowIndex': The index of the row in Pascal's Triangle to be generated.
  {
    //Array Initialization:
    Integer[] ans = new Integer[rowIndex + 1];
    Arrays.fill(ans, 1);
    //Initialize an 'Integer' array 'ans' of size 'rowIndex + 1' to store the elements of the k-th row.
    //Fill the array with the value 1, as the first and last elements of each row in Pascal's Triangle are always 1.

    //Dynamic Programming Loop: Iterate through the rows of Pascal's Triangle, starting from the 2nd row (index 1) up to the k-th row (index 'rowIndex').

    for (int i = 2; i < rowIndex + 1; ++i) //For each row 'i', iterate from the 2nd element to the second-to-last element ('j' from 1 to 'i - 1').

      for (int j = 1; j < i; ++j)
        ans[i - j] += ans[i - j - 1]; //Update the value at 'ans[i - j]' by adding the values at 'ans[i - j]' and 'ans[i - j - 1]'. This follows the rule of Pascal's Triangle, where each element is the sum of the two elements directly above it.

    //Return:
    return Arrays.asList(ans); //Return the generated row as a 'List<Integer>' 'using Arrays.asList(ans)'.
  }

  //Time Complexity:
    //The time complexity is O(rowIndex^2), as there are nested loops iterating through each row and each element in the row.

  //Space Complexity:
    //The space complexity is O(rowIndex) due to the 'ans' array, which stores the elements of the row.
}