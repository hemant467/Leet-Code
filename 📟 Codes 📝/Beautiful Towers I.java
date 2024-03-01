class Solution 
{
    //Method Signature:
    public long maximumSumOfHeights(List<Integer> maxHeights) 
    //The method 'maximumSumOfHeights' takes a list of integers 'maxHeights' as input and returns a long representing the maximum sum of heights that can be obtained by choosing a starting point and moving left and right while minimizing the height at each step.
    {
        //Initialization:
        long ans = 0;
        int n = maxHeights.size();
        //Initializes a variable 'ans' to store the maximum sum of heights.
        //Obtains the size of the input list as 'n'.

        //Iterative Calculation of Maximum Sum:
        for (int i = 0; i < n; ++i) 
        {
            int y = maxHeights.get(i);
            long t = y;
            //Initiates a loop to iterate through each possible starting point ('i').
            //Initializes 'y' to the height at the current starting point.
            //Initializes 't' to the height at the current starting point ('y'). This variable will store the sum of heights.

            //Move Left and Update Sum:
            for (int j = i - 1; j >= 0; --j) 
            {
                y = Math.min(y, maxHeights.get(j));
                t += y;
            }
            //Initiates a loop to move left from the starting point ('i') and update the sum.
            //Updates 'y' to be the minimum of the current 'y' and the height at the left position ('j').
            //Adds the updated 'y' to the sum 't'.

            //Move Right and Update Sum:
            y = maxHeights.get(i);
            for (int j = i + 1; j < n; ++j) 
            {
                y = Math.min(y, maxHeights.get(j));
                t += y;
            }
            //Resets 'y' to the height at the current starting point ('i').
            //Initiates a loop to move right from the starting point ('i') and update the sum.
            //Updates y to be the minimum of the current 'y' and the height at the right position ('j').
            //Adds the updated 'y' to the sum 't'.

            //Update Maximum Sum:
            ans = Math.max(ans, t);
            //Updates the maximum sum ('ans') by taking the maximum of the current maximum and the sum 't' calculated for the current starting point.
        }
        return ans;
    }
}