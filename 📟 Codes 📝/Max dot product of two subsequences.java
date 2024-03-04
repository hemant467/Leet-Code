class Solution 
{
  public int maxDotProduct(int[] nums1, int[] nums2) 
  {
    //Variables and Constants:
    final int m = nums1.length;
    final int n = nums2.length;
    //m and n: The lengths of the two arrays nums1 and nums2, respectively.
    //dp: A 2D array where 'dp[i][j]' represents the maximum dot product of subsequences 'nums1[0..i)' and 'nums2[0..j)'. The array is initialized with 'Integer.MIN_VALUE' values.

    //Dynamic Programming Initialization:
    //The base case is initialized, where 'dp[i][0]' and 'dp[0][j]' are set to 0 for all 'i' and 'j'. This represents the case where one of the subsequences is an empty subsequence.
    // dp[i][j] := the maximum dot product of the two subsequences nums[0..i)
    // and nums2[0..j)

    int[][] dp = new int[m + 1][n + 1];
    Arrays.stream(dp).forEach(A -> Arrays.fill(A, Integer.MIN_VALUE));

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
    
    //Dynamic Programming Update:
    //The nested loops iterate over each element of both arrays ('nums1' and 'nums2').
    //For each pair of elements 'nums1[i]' and 'nums2[j]', the code calculates the maximum dot product using the following recurrence relation:

        dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]),Math.max(0, dp[i][j]) + nums1[i] * nums2[j]);
        //'dp[i][j + 1]': Represents the maximum dot product without including 'nums2[j]'.
        //'dp[i + 1][j]': Represents the maximum dot product without including 'nums1[i]'.
        //'dp[i][j] + nums1[i] * nums2[j]': Represents the maximum dot product by including both 'nums1[i]' and 'nums2[j]'.

    //Result:
    return dp[m][n];
    //The final result is stored in 'dp[m][n]', representing the maximum dot product of the two subsequences.
  }
}