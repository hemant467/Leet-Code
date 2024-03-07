class Solution 
{
    //Method Signature:
  public List<List<Integer>> combinationSum2(int[] candidates, int target) 
  {
    //Initialization:
    List<List<Integer>> ans = new ArrayList<>(); //Initialize an 'ArrayList' to store the final result, which will contain lists of combinations.
    Arrays.sort(candidates); //Sort the candidates array in ascending order to facilitate the DFS process.

    //DFS Function:
    dfs(0, candidates, target, new ArrayList<>(), ans); //The DFS function takes the starting index ('s'), candidates array, remaining target value ('target'), current path (combination), and the final result list ('ans').
    return ans;
  }

  private void dfs(int s, int[] candidates, int target, List<Integer> path,
                   List<List<Integer>> ans) 
                   {
    //DFS Implementation:
    //Base Cases:
    if (target < 0) //If the remaining target becomes negative, it means the current combination is not valid, so return.
      return;
    if (target == 0) 
    {
      ans.add(new ArrayList<>(path)); //If the remaining target becomes 0, add the current combination to the result list and return.
      return;
    }

    //DFS Iteration:
    for (int i = s; i < candidates.length; ++i)  //Iterate through candidates starting from index 's'.
    {
    //Check for Duplicates:
      if (i > s && candidates[i] == candidates[i - 1]) //Skip the current iteration if the candidate is the same as the previous one to avoid duplicate combinations.
        continue;

    //DFS Recursive Calls:
      path.add(candidates[i]); //Add the current candidate to the path: 'path.add(candidates[i]);'.
      dfs(i + 1, candidates, target - candidates[i], path, ans); //Recursively call DFS with the updated parameters: 'dfs(i + 1, candidates, target - candidates[i], path, ans);'.
      path.remove(path.size() - 1); //Backtrack by removing the last element from the path: 'path.remove(path.size() - 1);'.
    }
  }
  //Invoke DFS:
    //'dfs(0, candidates, target, new ArrayList<>(), ans);:' Start the DFS from the first candidate (index 0) with an empty path and the original target value.

//Return Result:
    //'return ans;:' Return the list containing all valid combinations.
}