	class Solution 
    {
        //Method Signature:
	    public int removeDuplicates(int[] nums) 
        //The method 'removeDuplicates' takes an array of integers 'nums' and returns an integer representing the length of the modified array.
        {
            //Initialization:
	        int result = 1;
	        int len = nums.length;
            //Initializes a variable 'result' to 1, as the first element is always considered part of the modified array.
            //Initializes a variable 'len' to store the length of the input array.

            //Edge Case Check:
	        if(0 == len)    
            return 0;
            //Checks if the input array is empty. If true, returns 0, as there are no elements to remove.

            //Iterating through the Array:
	        int temp = nums[0];
	        for(int i = 1; i < len; i++)
            {
	            int cur = nums[i];
	            if(temp != cur)
                {
	                nums[result++] = cur;
	                temp = cur;
	            }
	        }
            //Initializes a variable 'temp' to store the value of the first element in the array.
            //Iterates through the array starting from the second element.
            //Compares the current element ('cur') with the previous element ('temp').
            //If the current element is different from the previous one, it is considered a non-duplicate, and it is placed in the modified array at the 'result' index.
            //The 'result' index is then incremented, and 'temp' is updated to the value of the current element.

	        return result;
	    }
	}