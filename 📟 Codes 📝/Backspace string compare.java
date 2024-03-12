//Using 2pointers
class Solution 
{
  public boolean backspaceCompare(String s, String t) 
  {
    //Initialization:
    int i = s.length() - 1; // s' index.Initialize the index 'i' for string 's' at the last character.
    int j = t.length() - 1; // t's index.Initialize the index 'j' for string 't' at the last character.

    //Main Loop:
    while (true) 
    {
        //Backspace Handling for String s:
      // Delete characters of s if needed.
      int backspace = 0; //Initialize a counter for backspaces.
      while (i >= 0 && (s.charAt(i) == '#' || backspace > 0)) //Process backspaces and characters in reverse order for string 's'.
      {
        backspace += s.charAt(i) == '#' ? 1 : -1; //If the character is '#', increment the backspace counter; otherwise, decrement the counter.
        --i; //Move the index 'i' towards the start of the string.
        //This loop handles the backspaces in string 's'.
      }

      //Backspace Handling for String 't':
      // Delete characters of t if needed.
      
      backspace = 0; //Initialize a counter for backspaces.
      while (j >= 0 && (t.charAt(j) == '#' || backspace > 0)) //Process backspaces and characters in reverse order for string 't'.
      {
        backspace += t.charAt(j) == '#' ? 1 : -1; //If the character is '#', increment the backspace counter.
        --j; //Otherwise, decrement the counter.
        //Move the index 'j' towards the start of the string.
        //This loop handles the backspaces in string 't'.
      }

      //Character Comparison:
      if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) //Compare characters at the current indices for equality.


    //If characters are equal, decrement both indices i and j.
      {
        --i;
        --j;
      } 
      else 
    //If characters are not equal, break out of the loop.
      {
        break;
      }
    }
    //Check for Completion:
    return i == -1 && j == -1; //Check if both indices have reached the beginning of their respective strings. If true, it means both strings are equal after considering backspaces.
  }
  //Complexity:
    //The time complexity of this algorithm is O(max(m, n)), where m and n are the lengths of strings 's' and 't'. The loop iterates through both strings, and each character is considered at most once.
}