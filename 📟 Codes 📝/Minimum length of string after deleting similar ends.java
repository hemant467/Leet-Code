//Minimum length of a string after removing palindromic subsequences. 
class Solution 
{
  public int minimumLength(String s) //'s': A string for which we want to find the minimum length after removing palindromic subsequences.
  {
    //Two-Pointer Approach: Initialize two pointers 'i' and 'j'.
    int i = 0; //'i' starts from the beginning of the string
    int j = s.length() - 1; //'j' starts from the end of the string.

    //Loop to Find Palindromic Subsequences: Use a 'while' loop to iterate as long as 'i' is less than 'j' and the characters at 'i' and 'j' are equal.
    while (i < j && s.charAt(i) == s.charAt(j)) 
    {
      final char c = s.charAt(i);//Store the character at index 'i' (or 'j') in the variable 'c'.
      while (i <= j && s.charAt(i) == c)//Use a nested 'while' loop to increment 'i' as long as the characters at 'i' are equal to 'c'.
        ++i;
      while (i <= j && s.charAt(j) == c)//Use another nested 'while' loop to decrement 'j' as long as the characters at 'j' are equal to 'c'.
        --j;
    }
    //Return Result:
    return j - i + 1; //Return the length of the remaining string, given by j - i + 1.
  }
  //Time Complexity: The time complexity is O(n), where n is the length of the input string. The two pointers traverse the string linearly.

  //Space Complexity: The space complexity is O(1), as the algorithm uses a constant amount of extra space.
}