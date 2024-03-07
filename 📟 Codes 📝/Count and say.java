class Solution 
{
  public String countAndSay(int n) 
  {
    //Initialization:
    StringBuilder sb = new StringBuilder("1"); //'StringBuilder sb = new StringBuilder("1");': Initialize a 'StringBuilder' with the first term of the sequence, which is "1".

    //Loop to Generate Subsequent Terms:
    while (--n > 0)  //Enter a loop that iterates 'n-1' times. The loop generates the next term in the sequence, so it will stop when 'n' becomes 0 (after generating the nth term).
    {
    //Generate Next Term:
      StringBuilder next = new StringBuilder(); //create a new 'StringBuilder' named 'next' to store the digits of the next term.
      for (int i = 0; i < sb.length(); ++i) //Iterate through the characters of the current term ('sb') using a 'for' loop.
        //For each character, count the consecutive occurrences of the same digit.
        //Append the count followed by the digit to the 'next' 'StringBuilder'.

      {
        int count = 1;
        while (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) 
        {
          ++count;
          ++i;
        }
        next.append(count).append(sb.charAt(i));
      }
      
      //Update StringBuilder for the Next Iteration:
      sb = next;
      //Set 'sb' to the value of 'next'. This prepares 'sb' for the next iteration of the loop, where the next term will be generated based on the previous term.
    }

    //Return the Result: After the loop completes, the 'sb' 'StringBuilder' contains the nth term of the "Count and Say" sequence.
    return sb.toString();
  }
  //Time Complexity:
  //The time complexity is O(m), where m is the length of the generated nth term. Each term is generated in a single pass through the previous term.

    //Space Complexity:
    //The space complexity is O(m) due to the 'StringBuilder' ('next') used to store the digits of the next term.
    //The space needed is proportional to the length of the generated nth term.
}