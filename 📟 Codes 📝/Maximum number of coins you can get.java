//The below code aims to maximize the number of coins obtained by following a certain strategy in selecting piles of coins.
class Solution 
{
  public int maxCoins(int[] piles) 
  {
    //Sorting the Piles: The first step is to sort the array of piles (`piles`). Sorting the array is crucial for the strategy to work effectively.
    Arrays.sort(piles);

    int ans = 0;

    //Selecting Piles: The main strategy here is to select every second pile starting from the one-third mark of the sorted array. This strategy ensures that the person gets the maximum number of coins. The reason behind this strategy is that after sorting, the largest and the second-largest piles will be together towards the end of the sorted array. Hence, picking every second pile starting from the one-third mark ensures that the person gets the second-largest piles, maximizing the total number of coins.

    // piles = [S S M L M L], pick all the M.
    for (int i = piles.length / 3; i < piles.length; i += 2)
    //`piles.length / 3`: This calculates the index from which we start picking piles. Since there are three people (S, M, L), one-third of the total number of piles corresponds to the point where the M-sized piles start.
    //`i += 2`: This ensures that we pick every second pile from the starting index calculated above, skipping the smallest (S-sized) piles and selecting the M-sized piles and larger ones.

    //Calculating the Total Number of Coins: Finally, the code calculates and returns the total number of coins obtained by summing up the values of the selected piles.
      ans += piles[i];

    return ans;
  }
    //Time Complexity : O(sort)
    //Space Complexity : O(sort)
}
//From the above code by selecting every second pile starting from the one-third mark of the sorted array, the code maximizes the number of coins obtained.