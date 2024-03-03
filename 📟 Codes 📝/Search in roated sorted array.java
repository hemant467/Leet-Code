//Binary Search: The below code uses a binary search approach to find the index of the target element in the rotated sorted array.
class Solution 
{
  public int search(int[] nums, int target) 
  {
    int l = 0;
    int r = nums.length - 1;

    //Loop Condition:
    while (l <= r) //The binary search continues as long as the left pointer 'l' is less than or equal to the right pointer 'r'.
    {
        //Midpoint Calculation:
      final int m = (l + r) / 2; //Calculates the midpoint index 'm' in the current search range.
      if (nums[m] == target)
        return m;
      if (nums[l] <= nums[m]) 
      {
        // nums[l..m] are sorted.
        if (nums[l] <= target && target < nums[m])
          r = m - 1;
        else
          l = m + 1;
      }
       else 
       { 
           // nums[m..n - 1] are sorted.
        if (nums[m] < target && target <= nums[r])
          l = m + 1;
        else
          r = m - 1;
      }
    }

    return -1;
  }
    //Time Complexity: The time complexity is O(log N), where N is the length of the input array 'nums'.

    //Space Complexity: The space complexity is O(1) since the algorithm uses only a constant amount of extra space.
}