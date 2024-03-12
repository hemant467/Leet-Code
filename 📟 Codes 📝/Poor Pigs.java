class Solution 
{
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) 
    // Calculate the base, which represents the number of attempts
    // that a single pig can make before dying.
  {
    //Calculate Base:
    final int base = minutesToTest / minutesToDie + 1; //Calculate the "base," which represents the number of attempts that a single pig can make before dying. The '+1' is to account for the initial attempt.
    int ans = 0;

    // Loop to find the minimum number of pigs needed.
    // For each iteration, a pig can check "base" buckets.
    
    //Loop to Find Minimum Pigs:
    for (int x = 1; x < buckets; x *= base) //Start with one pig ('x = 1') and multiply it by the base in each iteration until the number of buckets is covered. This loop determines how many times a single pig can attempt to find the poisoned bucket.

    //Count Pigs Needed:
      ++ans; //Increment the count of pigs needed in each iteration of the loop.

    // Return the minimum number of pigs needed.
    return ans;
  }
  //Each pig can be used to perform a set of attempts to identify the poisoned bucket.

  //The loop calculates the minimum number of pigs needed to cover all the buckets within the specified time frame ('minutesToTest'). The base represents the number of attempts each pig can make. The loop continues until the number of buckets is covered.

  //Each pig has a limited number of attempts before it dies, and the goal is to minimize the number of pigs needed to identify the poisoned bucket within the given time constraints.
}