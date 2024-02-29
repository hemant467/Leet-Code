class Solution {
    //Method Signature:
  public List<String> generateParenthesis(int n) 
  //The method 'generateParenthesis' takes an integer 'n' as input and returns a list of strings containing all valid combinations of well-formed parentheses.
  {
      //List Initialization:
    List<String> ans = new ArrayList<>();
    //A list 'ans' is initialized to store the generated combinations.
    
    //DFS [Depth-First Search] Initialization:
    dfs(n, n, new StringBuilder(), ans);
    //The DFS function is called with the initial values: 'l = n' (remaining left parentheses), 'r = n' (remaining right parentheses), an empty 'StringBuilder' (sb), and the list ans.
    return ans;
  }

    //DFS Function:
  private void dfs(int l, int r, final StringBuilder sb, List<String> ans) 
    //The DFS function takes parameters representing the remaining left and right parentheses, the current combination (sb), and the list to store the results.

  {
      //Base Case:
    if (l == 0 && r == 0) {
      ans.add(sb.toString());
      return;
    }
    //If there are no remaining left and right parentheses, the current combination is valid, and it is added to the result list 'ans'. The function then returns.

    //Recursive Calls for Left Parentheses:
    if (l > 0) {
      sb.append("(");
      dfs(l - 1, r, sb, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
    //If there are remaining left parentheses ('l > 0'), the function appends an open parenthesis to the current combination, makes a recursive call with 'l - 1' remaining left parentheses, and then removes the last character from 'sb' (backtracking).

    //Recursive Calls for Right Parentheses:
    if (l < r) {
      sb.append(")");
      dfs(l, r - 1, sb, ans);
      sb.deleteCharAt(sb.length() - 1);
      //If there are more left parentheses than right parentheses ('l < r'), the function appends a closing parenthesis to the current combination, makes a recursive call with 'r - 1' remaining right parentheses, and then removes the last character from 'sb' (backtracking).
    }
  }
}