class Solution 
{
  public int maximumScore(int[] nums, int k) 
  {
    int ans = 0; //This variable will store the maximum score.
    Deque<Integer> stack = new ArrayDeque<>(); //Deque is used to maintain indices in a non-decreasing order.

    for (int i = 0; i <= nums.length; ++i) //The loop iterates through each element of the array 'nums', and also considers an additional iteration (when 'i == nums.length') to handle the remaining elements in the stack.
    {
      while (!stack.isEmpty() && (i == nums.length || nums[stack.peek()] > nums[i])) //This loop checks if the current element is greater than the top element of the stack. If it is, it calculates the area of the subarray formed by the popped element as the center.
      {
        final int h = nums[stack.pop()]; //The height of the subarray is the value of the popped element.
        final int w = stack.isEmpty() ? i : i - stack.peek() - 1; //The width of the subarray is calculated based on the current index and the index of the previous element in the stack.
        if ((stack.isEmpty() || stack.peek() + 1 <= k) && i - 1 >= k) //This condition checks if the center element at index 'k' falls within the subarray, and if the subarray is not empty.
          ans = Math.max(ans, h * w); //If the conditions are met, update the maximum score.
      }
      stack.push(i); //Push the current index onto the stack.
    }
    return ans; //Return the maximum score.
  }
}