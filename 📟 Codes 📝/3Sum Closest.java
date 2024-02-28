public class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        //Check for Empty Input Array:
        if (nums.length == 0){
            return 0;
        //If the input array 'nums' is empty, there are no integers to consider, so the method returns 0.
        }
        
        //Sort the Array:
        Arrays.sort(nums);
        //The input array nums is sorted in ascending order. Sorting is crucial for the approach that involves searching for the closest sum using two pointers.

        //Initialize Variables:
        int min = Integer.MAX_VALUE;
        int closed = 0;
        //'min' is initialized to 'Integer.MAX_VALUE' to keep track of the minimum difference between the sum and the target.
        //'closed' is initialized to 0, and it will be updated to the closest sum found during the process.

        //Iterate through the Array:
        for (int i = 0; i < nums.length; i ++)
        //The code uses a loop to iterate through each element of the array.
        {
            //Skip Duplicates:
            if (i == 0 || nums[i] != nums[i-1])
            //This condition ensures that duplicates are skipped. If 'i' is 0 or the current element is different from the previous one, it proceeds with finding the closest sum.
            {
                //Initialize Two Pointers:
                int start = i + 1;
                int end = nums.length - 1;
                //Two pointers, 'start' and 'end', are initialized to search for the remaining two elements in the triplet.

                //Two-Pointer Approach:
                while (start < end){
                    int sum = nums[i] + nums[start] + nums[end];
                    if (Math.abs(sum - target) < min){
                        min = Math.abs(sum - target);
                        closed = sum;
                    }
                    if (sum < target){ 
                        start ++; } 
                    else{ // >= target
                        end --;
                    //The code enters a while loop to find triplets.
                    //It calculates the sum of the current triplet and checks if the absolute difference between the sum and the target is less than the current minimum difference (min).
                    //If so, it updates both the minimum difference and the closest sum (closed).
                    //The two-pointer approach then adjusts the pointers based on whether the current sum is less than or equal to the target.

                    }//if
                }//while
             }//if
        }//for
        return closed;
    }
}