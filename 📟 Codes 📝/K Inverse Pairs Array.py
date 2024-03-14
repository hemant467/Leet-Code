#The below Python code calculates the number of permutations of numbers from 1 to `n` with exactly `k` inverse pairs.
class Solution:
  def kInversePairs(self, n: int, k: int) -> int:
    kMod = 1_000_000_007

    #Define a 2D list `dp` to store the number of permutations of numbers from 1 to `i` with `j` inverse pairs.
    # dp[i][j] := the number of permutations of numbers 1..i with j inverse pairs
    dp = [[0] * (k + 1) for _ in range(n + 1)]

    # If there's no inverse pair, the permutation is unique '123..i'
    for i in range(n + 1):
      dp[i][0] = 1 #Initialize `dp[i][0]` to 1 for all `i` from 0 to `n`. This is because if there are no inverse pairs (`j = 0`), there is only one unique permutation for each `i` from 0 to `n`, which is the ascending order permutation `1, 2, ..., i`.

    #Iterate over each `i` from 1 to `n`, and for each `i`, iterate over each `j` from 1 to `k`:
    for i in range(1, n + 1):
      for j in range(1, k + 1):
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % kMod #Update `dp[i][j]` by adding `dp[i][j - 1]` and `dp[i - 1][j]`. This represents the permutations that have the same number of inverse pairs as the previous permutation plus one more element (`dp[i][j - 1]`) and the permutations that have one fewer element but the same number of inverse pairs (`dp[i - 1][j]`).
        if j - i >= 0:
          dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + kMod) % kMod #Subtract `dp[i - 1][j - i]` from `dp[i][j]` if `j - i >= 0`. This is because if `j - i >= 0`, it means that adding `i` to the permutation will introduce `i` more inverse pairs, so we need to subtract the count of permutations with `j - i` inverse pairs.

    return dp[n][k] #Return `dp[n][k]`, which represents the number of permutations of numbers from 1 to `n` with exactly `k` inverse pairs.

#The above dynamic programming approach efficiently computes the number of permutations with a specific number of inverse pairs using tabulation.