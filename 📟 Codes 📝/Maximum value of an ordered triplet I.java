class Solution 
{
  //Initialization:
  public long maximumTripletValue(int[] nums) 
  {
    long ans = 0;
    int maxDiff = 0; // max(nums[i] - nums[j])
    int maxNum = 0;  // max(nums[i])
    //Initializes the variables:
    //'ans': Stores the maximum triplet product.
    //'maxDiff': Stores the maximum difference 'nums[i] - nums[j]'.
    //'maxNum': Stores the maximum value encountered in the array.

    //Iterating Through the Array:
    for (final int num : nums) 
    {
      ans = Math.max(ans, (long) maxDiff * num); // num := nums[k]
      maxDiff = Math.max(maxDiff, maxNum - num); // num := nums[j]
      maxNum = Math.max(maxNum, num);            // num := nums[i]
    }
    //Iterates through each element 'num' in the array 'nums'.
    //Updates the 'ans' variable by taking the maximum of the current 'ans' and the product of 'maxDiff' and the current 'num'.
    //Updates the 'maxDiff' variable by taking the maximum of the current 'maxDiff' and the difference between 'maxNum' and the current 'num'.
    //Updates the 'maxNum' variable by taking the maximum of the current 'maxNum' and the current 'num'.

    //Return Result:
    return ans;
    //Returns the final result, which represents the maximum possible value of the product of a triplet (nums[i], nums[j], nums[k]) in the array 'nums', subject to the constraint that 'nums[j] - nums[i]' is maximized.
  }
}