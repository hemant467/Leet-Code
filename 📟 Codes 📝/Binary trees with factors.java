class Solution 
{
  public int numFactoredBinaryTrees(int[] arr) 
  {
    //Initialization:
    final int kMod = 1_000_000_007; //Modulo to prevent integer overflow.
    final int n = arr.length; //Get the length of the input array.
    // dp[i] := the number of binary trees with arr[i] as the root
    long[] dp = new long[n]; //Array to store the number of binary trees with each element as the root.
    Map<Integer, Integer> numToIndex = new HashMap<>(); //Map to store the index of each element in the array for quick lookup.

    Arrays.sort(arr); //Sort the input array in ascending order.
    //Dynamic Programming Approach:
    Arrays.fill(dp, 1); //Initialize the 'dp' array with 1, indicating each element itself can form one tree.

    for (int i = 0; i < n; ++i) //Fill the 'numToIndex' map for quick access to the index of each element.
      numToIndex.put(arr[i], i);

    //Calculate the Number of Binary Trees:
    //Nested Loops:

    for (int i = 0; i < n; ++i) // arr[i] is the root. Iterate over each element in the array, considering it as the root.
      for (int j = 0; j < i; ++j) //Iterate over the previous elements to check if 'arr[j]' can be a left subtree of arr[i].

      //Check If Valid Left Subtree:
        if (arr[i] % arr[j] == 0) //Check if arr[j] is a valid left subtree of arr[i]. arr[j] is the left subtree

        //Update dp Array:
        { 
          final int right = arr[i] / arr[j]; //Calculate the value of the right subtree.
          //Check if Right Subtree is Present:
          if (numToIndex.containsKey(right)) //If the right subtree is present in the array.
          {
            //Update dp Value:
            dp[i] += dp[j] * dp[numToIndex.get(right)]; //Update the number of binary trees with 'arr[i]' as the root.
            dp[i] %= kMod;
          }
        }
    //Return Result:
    return (int) (Arrays.stream(dp).sum() % kMod); //Sum up all the values in the 'dp' array and return the result modulo 'kMod'.
  }
}