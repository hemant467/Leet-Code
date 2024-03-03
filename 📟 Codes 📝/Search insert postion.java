class Solution 
{
    //Method:
  public int searchInsert(int[] nums, int target) 
    //The 'searchInsert' method takes in a sorted array 'nums' and a 'target' value target.
    //It uses a binary search approach to find the insertion position of the target value in the array.

    //Binary Search Logic:
  {
    //The 'l' (left) and 'r' (right) pointers are initialized to the beginning and end of the array, respectively.
    int l = 0;
    int r = nums.length;

    //The while loop continues until 'l' is less than 'r'.
    while (l < r) 
    {
        //In each iteration, the midpoint 'm' is calculated as '(l + r) / 2'.
        //If the value at index 'm' is equal to the target, it means the target is found, and the method returns the index 'm'.
        //If the value at index 'm' is less than the target, it updates the left pointer 'l' to 'm + 1' since the target must be on the right side of 'm'.
        //If the value at index 'm' is greater than or equal to the target, it updates the right pointer 'r' to 'm' since the target must be on the left side of or equal to 'm'.

    //Insertion Position:
      final int m = (l + r) / 2;
      if (nums[m] == target)
        return m;
      if (nums[m] < target)
        l = m + 1;//If the target is not found in the array, the method returns the final value of l, which represents the insertion position of the target.
      else
        r = m;
        //The insertion position is the index where the target should be inserted to maintain the sorted order.
    }

    return l;
  }
    //Time Complexity: The time complexity of the binary search is O(log N), where N is the length of the input array 'nums'.

    //Space Complexity: The space complexity is O(1) since the algorithm uses only a constant amount of extra space.
}