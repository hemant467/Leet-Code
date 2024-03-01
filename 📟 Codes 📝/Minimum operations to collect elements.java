class Solution 
{
  public int minOperations(List<Integer> nums, int k) 
  {
    //Initialization:
    Set<Integer> seen = new HashSet<>();
    //Initializes a set 'seen' to keep track of distinct elements.

    //Reverse Iteration Through List:
    for (int i = nums.size() - 1; i >= 0; --i) 
    //Iterates through the elements of the 'nums' list in reverse order, starting from the last element.
    {
        //Element Comparison and Set Update:
      if (nums.get(i) > k)
        continue;
      seen.add(nums.get(i));
      //Checks if the current element at index 'i' is greater than 'k'. If so, it skips the current iteration.
        //Adds the current element to the set 'seen'.

    //Distinct Elements Count Check:
      if (seen.size() == k)
        return nums.size() - i;
    //Checks if the size of the set 'seen' is equal to 'k'. If so, it means 'k' distinct elements have been encountered, and the method returns the count of elements from the end ('nums.size() - i').
    }
    //Exception Handling:
    throw new IllegalArgumentException();
    //Throws an 'IllegalArgumentException' if the loop completes without finding a subarray with exactly 'k' distinct elements.
  }
}