//to find the maximum possible element in an array after performing two operations:

//1. **Decrementing:** Any element in the array can be decremented by 1.
//2. **Rearranging:**  The array can be rearranged in any order.

class Solution 
{
  public int maximumElementAfterDecrementingAndRearranging(int[] arr) 
  {
    //Sorting the Array:
    Arrays.sort(arr); //The input array `arr` is sorted in ascending order using `Arrays.sort(arr)`.
    //Sorting the array allows us to easily increment elements in the subsequent steps while ensuring that each element is not greater than its predecessor.
    
    //Setting the First Element to 1:
    arr[0] = 1; //After sorting, the first element of the array is set to 1 (`arr[0] = 1`).
    //This step ensures that the first element of the sorted array is 1, as it will be the minimum value after decrementing.

    //Iterating Over the Array: Starting from the second element (index 1) to the end of the array, the code iterates through each element.
    
    //Ensuring Non-decreasing Sequence:
    for (int i = 1; i < arr.length; ++i)
    //For each element `arr[i]`, the code ensures that it is not greater than the previous element plus 1.

      arr[i] = Math.min(arr[i], arr[i - 1] + 1); ////This step guarantees that each element in the array can be decremented to match or be one greater than the previous element.

    //Returning the Maximum Element:
    return arr[arr.length - 1]; //Finally, the code returns the maximum element in the array, which is the last element after all the operations have been performed.
  }
    //Overall, the above code efficiently finds the maximum element in the array after decrementing and rearranging, ensuring that the array is sorted and each element is non-decreasing by at most one compared to its previous element.

  //Time: O(sort)
  //Space: O(sort)
}