class Solution 
{
    //Method Signature:
  public int trap(int[] height) 
  {
    //Initialization:
    final int n = height.length; //Get the length of the 'height' array.
    int ans = 0; //Initialize the variable to store the total trapped water.
    int[] l = new int[n]; // l[i] := max(height[0..i])
    int[] r = new int[n]; // r[i] := max(height[i..n))

    //Compute Left Maximum Heights (l array):
    for (int i = 0; i < n; ++i) 
    //Initialize an array 'l' to store the maximum height to the left of each bar.
      l[i] = i == 0 ? height[i] : Math.max(height[i], l[i - 1]);
      //For each index 'i' from left to right:
        //'l[i] = i == 0 ? height[i] : Math.max(height[i], l[i - 1]);'
        //'l[i]' represents the maximum height to the left of the bar at index 'i'.

    //Compute Right Maximum Heights (r array):
    //Initialize an array 'r' to store the maximum height to the right of each bar.
    for (int i = n - 1; i >= 0; --i)
      r[i] = i == n - 1 ? height[i] : Math.max(height[i], r[i + 1]);
      //For each index 'i' from right to left:
        //'r[i] = i == n - 1 ? height[i] : Math.max(height[i], r[i + 1]);'
        //'r[i]' represents the maximum height to the right of the bar at index 'i'.


    //Calculate Trapped Water:
    //For each index 'i':
    for (int i = 0; i < n; ++i)
      ans += Math.min(l[i], r[i]) - height[i];
      //'ans += Math.min(l[i], r[i]) - height[i];'
      //'Math.min(l[i], r[i])' represents the maximum height of the surrounding bars.
      //Subtract 'height[i]' to get the height difference for the current bar.
      //Add the result to the total trapped water.

    //Return the Result:
    return ans; //Return the total trapped water.
  }
  //Time Complexity:
    //The algorithm iterates through the 'height' array three times, each time taking linear time.
    //The time complexity is O(n).

  //Space Complexity:
    //The algorithm uses two auxiliary arrays, 'l' and 'r', to store the maximum heights.
    //The space complexity is O(n) due to the additional arrays.

}