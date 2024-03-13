class Solution 
{
  public int pivotInteger(int n) 
  {
    // 1 + 2 + ... + x = x + ... + n
    // (1 + x) * x / 2 = (x + n) * (n - x + 1) / 2
    //         x + x^2 = nx - x^2 + x + n^2 - nx + n
    //         2 * x^2 = n^2 + n
    //               x = sqrt((n^2 + n) / 2)
    final int y = (n * n + n) / 2; //This line calculates the sum of the first 'n' positive integers using the formula for the sum of an arithmetic series (Sn = n * (n + 1) / 2). It's represented as '(n * n + n) / 2'. This sum represents the total number of elements in the sequence.

    final int x = (int) Math.sqrt(y); //This line calculates the square root of the sum 'y' obtained in the previous step. It uses the 'Math.sqrt()' method from the 'Math' class to find the square root. Since 'Math.sqrt()' returns a 'double', the result is cast to an 'int' to obtain the integer square root.

    return x * x == y ? x : -1; //This line checks if the square of 'x' is equal to 'y'. If it is, it means that 'x' is a perfect square and represents the square root of 'y'. In this case, the function returns 'x'. Otherwise, it returns '-1', indicating that there is no integer square root for the given input 'n'.
  }
  //The above code calculates the integer square root of the sum of the first 'n' positive integers. If the square root is an integer, it returns that integer; otherwise, it returns '-1'.
}