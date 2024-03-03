class Solution 
{
    //Time: O((m-n)), where m = |haystack| and n = |needle|
    //Space: O(1)
  public int strStr(String haystack, String needle) 
  {
    final int m = haystack.length();//Computes the length of the string 'haystack' and stores it in the variable 'm'.
    final int n = needle.length();//Computes the length of the string 'needle' and stores it in the variable 'n'.

    for (int i = 0; i < m - n + 1; ++i)//Iterates through possible starting indices in the 'haystack' where 'needle' could potentially match.

      if (haystack.substring(i, i + n).equals(needle))
      //Checks if the substring of 'haystack' starting from index 'i' with length 'n' equals the string 'needle'.
      //If true, returns the current index i as it is the starting index of the first occurrence of 'needle' in 'haystack'.
        return i;
        //Returns -1 if no occurrence of 'needle' is found in 'haystack'.

    return -1;
  }
}