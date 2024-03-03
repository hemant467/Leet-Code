class Solution 
{
  public int divide(long dividend, long divisor) 
  {
    // Handle overflow case: -2^31 / -1 = 2^31 will overflow, so return 2^31 - 1.
    
    //Edge Case Handling:
    if (dividend == Integer.MIN_VALUE && divisor == -1)//Checks for the special case where the dividend is 'Integer.MIN_VALUE' and the divisor is -1, which would result in an overflow. In this case, it returns 'Integer.MAX_VALUE' to avoid overflow.
      return Integer.MAX_VALUE;

    // Determine the sign of the result.
    final int sign = dividend > 0 ^ divisor > 0 ? -1 : 1; //Determines the sign of the result based on whether the operands have different signs.
    
    //Initialize Variables:
    long ans = 0;//Initializes the result to 0.
    long dvd = Math.abs(dividend);//Takes the absolute value of the dividend.
    long dvs = Math.abs(divisor);//Takes the absolute value of the divisor.

    // Perform division using repeated subtraction.
    while (dvd >= dvs) 
    {
      long k = 1;//Initializes 'k' to 1, representing the current multiple of 'dvs'.Binary search is used to find the largest multiple of 'dvs' that does not exceed 'dvd'.

      while (k * 2 * dvs <= dvd)//Doubles 'k' until k * 2 * dvs exceeds 'dvd'.
        k *= 2;
      dvd -= k * dvs;//Subtracts the multiple 'k * dvs' from 'dvd'.
      ans += k;//Adds the multiple 'k' to the result
    }

    //Return Result:
    return sign * (int) ans;//Returns the result with the correct sign as an integer.
  }
}