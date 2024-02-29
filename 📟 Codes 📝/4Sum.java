class Solution {
    //Method Signature:
  public List<List<Integer>> fourSum(int[] nums, int target)
  //The 'fourSum' method takes an array of integers 'nums' and an integer 'target' as input and returns a list of lists containing unique quadruplets whose sum is equal to the target.
   {
       //Initialization and Sorting:
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    //A list 'ans' is initialized to store the final quadruplets.
    //The input array 'nums' is sorted in ascending order. Sorting is crucial for handling duplicates and optimizing the solution.

    //Recursive nSum Function:
    nSum(nums, 4, target, 0, nums.length - 1, new ArrayList<>(), ans);
    return ans;
    //The 'nSum' function is called to find 4 numbers that add up to the target. The function is generalized to find 'n' numbers.
    //Parameters include the array 'nums', the value of 'n' (4 in this case), the target sum, the left and right pointers ('l' and 'r'), the current path, and the result list 'ans'.
  }

  // Finds n numbers that add up to the target in [l, r].
  private void nSum(int[] nums, long n, long target, int l, int r, List<Integer> path,
                    List<List<Integer>> ans) {
    //Base Case Checks:
    if (r - l + 1 < n || target < nums[l] * n || target > nums[r] * n)
      return;
      //If the size of the range '[l, r]' is less than 'n', or the target is outside the range of possible values, the function returns, as it's not possible to find 'n' numbers.
    
    //Case for n = 2 (Similar to 3Sum):
    if (n == 2) 
    //If 'n' is 2, the function follows a similar procedure to the subprocedure in the 3Sum problem.
    //The two-pointer technique is used to find pairs of numbers that sum up to the target.
    {
      // Similar to the sub procedure in 15. 3Sum
      while (l < r) {
        final int sum = nums[l] + nums[r];
        if (sum == target) {
          path.add(nums[l]);
          path.add(nums[r]);
          ans.add(new ArrayList<>(path));
          path.remove(path.size() - 1);
          path.remove(path.size() - 1);
          ++l;
          --r;
          while (l < r && nums[l] == nums[l - 1])
            ++l;
          while (l < r && nums[r] == nums[r + 1])
            --r;
        } else if (sum < target) {
          ++l;
        } else {
          --r;
        }
      }
      return;
    }

    //Recursive Case (n > 2):
    for (int i = l; i <= r; ++i) 
    //For 'n > 2', the function uses recursion and iterates through each element in the range '[l, r]'.
    //Duplicates are skipped to avoid duplicate quadruplets.
    {
      if (i > l && nums[i] == nums[i - 1])
        continue;
        //Recursion and Backtracking:
      path.add(nums[i]);
      //For each element, it adds the element to the current path, makes a recursive call with reduced 'n' and updated target, and then removes the last element from the path (backtracking).
      nSum(nums, n - 1, target - nums[i], i + 1, r, path, ans);
      path.remove(path.size() - 1);
    }
  }
}