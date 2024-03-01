class Solution 
{
    public long maximumSumOfHeights(List<Integer> maxHeights) 
    {
        //Initialization:
        int n = maxHeights.size();
        Deque<Integer> stk = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        //Initializes variables and data structures:
        //'n' is the size of the input list 'maxHeights'.
        //'stk' is a stack (Deque) to store indices of heights.
        //'left' and 'right' are arrays to store the leftmost and rightmost indices where the height is smaller than the current height.

        //Calculate Leftmost Indices:
        for (int i = 0; i < n; ++i) 
        {
            int x = maxHeights.get(i);
            while (!stk.isEmpty() && maxHeights.get(stk.peek()) > x)
            {
                stk.pop();
            }
            if (!stk.isEmpty()) 
            {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        //Iterates through the heights from left to right.
        //Updates the 'left' array with the leftmost index where the height is smaller than the current height.
        //Uses a stack to maintain decreasing order of heights.

        //Calculate Rightmost Indices:
        stk.clear();
        for (int i = n - 1; i >= 0; --i) 
        {
            int x = maxHeights.get(i);
            while (!stk.isEmpty() && maxHeights.get(stk.peek()) >= x) 
            {
                stk.pop();
            }
            if (!stk.isEmpty()) 
            {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        //Clears the stack and iterates through the heights from right to left.
        //Updates the 'right' array with the rightmost index where the height is smaller than or equal to the current height.

        //Calculate Prefix Sums from Left and Right:
        long[] f = new long[n];
        long[] g = new long[n];
        for (int i = 0; i < n; ++i) 
        {
            int x = maxHeights.get(i);
            if (i > 0 && x >= maxHeights.get(i - 1)) 
            {
                f[i] = f[i - 1] + x;
            } 
            else 
            {
                int j = left[i];
                f[i] = 1L * x * (i - j) + (j >= 0 ? f[j] : 0);
            }
        }
        for (int i = n - 1; i >= 0; --i) 
        {
            int x = maxHeights.get(i);
            if (i < n - 1 && x >= maxHeights.get(i + 1)) 
            {
                g[i] = g[i + 1] + x;
            } 
            else 
            {
                int j = right[i];
                g[i] = 1L * x * (j - i) + (j < n ? g[j] : 0);
            }
        }
        //Calculates two prefix sum arrays 'f' and 'g' representing the cumulative sum of heights.
        //'f[i]' represents the sum of heights from the left up to index 'i'.
        //'g[i]' represents the sum of heights from the right starting from index 'i'.

        //Calculate Maximum Sum:
        long ans = 0;
        for (int i = 0; i < n; ++i) 
        {
            ans = Math.max(ans, f[i] + g[i] - maxHeights.get(i));
        }
        //Iterates through each index and calculates the sum of heights obtained by choosing that index as the starting point.
        //Updates the maximum sum ('ans') by considering both left and right movements and subtracting the height at the current index.
        return ans;
    }
}