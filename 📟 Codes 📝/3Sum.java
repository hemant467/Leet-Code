public class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        //Initialize Result List and Sort the Array:
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        //A result list is initialized to store the triplets.
        //The input array nums is sorted in ascending order. Sorting is a crucial step for the two-pointer approach.

        //Iterate through the Array:
        for (int i = 0; i < nums.length; i++)
        //The code uses a loop to iterate through each element of the array.
         {
             //Skip Duplicates:
            if (i == 0 || nums[i] != nums[i-1])
            //This condition ensures that duplicates are skipped. If 'i' is 0 or the current element is different from the previous one, it proceeds with finding triplets. This helps avoid duplicate triplets in the result.
             {
                 //Initialize Two Pointers:
                int start = i + 1, end = nums.length - 1;
                //Two pointers, 'start' and 'end', are initialized to search for the remaining two elements in the triplet.

                //Two-Pointer Approach:
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0){
                        List<Integer> tmp = new LinkedList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        result.add(tmp);

                        //Move Pointers to Skip Duplicates:
                        int startVal = nums[start];
                        int endVal = nums[end];
                        while (start < end && startVal == nums[start]) {
                            start ++;
                        }
                        while (end > start && endVal == nums[end]) {
                            end --;
                        }
                        //These loops move the pointers to skip duplicate elements, ensuring that the same triplet is not added to the result multiple times.
                    }
                    else if (sum < 0) {
                        start ++;
                    }
                    else {
                        end --;
                    }
                }
            }
        }
        return result;
    }

}