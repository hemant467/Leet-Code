class Solution 
{
    //Method Signature:
  public String maximumOddBinaryNumber(String s) 
  //The method 'maximumOddBinaryNumber' takes a binary string 's' as input and returns a string representing the maximum odd binary number that can be obtained by changing at most one '0' bit to '1'.
  {
      //Counting Zeros and Ones:
    final int zeros = (int) s.chars().filter(c -> c == '0').count();
    final int ones = s.length() - zeros;
    //Counts the number of '0' bits and '1' bits in the input string 's'.
    //Uses the 'chars()' method to obtain an IntStream of characters from the string.
    // Uses the 'filter' operation to count the occurrences of '0' characters.
    //Calculates the number of '1' bits by subtracting the count of '0' bits from the total length of the string.

    //Constructing the Result String:
    return "1".repeat(ones - 1) + "0".repeat(zeros) + "1";
    //Constructs the result string using the following concatenation:
    //"1".repeat(ones - 1): Repeats the character '1' (ones - 1) times. This represents the binary prefix of the result.
    //"0".repeat(zeros): Repeats the character '0' zeros times. This represents the part of the result containing the '0' bits from the original string.
    //"1": Appends the final '1' bit to the end of the result.
  }
}