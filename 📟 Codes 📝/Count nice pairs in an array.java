//The below Java function `countNicePairs` calculates the number of "nice pairs" in the given array `nums`. A "nice pair" is defined as a pair of indices (i, j) such that nums[i] + rev(nums[j]) = nums[j] + rev(nums[i]), where rev(num) is the reverse of the number `num`.
class Solution 
{
  public int countNicePairs(int[] nums) 
  {
    //Initialize Variables:
    final int kMod = 1_000_000_007; //The function initializes a constant `kMod` to store the modulo value.
    long ans = 0; //variable `ans` to store the final count of nice pairs.
    Map<Integer, Long> count = new HashMap<>(); //creating a `HashMap` named `count` to store the frequency of differences between each element and its reverse.

    //Calculate Differences and Store Frequencies:
    for (final int num : nums) //It iterates through each element `num` in the `nums` array.
      count.merge(num - rev(num), 1L, Long::sum); //For each element, it calculates the difference between `num` and its reverse (`num - rev(num)`) and updates the frequency of this difference in the `count` map.

    //Calculate Nice Pairs:
    for (final long freq : count.values()) //It iterates through the values (frequencies) stored in the `count` map.
    {
      ans += freq * (freq - 1) / 2; //For each frequency `freq`, it calculates the number of nice pairs that can be formed with this frequency using the formula `(freq * (freq - 1)) / 2`.
      ans %= kMod; //It adds the count of nice pairs to the `ans` variable, taking care of the modulo operation to prevent overflow.
    }

    //Return Result:
    return (int) ans; //Finally, it returns the count of nice pairs as an integer.
  }

    //Helper Function `rev`: The `rev` function takes an integer `n` as input and returns its reverse by iteratively extracting digits from `n` and building the reverse number `x`.
  private int rev(int n) 
  {
    int x = 0;
    while (n > 0) 
    {
      x = x * 10 + (n % 10);
      n /= 10;
    }
    return x;
    //the above code efficiently calculates the count of nice pairs by leveraging a frequency map to avoid duplicate calculations and using modulo arithmetic to handle large integer values.
  }
  //Time Complexity : O(n)
  //Space Complexity : O(n)
}