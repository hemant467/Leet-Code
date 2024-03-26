//The below code is an implementation of a function to find the maximum product of two elements in an array.
class Solution 
{
  public int maxProduct(int[] nums) 
  {
    //Initialize two variables `max1` and `max2` to store the two largest elements found so far.
    int max1 = 0;
    int max2 = 0;
    //Initially, both are set to 0.

    for (final int num : nums) //Iterate through the elements of the array `nums`.
      if (num > max1) //For each element `num` in `nums`, check if `num` is greater than `max1`.
      {
        max2 = max1; //Update `max2` to the current value of `max1`
        max1 = num; //Update `max1` to `num`.
      } 
      else if (num > max2) //If `num` is not greater than `max1`, check if it is greater than `max2`.
      {
        max2 = num; //If it is, update `max2` to `num`.
      }
      //After iterating through all elements in `nums`, `max1` and `max2` will contain the two largest elements in the array.

    return (max1 - 1) * (max2 - 1); //Calculate and return the maximum product of two elements by subtracting 1 from each of the largest elements (`max1 - 1` and `max2 - 1`) and multiplying them together.
  }
  //The above code is based on finding the two largest elements in the array and then calculating their product. 
  //It assumes that the input array contains at least two elements. If the array contains fewer than two elements, the result will be incorrect. 
  //Additionally, if the elements in the array are negative, the product may not represent the maximum possible product of two elements.

    //Time Complexity : O(n)
    //Space Complexity : O(1)
}