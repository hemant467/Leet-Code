class Solution 
{
    //Initialize Variables and Constants:
    //kMod: A constant represent0ing the modulo value for the result.
    //dp: A 3D array where 'dp[i][j][k]' represents the number of ways to build an array of length 'i' with maximum element 'j' and search cost 'k'.
    //n: The length of the array to be built.
    //m: The maximum value that an element in the array can take.
    //k: The search cost.

    //Initialization:
    //The base case is initialized where for 'i = 1' and each 'j' from 1 to 'm', 'dp[1][j][1]' is set to 1, representing an array of length 1 with a single distinct element.
  public int numOfArrays(int n, int m, int k) 
  {
    final int kMod = 1_000_000_007;
    // dp[i][j][k] := the number of ways to build an array of length i, where j
    // is the maximum number and k is `search_cost`
    int[][][] dp = new int[n + 1][m + 1][k + 1];

    for (int j = 1; j <= m; ++j)
      dp[1][j][1] = 1;

    for (int i = 2; i <= n; ++i)                // for each length
      for (int j = 1; j <= m; ++j)              // for each max value
        for (int cost = 1; cost <= k; ++cost) { // for each cost
          // 1. Appending any of [1, j] in the i-th position doesn't change the
          //    maximum and cost.
          dp[i][j][cost] = (int) ((long) j * dp[i - 1][j][cost] % kMod);
          // 2. Appending j in the i-th position makes j the new max and cost 1.
          for (int prevMax = 1; prevMax < j; ++prevMax) 
          {
            dp[i][j][cost] += dp[i - 1][prevMax][cost - 1];
            dp[i][j][cost] %= kMod;
          }
        }

    //Result Calculation:
    int ans = 0;
    for (int j = 1; j <= m; ++j)
    //The final result ('ans') is calculated by summing up the number of ways for each possible maximum element 'j' with the desired search cost 'k'.

    //Modulo Operation:
    {
      ans += dp[n][j][k];
      ans %= kMod;
      //Modulo operations are applied to avoid integer overflow, and the final result is returned.
    }
    return ans;
  }
}