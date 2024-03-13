//The below code counts the number of homogenous substrings in the given string `s`. A homogenous substring is a substring in which all characters are the same.

class Solution 
{
  public int countHomogenous(String s) 
  {
    //Initialize variables:
    final int kMod = 1_000_000_007; //A constant representing the modulo value used for the final result.
    int ans = 0; //An integer variable to store the final count of homogenous substrings.
    int count = 0; //An integer variable to keep track of the length of the current homogenous substring.
    char currentChar = '@'; //A character variable to store the current character being processed. Initialize it with a character that is not present in the string `s`.

    //Loop Through Characters
    for (final char c : s.toCharArray()) //Iterate through each character `c` in the input string `s`.
    {
        //For each character:
      count = c == currentChar ? count + 1 : 1; //If `c` is equal to the `currentChar`, it means the character is the same as the previous one, so increment the `count` by 1. If `c` is different from the `currentChar`, it indicates the start of a new homogenous substring, so reset the `count` to 1.
      currentChar = c; //Update the `currentChar` to the current character `c`.
      ans += count; //Add the value of `count` to `ans`. This represents the number of homogenous substrings ending at the current position.
      ans %= kMod; //Update `ans` with the modulo `kMod` to prevent overflow.
    }

    //Return Result
    return ans; //After processing all characters in the string, return the final count `ans`.
  }
    //The code efficiently counts the number of homogenous substrings in linear time complexity by iterating through the characters of the string only once. It uses constant space as it maintains only a few variables to keep track of the count and the current character.
}