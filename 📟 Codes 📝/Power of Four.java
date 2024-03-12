class Solution 
{
  public boolean isPowerOfFour(int n) 
  {
    // Why (4^n - 1) % 3 == 0?
    // (4^n - 1) = (2^n - 1)(2^n + 1) and 2^n - 1, 2^n, 2^n + 1 are
    // three consecutive numbers; among one of them, there must be a multiple
    // of 3, and that can't be 2^n, so it must be either 2^n - 1 or 2^n + 1.
    // Therefore, 4^n - 1 is a multiple of 3
    return n > 0 && Integer.bitCount(n) == 1 && (n - 1) % 3 == 0;
    //Check if 'n' is positive: 'n > 0': Ensure that 'n' is a positive integer. The code only considers positive integers for power of four checks.
    
    //Check if 'n' has only one set bit: 'Integer.bitCount(n) == 1': 'Use Integer.bitCount' to count the number of set bits in 'n'. For 'n' to be a power of four, it should have exactly one set bit. For example, 4 is '100' in binary, and only one bit is set.

    //Check if (n - 1) % 3 == 0: This condition is based on a mathematical property. It checks whether '(4^n - 1)' is divisible by 3.

//The explanation is provided in comments:
    //'(4^n - 1) = (2^n - 1)(2^n + 1)': Decompose the expression into the difference of two squares.
    //'2^n - 1, 2^n, 2^n + 1': These are three consecutive numbers. Among them, there must be a multiple of 3.
    //'(n - 1) % 3 == 0': Therefore, '(4^n - 1)' is a multiple of 3.

//Return the result: The function returns 'true' if all conditions are met, indicating that 'n' is a power of four. Otherwise, it returns 'false'.

  }
}