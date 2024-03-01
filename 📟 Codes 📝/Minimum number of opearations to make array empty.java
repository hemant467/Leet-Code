class Solution 
{
  public int minOperations(int[] nums) 
  {
    //Initialization:
    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();
    //Initializes a variable 'ans' to store the total number of operations needed.
    //Initializes a 'HashMap' named 'count' to store the frequency of each unique element in the array.
    //Counting Element Frequencies:
    for (final int num : nums)
      count.merge(num, 1, Integer::sum);
      //Iterates through each element 'num' in the array 'nums'.
      //Uses the 'merge' method to update the frequency of 'num' in the 'count' map. If 'num' is not present, it adds a new entry with a count of 1. If 'num' is already present, it increments the count by 1.

    //Calculating Operations:
    for (final int freq : count.values()) 
    {
      // If freq == 3k, need k operations.
      // If freq == 3k + 1 = 3*(k - 1) + 2*2, need k + 1 operations.
      // If freq == 3k + 2, need k + 1 operations.
      if (freq == 1)
        return -1;
      ans += (freq + 2) / 3;
    }
    //Iterates through the frequency values of unique elements stored in the count map.
    //Checks the following conditions based on the frequency 'freq':
        //If 'freq' is 1, it means there is a single element with a frequency not divisible by 3, so the function returns -1 (impossible to achieve the goal).
        //Otherwise, it calculates the number of operations needed based on the formula '(freq + 2) / 3' and adds this to the total count 'ans'.

    //Return Result:
    return ans;
  }
}