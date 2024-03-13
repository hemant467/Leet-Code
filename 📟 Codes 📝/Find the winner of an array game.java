class Solution 
{
    //Java function 'getWinner' aims to find the winner of a game played with an array 'arr', given a condition 'k'.
  public int getWinner(int[] arr, int k) 
  {
    //Initialization:
    int ans = arr[0]; //Initializes the 'ans' variable with the first element of the array 'arr'. This sets the initial winner to the first element of the array.
    int wins = 0; //Initializes the 'wins' variable to 0. This variable tracks the consecutive wins of the current winner.

    //Looping through the array:
    for (int i = 1; i < arr.length && wins < k; ++i) //The 'for' loop iterates over the elements of the array starting from index 1 ('i = 1') to the end of the array ('i < arr.length').
    //wins < k: The loop continues as long as the number of consecutive wins ('wins') for the current winner is less than the threshold 'k'.


    //Updating the winner:
      if (arr[i] > ans) 
      {
        ans = arr[i];
        wins = 1;
        //If the current element ('arr[i]') is greater than the current winner ('ans'), it becomes the new winner, and 'wins' is reset to 1.
      } 
      else 
      {
        ++wins;
        //Otherwise, if the current element is not greater than the current winner, it means that the current winner has won another round, so 'wins' is incremented by 1.
      }

    return ans;
    //Returning the winner: After the loop completes, the function returns the final winner stored in the 'ans' variable.
  }
  //this function iterates through the array, keeping track of consecutive wins for the current winner until the number of consecutive wins reaches the threshold 'k'. The function then returns the winner. If no winner has been found after iterating through the array, the initial winner (the first element of the array) is returned.
}