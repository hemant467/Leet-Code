/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution 
{
    //Main Function: 'findInMountainArray'
    //Input Parameters:
    //target: The target element to search for in the mountain array.
    //mountainArr: An instance of the 'MountainArray' interface.
  public int findInMountainArray(int target, MountainArray mountainArr) 
  {
    final int n = mountainArr.length();
    final int peakIndex = peakIndexInMountainArray(mountainArr, 0, n - 1);//Find the index of the peak in the mountain array using the 'peakIndexInMountainArray' function.

    final int leftIndex = searchLeft(mountainArr, target, 0, peakIndex);//Search for the target element in the left side of the mountain array using the 'searchLeft' function.

    if (mountainArr.get(leftIndex) == target)
      return leftIndex;//If the target is found, return the index.

    final int rightIndex = searchRight(mountainArr, target, peakIndex + 1, n - 1);//Search for the target element in the right side of the mountain array using the 'searchRight' function.

    if (mountainArr.get(rightIndex) == target)
      return rightIndex;//If the target is found, return the index.

    return -1;//If the target is not found in both sides, return -1.
  }

  //Peak Index in a Mountain Array
  //Helper Function: peakIndexInMountainArray
  private int peakIndexInMountainArray(MountainArray A, int l, int r) 
  //Input Parameters:
    //'A': An instance of the 'MountainArray' interface.
    //'l': The left index of the search range.
    //'r': The right index of the search range.
  {
    //Use binary search to find the index of the peak in the mountain array.
    while (l < r) 
    {
      final int m = (l + r) / 2;
      if (A.get(m) < A.get(m + 1))//If 'A.get(m) < A.get(m + 1)'.
        //Repeat until l == r, and return the index.
        //move the left pointer ('l') to 'm + 1'.
        l = m + 1;
      else
        r = m;//Otherwise, move the right pointer (r) to m.
    }
    return l;
  }

  //Helper Function: searchLeft
  private int searchLeft(MountainArray A, int target, int l, int r) 
    //'A': An instance of the 'MountainArray' interface.
    //'target': The target element to search for.
    //'l': The left index of the search range.
    //'r': The right index of the search range.
  {
    while (l < r) 
    //Use binary search to find the index of the target in the left side of the mountain array.
    {
      final int m = (l + r) / 2;
      if (A.get(m) < target)//If 'A.get(m) < target', move the left pointer ('l') to 'm + 1'.
        l = m + 1;//Repeat until 'l == r', and return the index.
      else
        r = m;//Otherwise, move the right pointer ('r') to 'm'.
    }
    return l;
  }

  //Helper Function: 'searchRight'
  private int searchRight(MountainArray A, int target, int l, int r)
  //Input Parameters:
  //'A': An instance of the 'MountainArray' interface.
  //'target': The target element to search for.
  //'l': The left index of the search range.
  //'r': The right index of the search range.
  {

    //Steps: Use binary search to find the index of the target in the right side of the mountain array.

    while (l < r) {
      final int m = (l + r) / 2;
      if (A.get(m) > target)//If A.get(m) > target
        l = m + 1;//move the left pointer (l) to m + 1.
      else
        r = m;//Otherwise, move the right pointer (r) to m.
    }
    return l;//Repeat until l == r, and return the index.
  }
}