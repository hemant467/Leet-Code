class Solution 
{
    //Method Signature:
  public int maxFrequencyElements(int[] nums) 
  {
    //Variables
    final int kMax = 100; //A constant representing the maximum possible value of an element in the array.
    int ans = 0; //A variable to store the result, which is the sum of frequencies of the most frequently occurring elements.
    int[] count = new int[kMax + 1]; //An array to store the count of occurrences for each possible value of an element in the array.

    //Count Frequencies:
    for (final int num : nums) //Iterate through the array 'nums'.
      ++count[num]; //For each element, increment the corresponding count in the 'count' array.

    //Find Maximum Frequency:
    final int maxFreq = Arrays.stream(count).max().getAsInt(); //Calculate the maximum frequency ('maxFreq') by finding the maximum value in the 'count' array using 'Arrays.stream(count).max().getAsInt()'.

    //Sum Frequencies of Most Frequent Elements:
    for (final int freq : count) //Iterate through the 'count' array.
      if (freq == maxFreq) //For each frequency ('freq'), if it is equal to the maximum frequency ('maxFreq'), add it to the result ('ans').
        ans += maxFreq;

    //Return Result:
    return ans; //The final result is stored in the variable 'ans', representing the sum of frequencies of the most frequently occurring elements.
  }

//Time Complexity:
    //The algorithm iterates through the array once and the count array once. Both operations are linear, resulting in a time complexity of O(n), where n is the length of the input array.

//Space Complexity:
    //The algorithm uses an additional array ('count') with a constant size ('kMax + 1'), resulting in O(1) space complexity.
    
}