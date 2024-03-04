class Solution 
{
  public int minOperations(int[] nums) 
  {
    //Variables and Constants:
    //'n': The length of the input array 'nums'.
    //'ans': The variable to store the minimum number of operations needed. Initialized with the length of the array.
    final int n = nums.length;
    int ans = n;

    //Sorting and Removing Duplicates:
    Arrays.sort(nums); 
    //The array nums is sorted in ascending order using Arrays.sort(nums).
    //Duplicate elements are removed using Arrays.stream(nums).distinct().toArray().
    //Iterating Over Unique Subarrays:
    nums = Arrays.stream(nums).distinct().toArray();
    //The code iterates over each unique element in the sorted array.

    for (int i = 0; i < nums.length; ++i) 
    {
      final int start = nums[i];//For each unique element, it considers a subarray of length 'n' starting from that element.
      final int end = start + n - 1;//It calculates the end value of the subarray.
      final int index = firstGreater(nums, end);//It finds the index of the first element greater than this end value using binary search.

      //Calculating Unique Subarray Length:
      final int uniqueLength = index - i;//The length of the unique subarray is calculated as the difference between the index of the first greater element and the current index.

      //Updating Minimum Operations:
      ans = Math.min(ans, n - uniqueLength);//The minimum number of operations needed is updated based on the length of the unique subarray.
    }

    return ans;
  }

  private int firstGreater(int[] A, int target) 
  {
    final int i = Arrays.binarySearch(A, target + 1);
    return i < 0 ? -i - 1 : i;
  }
}