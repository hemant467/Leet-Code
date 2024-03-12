class Solution 
{
  public int getCommon(int[] nums1, int[] nums2) 
  {
    //Initialization:
    int i = 0; // nums1's index. Initialize the index 'i' for 'nums1' to 0.
    int j = 0; // nums2's index. Initialize the index 'j' for 'nums2' to 0.

    while (i < nums1.length && j < nums2.length) //Continue the loop as long as both indices 'i' and 'j' are within the bounds of their respective arrays ('nums1' and 'nums2').
    {
        //Comparison and Update:
      if (nums1[i] == nums2[j]) //Check if the current elements at indices 'i' and 'j' are equal. If true, it means a common element is found, and the value of that element is returned.
        return nums1[i];
      if (nums1[i] < nums2[j]) //If the element at 'nums1[i]' is less than the element at 'nums2[j]', increment the index 'i' to move to the next element in 'nums1'.
        ++i;
      else //If the element at 'nums1[i]' is greater than the element at 'nums2[j]', increment the index 'j' to move to the next element in 'nums2'.
        ++j;
    }

    return -1; //If the while loop completes without finding a common element, return -1, indicating that there is no common element between the two arrays.
  }
  //Complexity: 
        //The time complexity of this algorithm is O(min(m, n)), where m and n are the lengths of 'nums1' and 'nums2'. Since the loop increments 'i' or 'j' in each iteration, and both indices move towards the end of their respective arrays, the loop can execute at most min(m, n) times.
}