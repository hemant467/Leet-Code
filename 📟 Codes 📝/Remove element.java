class Solution 
{
  public int removeElement(int[] nums, int val) 
  {
    int i = 0;// Initialize a pointer to keep track of the current position in the modified array

    for (final int num : nums) //Iterates through each element in the original array 'nums'
      if (num != val) //Checks if the current element 'num' is not equal to the specified value 'val'
        nums[i++] = num;// If the current element is not equal to val, update nums[i] and increment i.

    return i;// Return the length of the modified array after removal.
  }
}