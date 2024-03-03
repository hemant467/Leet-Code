//The below code aims to find the range (start and end indices) of a target value in a sorted array.
//The approach is to perform two binary searches: 
//->one to find the first occurrence of a value greater than or equal to the target, and 
//->The second to find the first occurrence of a value greater than the target.

class Solution 
{
    //searchRange Method:
  public int[] searchRange(int[] nums, int target) 
  {
    final int l = firstGreaterEqual(nums, target);
    if (l == nums.length || nums[l] != target)
      return new int[] {-1, -1};
    final int r = firstGreaterEqual(nums, target + 1) - 1;
    return new int[] {l, r};
    //The 'searchRange' method is the main function that finds the range of the target value.
    //It uses the 'firstGreaterEqual' method to find the indices of the first occurrence of the target and the first occurrence of a value greater than the target.
    //If the target is not found or if the first occurrence of the target is beyond the end of the array, it returns '{-1, -1}', indicating that the target is not present in the array.
    //Otherwise, it returns the range '[l, r]'.
  }

    //firstGreaterEqual Method: The 'firstGreaterEqual' method performs a binary search to find the index of the first element in the array that is greater than or equal to the target.
  private int firstGreaterEqual(int[] A, int target) 
  {
    //It maintains two pointers, 'l' (left) and 'r' (right), to narrow down the search range.
    int l = 0;
    int r = A.length;

    //The while loop continues until 'l' is equal to 'r', and the midpoint 'm' is calculated as '(l + r) / 2'.
    while (l < r) 
    {
      final int m = (l + r) / 2;
      if (A[m] >= target)
        r = m; //If the value at index 'm' is greater than or equal to the target, it updates the right pointer 'r' to 'm'.
      else
        l = m + 1; //If the value at index 'm' is less than the target, it updates the left pointer 'l' to 'm + 1'.
    }
    //The method returns the final value of 'l', which represents the index of the first element greater than or equal to the target.

    return l;
  }
  //Time Complexity:
    //The time complexity is O(log N), where N is the length of the input array 'nums'.
    //This is because the binary search is used to find the two indices.

  //Space Complexity:
    //The space complexity is O(1) since the algorithm uses only a constant amount of extra space.  
}