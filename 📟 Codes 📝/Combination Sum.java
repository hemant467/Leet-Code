class Solution 
{
    //Method Signature:
  public List<List<Integer>> combinationSum(int[] candidates, int target) 
  {
    //Initialization:
    List<List<Integer>> ans = new ArrayList<>(); //Initialize an 'ArrayList' to store the final result, which will contain lists of combinations.
    Arrays.sort(candidates); //Sort the candidates array in ascending order to facilitate the DFS process.

    //DFS Function:
    dfs(0, candidates, target, new ArrayList<>(), ans); //The DFS function takes the starting index ('s'), candidates array, remaining target value ('target'), current path (combination), and the final result list ('ans').
    return ans;
  }

    //DFS Implementation:
  private void dfs(int s, int[] candidates, int target, List<Integer> path,
                   List<List<Integer>> ans) 
                   {
    //Base cases:
    if (target < 0) //If the remaining target becomes negative, it means the current combination is not valid, so return.
      return;
    if (target == 0) 
    {
      ans.add(new ArrayList<>(path));
      return;
      //If the remaining target becomes 0, add the current combination to the result list and return.
    }

    //Iterate through candidates:
    for (int i = s; i < candidates.length; ++i) //Iterate through candidates starting from index 's'.
    {
      path.add(candidates[i]); //Add the current candidate to the path: 'path.add(candidates[i]);'.
      dfs(i, candidates, target - candidates[i], path, ans); //Recursively call DFS with the updated parameters: 'dfs(i, candidates, target - candidates[i], path, ans);'.
      path.remove(path.size() - 1); //Backtrack by removing the last element from the 'path: path.remove(path.size() - 1);'.
    }
    //Invoke DFS: 
    //'dfs(0, candidates, target, new ArrayList<>(), ans);': Start the DFS from the first candidate (index 0) with an empty path and the original target value.

    //Return Result:
    //'return ans;:' Return the list containing all valid combinations.
  }
}