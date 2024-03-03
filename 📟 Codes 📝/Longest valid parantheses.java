class Solution 
{
  public int longestValidParentheses(String s) 
  {
    //String Transformation:
    final String s2 = ")" + s;
    //A new string 's2' is created by adding a dummy ')' character at the beginning of the original string 's'. This is done to simplify boundary cases.

    // dp[i] := the length of the longest valid parentheses in the substring
    // s2[1..i]

    //Dynamic Programming (DP) Array:
    int dp[] = new int[s2.length()];
    //An array 'dp' is initialized to store the lengths of the longest valid parentheses substrings for each index in 's2'.

    //DP Transition:
    for (int i = 1; i < s2.length(); ++i) // iterates through each character in 's2'.
      if (s2.charAt(i) == ')' && s2.charAt(i - dp[i - 1] - 1) == '(') //Checks if the current character is ')' and if there is a matching '(' at a position that would form a valid parentheses substring. If conditions are met, update dp[i] accordingly.
        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2; //The length of the valid parentheses substring at index 'i' is calculated based on the length of the previous valid parentheses substring (if any).

    //Result
    return Arrays.stream(dp).max().getAsInt(); //The final result is obtained by finding the maximum value in the 'dp' array, representing the length of the longest valid parentheses substring.

    //Time Complexity: The time complexity is O(N), where N is the length of the input string 's'.

    //Space Complexity: The space complexity is O(N), where N is the length of the input string 's', due to the 'dp' array.
  }
}