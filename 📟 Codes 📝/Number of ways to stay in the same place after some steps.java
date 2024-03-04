class Solution 
{
  //Input Parameters:
  public int numWays(int steps, int arrLen) 
  //'steps': The total number of steps that can be taken.
  //'arrLen': The length of the array representing the indices.
  {
    //Constants:
    final int kMod = 1_000_000_007;
    //'kMod': A constant representing the modulo value used to prevent integer overflow.
    final int n = Math.min(arrLen, steps / 2 + 1);
    //'n': The effective length of the array, which is the minimum of 'arrLen' and 'steps / 2 + 1'.

    //Dynamic Programming Array:
    //dp: An array representing the number of ways to stay at each index after a certain number of steps.
    // dp[i] := the number of ways to stay at index i
    long[] dp = new long[n];

    //Initialization:
    dp[0] = 1;//Set 'dp[0]' to 1, as there is only one way to stay at the initial position.

    //Dynamic Programming Loop:
    while (steps-- > 0) //Iterate through the steps, updating the 'dp' array.
    {
      long[] newDp = new long[n];
      for (int i = 0; i < n; ++i) //For each index 'i' in the array:
      {
        newDp[i] = dp[i];
        if (i - 1 >= 0)
          newDp[i] += dp[i - 1];//Calculate the number of ways to stay at 'i' by summing the ways to stay at the same index in the previous step ('dp[i]').
        if (i + 1 < n)
          newDp[i] += dp[i + 1];//The ways to move left ('dp[i - 1]'), and the ways to move right ('dp[i + 1]').
        newDp[i] %= kMod;//Update the 'newDp' array with the calculated values, taking the modulo ('kMod') to prevent integer overflow.
      }
      dp = newDp;//Update the 'dp' array with the values in 'newDp'.
    }

    return (int) dp[0];//Return the number of ways to stay at the initial index ('dp[0]').
  }

  //Note:
    //The effective length 'n' is used to limit the array size based on the constraints of the problem. It ensures that the array doesn't exceed half of the total steps ('steps / 2 + 1').
    //The use of a 2D array ('dp' and 'newDp') helps in updating the values for each step while avoiding conflicts between the new and old values.

//Time Complexity: The time complexity is O(steps * n) since it iterates through the steps and updates each index.

//Space Complexity: The space complexity is O(n) due to the dynamic programming array ('dp' and 'newDp'), which has a length of 'n'.
}