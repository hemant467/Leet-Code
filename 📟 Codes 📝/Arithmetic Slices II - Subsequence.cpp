//The below C++ code aims to find the number of arithmetic slices in a given vector of integers `nums`.
class Solution 
{
 public:
  int numberOfArithmeticSlices(vector<int>& nums) 
  {
    //Defining variables:
    const int n = nums.size(); //The size of the input vector `nums`.
    int ans = 0; //The variable to store the final result, initialized to 0.
    // dp[i][j] := the number of subsequences end in nums[j] nums[i]
    vector<vector<int>> dp(n, vector<int>(n)); //A 2D vector to store the number of subsequences ending at `nums[j]` and `nums[i]`.
    unordered_map<long, vector<int>> numToIndices; //An unordered map that maps each number in the input vector to its indices.

    for (int i = 0; i < n; ++i)
      numToIndices[nums[i]].push_back(i); //It populates the `numToIndices` map by iterating over the input vector `nums` and storing the indices of each number.

    for (int i = 0; i < n; ++i)
      for (int j = 0; j < i; ++j) 
      //It then iterates over each pair of indices `(i, j)` in the range `[0, n)` where `i` is greater than `j`.
      //For each pair `(i, j)`, it calculates the target value `target` which represents the missing term in an arithmetic sequence formed by `nums[j]` and `nums[i]`. The formula used to calculate `target` is `nums[j] * 2L - nums[i]`. Here, `2L` ensures that the arithmetic operation is performed as a long integer to avoid integer overflow.

      {
        const long target = nums[j] * 2L - nums[i];
        if (const auto it = numToIndices.find(target); //It checks if `target` exists in the `numToIndices` map. If it does, it means there is a valid arithmetic subsequence.
            it != numToIndices.cend())
          for (const int k : it->second)
            if (k < j)
              dp[i][j] += (dp[j][k] + 1); //For each index `k` in the list of indices corresponding to `target`, if `k` is less than `j`, it increments `dp[i][j]` by `(dp[j][k] + 1)`. This effectively counts the number of arithmetic slices ending at `nums[j]` and `nums[i]`.
        ans += dp[i][j]; //Finally, it updates the total count of arithmetic slices by adding the value of `dp[i][j]` to `ans`.
      }

    return ans; //After completing the iteration, it returns the final count stored in `ans`, representing the total number of arithmetic slices in the input vector `nums`.
  }
  //The above code efficiently utilizes dynamic programming and hashing to count the number of arithmetic slices in the given vector of integers.
};