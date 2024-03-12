class Solution 
{
  public int constrainedSubsetSum(int[] nums, int k) 
  {
    // dp[i] := the maximum the sum of non-empty subsequences in nums[0..i]
    int[] dp = new int[nums.length];
    //This array stores the maximum sum of non-empty subsequences ending at each index 'i' in the array 'nums'.
    // dq stores dp[i - k], dp[i - k + 1], ..., dp[i - 1] whose values are > 0
    // in decreasing order.

    Deque<Integer> dq = new ArrayDeque<>();
    //Deque<Integer> dq : This deque is used to maintain a window of elements in 'dp' such that only elements in the last 'k' positions that are greater than 0 are considered.

    for (int i = 0; i < nums.length; ++i) //The loop iterates through each element of the array 'nums'.
    {
      if (dq.isEmpty())
        dp[i] = nums[i]; //If the deque is empty, it means we are at the beginning, and the maximum sum is just the current element.
      else
        dp[i] = Math.max(dq.peekFirst(), 0) + nums[i]; //If the deque is not empty, we consider the maximum sum from the last 'k' elements in 'dp', ensuring it's at least 0, and add the current element.
      while (!dq.isEmpty() && dq.peekLast() < dp[i]) //We maintain the deque in decreasing order by removing elements that are smaller than the current 'dp[i]'.
        dq.pollLast();
      dq.offerLast(dp[i]); //We add the current 'dp[i]' to the deque.
      if (i >= k && dp[i - k] == dq.peekFirst())
        dq.pollFirst(); //If the window extends beyond 'k', we remove the leftmost element from the deque if it matches the value at 'dp[i - k]'.
    }

    return Arrays.stream(dp).max().getAsInt(); //We find and return the maximum value in the 'dp' array.
  }
    //The algorithm ensures that it only considers valid subsequences (non-empty and of length at most 'k') and efficiently updates the maximum sum using a deque. The final result is the maximum sum of non-empty subsequences in the array 'nums'.
}