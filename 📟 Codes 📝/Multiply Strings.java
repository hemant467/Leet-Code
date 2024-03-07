class Solution 
{
    //Method Signature:
  public String multiply(String num1, String num2) 
  {
    //Initialization:
    final int m = num1.length(); //Get the length of the first number.
    final int n = num2.length(); //Get the length of the second number.

    StringBuilder sb = new StringBuilder(); //Initialize a StringBuilder to store the result.
    int[] pos = new int[m + n]; //Initialize an array 'pos' to store the position-wise sum of products.

    //Digit-by-Digit Multiplication:
    //Iterate over the digits of both numbers, from right to left:
    for (int i = m - 1; i >= 0; --i)
      for (int j = n - 1; j >= 0; --j) 
      {
        //Calculate the product of the current digits and add it to the corresponding position in the 'pos' array:
        final int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        final int sum = multiply + pos[i + j + 1];
        pos[i + j] += sum / 10;
        pos[i + j + 1] = sum % 10;
      }

    //Construct the Result:
    //Iterate over the elements of the 'pos' array and append each non-zero digit to the result StringBuilder:
    for (final int p : pos)
      if (p > 0 || sb.length() > 0)
        sb.append(p);

    //Handle Edge Case:
    //If the result StringBuilder is empty, set the result to "0".
    return sb.length() == 0 ? "0" : sb.toString();
  }
  
  //Time Complexity:
        //The algorithm performs digit-by-digit multiplication using two nested loops.
        //The time complexity is O(m * n), where m and n are the lengths of the input numbers.

   //Space Complexity:
        //The algorithm uses an array of size 'm + n' to store the position-wise sum of products.
        //The space complexity is O(m + n).
}