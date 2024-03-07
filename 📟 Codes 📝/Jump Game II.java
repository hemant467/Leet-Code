class Solution 
{
    //Method Signature:
  public int jump(int[] nums) 
  {
    //Variables:
    int ans = 0; //Variable to store the minimum number of jumps needed to reach the last index.
    int end = 0; //The current farthest index that can be reached with the current number of jumps.
    int farthest = 0; //The farthest index that can be reached with the current and previous jumps.


    //Iteration Over Array:
        //Iterate over the array 'nums' using the variable 'i'.
    // Start an implicit BFS.
    for (int i = 0; i < nums.length - 1; ++i) 
    //Update 'farthest' to be the maximum of the current 'farthest' and 'i + nums[i]', representing the farthest index that can be reached with the current jump.
    {
      farthest = Math.max(farthest, i + nums[i]);
      if (farthest >= nums.length - 1) //Check if 'farthest' is greater than or equal to the last index of the array ('nums.length - 1').
      {
        ++ans; //If true, it means we can reach the end with the current jump, so increment 'ans' and break the loop.
        break;
      }
      if (i == end) //Check if the current index 'i' is equal to 'end', which indicates that all items on the current level have been visited.

      //If true, increment 'ans' and update 'end' to the current 'farthest'. This represents moving to the next level.
      {   // Visited all the items on the current level.
        ++ans;          // Increment the level.
        end = farthest; // Make the queue size for the next level.
      }
    }

    //Return Result: The final result is stored in the variable 'ans', representing the minimum number of jumps needed to reach the last index.
    return ans;
  }
    //Time Complexity:
        //The algorithm iterates through the array once, making it a linear time complexity of O(n), where n is the length of the input array.

    //Space Complexity:
        //The algorithm uses a constant amount of space for the variables ('ans', 'end', 'farthest'), resulting in O(1) space complexity.
}