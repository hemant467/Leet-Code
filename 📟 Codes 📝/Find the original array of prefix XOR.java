class Solution 
{
  public int[] findArray(int[] pref) 
  {
    int[] ans = new int[pref.length]; //Create an array 'ans' to store the result. The length of this array is the same as the input 'pref' array.

    //Calculating the Resulting Array:
    ans[0] = pref[0]; //Initialize the first element of the 'ans' array with the corresponding element from the 'pref' array.
    for (int i = 1; i < ans.length; ++i) //Iterate through the elements of the 'ans' array starting from the second element.
      ans[i] = pref[i] ^ pref[i - 1]; //Calculate each subsequent element of the 'ans' array using the XOR ('^') operation between the current element of the 'pref' array and the previous element of the 'pref' array. This operation effectively finds the original array based on the given prefix.

    //Return Result:
    return ans; //Return the resulting array.
  }
  //Using 'XOR' to reverse the process of generating the prefix array. If 'pref' is a prefix array generated from an array 'arr', applying XOR operations as described in the code will reconstruct the original array 'arr'.
}