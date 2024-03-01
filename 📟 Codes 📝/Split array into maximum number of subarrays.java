class Solution 
{
  public int maxSubarrays(int[] nums) 
  {
    //Initialization:
    int ans = 0;
    int score = 0;
    //Initializes the variable 'ans' to 0, which will store the final result.
    //Initializes the variable 'score' to 0, which represents the bitwise AND of the current subarray.

    //Iterating Through Array:
    for (final int num : nums) 
    {
      score = score == 0 ? num : score & num;
      if (score == 0)
        ++ans;
    }
    //Iterates through each element 'num' in the array 'nums'.
    //Updates the 'score' based on the bitwise AND of the current element and the previous 'score'. If 'score' is 0, it is set to the current element 'num'.
    //Checks if the 'score' becomes 0 after the update. If it does, increments the ans counter.
    
    //Return Result:
    return Math.max(1, ans);
    //Returns the maximum of 1 and the value stored in the 'ans' variable.
  }
}