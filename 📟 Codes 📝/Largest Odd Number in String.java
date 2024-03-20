//The below code defines a function `largestOddNumber` that takes a string `num` representing a non-negative integer as input and returns the largest odd number that can be formed by removing digits from the end of the input number.
class Solution 
{
    //Iterating from the End of the String: The code iterates through the characters of the input string `num` from the end (rightmost character) to the beginning (leftmost character) using a for loop.
  public String largestOddNumber(String num) 
  {
    //Checking for Odd Digits:
    for (int i = num.length() - 1; i >= 0; --i) //For each character at index `i`, it checks if the digit represented by that character is odd.
      if ((num.charAt(i) - '0') % 2 == 1) //The digit is determined to be odd if its integer value modulo 2 is equal to 1. This is done by subtracting the character `'0'` (which represents the ASCII value of the character '0') from the character at index `i`, converting it to its integer value, and then performing the modulo operation.

        //Returning the Result: If an odd digit is found at index `i`, the code returns the substring of `num` from index 0 to index `i` (inclusive). This substring represents the largest odd number that can be formed by retaining digits from the original number.
        //If no odd digit is found in the entire string, an empty string is returned to indicate that no odd number can be formed.
        return num.substring(0, i + 1);

    //Return Value: The function returns the largest odd number that can be formed by removing digits from the end of the input number.
    return "";
  }
    //Time Complexity : O(n)
    //Space Complexity : O(n)

    //The above code efficiently identifies the largest odd number that can be obtained from the input string by removing digits from the end.
}