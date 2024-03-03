class Solution 
{
  public void nextPermutation(int[] nums) 
  {
    final int n = nums.length;

    //Finding the First Decreasing Element (i):
    // From back to front, find the first number < nums[i + 1].
    int i;
    for (i = n - 2; i >= 0; --i)
      if (nums[i] < nums[i + 1])
        break;
    //The first loop 'for (i = n - 2; i >= 0; --i)' iterates from the end to the beginning of the array to find the first index 'i' such that 'nums[i] < nums[i + 1]'. This is the first element from the right that can be swapped.

    // From back to front, find the first number > nums[i], swap it with
    // nums[i].

    //Finding the Rightmost Larger Element (j) and Swapping:
    if (i >= 0)
      for (int j = n - 1; j > i; --j)
        if (nums[j] > nums[i]) {
          swap(nums, i, j);
          break;
          //If such an index 'i' is found 'if (i >= 0)', the second loop 'for (int j = n - 1; j > i; --j)' iterates from the end to find the rightmost index 'j' such that 'nums[j] > nums[i]'. It swaps the elements at indices 'i' and 'j'.
        }

    //Reversing the Remaining Part:
    // Reverse nums[i + 1..n - 1].
    reverse(nums, i + 1, n - 1);
    //After swapping, the remaining part of the array from index 'i + 1' to the end 'nums[i + 1..n - 1]' is in decreasing order. To get the next lexicographically greater permutation, this part needs to be reversed. The 'reverse' method is called for this purpose.
  }

  //Reverse Method:
  private void reverse(int[] nums, int l, int r) //This method reverses the elements in the subarray 'nums[l..r]'.

{   
    //Swap Method:
    while (l < r)
      swap(nums, l++, r--);
  }

  private void swap(int[] nums, int i, int j) //This method swaps the elements at indices 'i' and 'j' in the array 'nums'.
   {
    final int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}