class Solution:
  def hammingWeight(self, n: int) -> int:
    return bin(n).count('1')
#Time Complexity : O(1)
#Space Complexity : O(1)