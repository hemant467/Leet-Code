class Solution 
{
    //Method Signature:
  public int firstMissingPositive(int[] nums) 
  {
    //Initialization:
    final int n = nums.length; //Get the length of the input array.

    //Rearrange the Array:
    //Use an in-place rearrangement to correct the slots:


    // Correct slot:
    // nums[i] = i + 1
    // nums[i] - 1 = i
    // nums[nums[i] - 1] = nums[i]

    //For each index 'i':
    for (int i = 0; i < n; ++i)
      while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1); //While 'nums[i]' is a positive integer within the valid range ('1' to 'n') and not in its correct slot ('nums[i] != i + 1'), swap 'nums[i]' with 'nums[nums[i] - 1]'.
    //This process continues until the element at index 'i' is in its correct slot '(nums[i] = i + 1)'.

    //Find the First Missing Positive:
    for (int i = 0; i < n; ++i)
    //Iterate through the rearranged array:
      if (nums[i] != i + 1) //If 'nums[i] != i + 1', return 'i + 1' as the first missing positive integer.
        return i + 1;

    //Handle the Case of No Missing Positive:
    return n + 1;
    //If the entire array has been scanned without finding a missing positive, return 'n + 1'.
  }

    //Swap Helper Function:
  private void swap(int[] nums, int i, int j) //Helper function to swap elements at indices 'i' and 'j' in the array.
  {
    final int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
    //Time Complexity:
    //The algorithm performs a constant amount of work for each element in the array during rearrangement and scanning.
    //The time complexity is O(n), where n is the length of the array.
    
    //Space Complexity:
    //The algorithm uses a constant amount of extra space, and the rearrangement is done in-place.
    //The space complexity is O(1).
}