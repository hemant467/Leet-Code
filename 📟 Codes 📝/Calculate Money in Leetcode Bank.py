#The below code defines a function `totalMoney` that calculates the total amount of money one would have earned after `n` weeks of work, following a specific payment scheme where the payment increases each week.
class Solution:
  def totalMoney(self, n: int) -> int:
    #Trapezoid Function:
    def trapezoid(a: int, b: int) -> int: #The `trapezoid` function takes two integers `a` and `b` as input and calculates the sum of integers from `a` to `b`
      """Returns sum(a..b)."""
      return (a + b) * (b - a + 1) // 2 #inclusive using the formula for the sum of an arithmetic series: {sum}(a..b) = frac{(a + b)*(b - a + 1)}/2.

    #Week Calculation: The number of complete weeks (`weeks`) and the number of remaining days after those complete weeks (`n % 7`) are calculated.
    weeks = n // 7

    #Total Calculation:
    firstWeek = trapezoid(1, 7) #The total amount of money earned in the first week (`firstWeek`) is calculated using the `trapezoid` function for the range 1 to 7.

    lastFullWeek = trapezoid(1 + weeks - 1, 7 + weeks - 1) #The total amount of money earned in the last full week (`lastFullWeek`) is calculated using the `trapezoid` function for the range 1+weeks to 7+weeks-1.

    remainingDays = trapezoid(1 + weeks, n % 7 + weeks) #The total amount of money earned for the remaining days (`remainingDays`) is calculated using the `trapezoid` function for the range 1+weeks to n%7+weeks.
    
    #Return Value: The function returns the total amount of money earned.
    return (firstWeek + lastFullWeek) * weeks // 2 + remainingDays
    #Finally, the total amount of money earned is calculated as the sum of the first and last full weeks, multiplied by the number of complete weeks divided by 2 (since each full week's payment increases in an arithmetic progression), plus the earnings from the remaining days.

#Time Complexity : O(1)
#Space Complexity : O(1)

#The above code efficiently calculates the total earnings following the specified payment scheme for `n` weeks.