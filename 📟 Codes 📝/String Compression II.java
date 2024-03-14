class Solution 
{
  public int getLengthOfOptimalCompression(String s, int k) 
  //The `getLengthOfOptimalCompression` method initializes a 2D array `mem` to store the results of intermediate computations. Each element `mem[i][j]` represents the length of the optimal compression of the substring `s[i:]` with at most `j` deletions.
  {
    int[][] mem = new int[s.length()][k + 1];
    Arrays.stream(mem).forEach(A -> Arrays.fill(A, kMax));
    return compression(s, 0, k, mem);
    //The `compression` method recursively calculates the length of the optimal compression for a substring `s[i:]` with at most `k` deletions. It uses memoization to avoid redundant computations.
  }

  private static final int kMax = 101;

  // Returns the length of the optimal compression of s[i..n) with at most k
  // deletion.
  private int compression(final String s, int i, int k, int[][] mem) 
  {
    if (k < 0) //If `k` becomes negative or `i` reaches the end of the string or there are fewer characters left than the allowed deletions, it returns a large value (`kMax`).
      return kMax; //It returns a large value (`kMax`).
    if (i == s.length() || s.length() - i <= k) //Otherwise, it iterates through all possible substrings starting from index `i` and calculates the length of compression for each substring by considering all possible deletions.
      
      return 0;

    if (mem[i][k] != kMax) //It recursively calls itself to calculate the length of compression for the remaining substring after the deletion.

      return mem[i][k]; //It returns the minimum length of compression among all possible substrings.

    int maxFreq = 0;
    int[] count = new int[128];

    // Make letters in s[i..j] be the same.
    // Keep the letter that has the maximum frequency in this range and remove
    // the other letters.
    for (int j = i; j < s.length(); ++j) 
    {
      maxFreq = Math.max(maxFreq, ++count[s.charAt(j)]);
      mem[i][k] = Math.min( //
          mem[i][k],        //
          getLength(maxFreq) + compression(s, j + 1, k - (j - i + 1 - maxFreq), mem)); //The `getLength` method calculates the length of compression for a substring based on the maximum frequency of any character in that substring.
    }

    return mem[i][k];
  }

  // Returns the length to compress `maxFreq`.
  private int getLength(int maxFreq) //The `getLength` method calculates the length of compression for a substring based on the maximum frequency of any character in that substring.
  {
    if (maxFreq == 1) //If `maxFreq` is 1.
      return 1; //It returns 1 (indicating a single character 'c')
    if (maxFreq < 10) //If `maxFreq` is less than 10.
      return 2; //It returns 2 (indicating a single character followed by its count). [1-9]c
    if (maxFreq < 100) //If `maxFreq` is less than 100.
      return 3; //It returns 3 (indicating a two-digit count) [1-9][0-9]c.
    return 4;   //Otherwise, it returns 4 (indicating a three-digit count) [1-9][0-9][0-9]c
  }
  //The code efficiently computes the length of the optimal compression using dynamic programming and memoization, thereby improving the time complexity compared to a naive approach.
}