//The wildcard pattern matching algorithm using dynamic programming. It determines whether a given string 's' matches a wildcard pattern 'p' where '*' can match any sequence of characters and '?' can match any single character.

class Solution 
{
    //Method Signature:
  public boolean isMatch(String s, String p) 
  {
    //Initialization:
    final int m = s.length(); //Get the length of the input string 's'.
    final int n = p.length(); //Get the length of the wildcard pattern 'p'.
    // dp[i][j] := true if s[0..i) matches p[0..j)
    boolean[][] dp = new boolean[m + 1][n + 1]; //Initialize a 2D boolean array 'dp' to store whether 's[0..i)' matches 'p[0..j)'.

    //Base Case Initialization:
    dp[0][0] = true; //Set 'dp[0][0]' to 'true' since an empty string matches an empty pattern.

    for (int j = 0; j < p.length(); ++j)
      if (p.charAt(j) == '*')
        dp[0][j + 1] = dp[0][j]; //For each '*' in the pattern, set the corresponding 'dp[0][j + 1]' to the same value as 'dp[0][j]'.

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        if (p.charAt(j) == '*') 
        {
        //Dynamic Programming Loop:
            //Iterate over each character in 's' and each character in 'p' to fill the 'dp' array.
            //If the current character in 'p' is '*', calculate whether it matches an empty sequence or some characters:
          final boolean matchEmpty = dp[i + 1][j];
          final boolean matchSome = dp[i][j + 1];
          dp[i + 1][j + 1] = matchEmpty || matchSome;
        } 
        //If the current characters in 's' and 'p' match (or 'p' has a '?'), set 'dp[i + 1][j + 1]' based on the previous match status:
        else if (isMatch(s, i, p, j)) 
        {
          dp[i + 1][j + 1] = dp[i][j];
        }

    return dp[m][n];
  }

    //Helper Function:
  private boolean isMatch(final String s, int i, final String p, int j) //Helper function to check if characters at positions 'i' and 'j' in strings 's' and 'p' match. 
  {
    //Return Result:
    return j >= 0 && p.charAt(j) == '?' || s.charAt(i) == p.charAt(j);
    //Return the final result stored in 'dp[m][n]'.
  }
  
//Time Complexity:
    //The algorithm uses a dynamic programming approach with two nested loops.
    //The time complexity is O(m * n), where m and n are the lengths of the input strings.

//Space Complexity:
    //The space complexity is O(m * n) due to the 2D array 'dp'.

    //The code uses recursion in the 'isMatch' function, which can be optimized using memoization for better performance.
}