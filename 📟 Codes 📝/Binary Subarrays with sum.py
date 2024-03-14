#The below code uses a Python function `numSubarraysWithSum` that calculates the number of contiguous subarrays in the given list `nums` whose sum equals the specified `goal`.
class Solution:
    #Initialization
  def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
    ans = 0 #Initialize `ans` to store the total number of subarrays found with the sum equal to `goal`.
    prefix = 0 #Initialize `prefix` to keep track of the running sum of the subarray elements encountered so far.
    # {prefix: number of occurrence}
    count = collections.Counter({0: 1}) #Initialize a `Counter` named `count` to keep track of the occurrences of each prefix sum encountered. The initial value of the counter is `{0: 1}`, indicating that a prefix sum of 0 has been encountered once.

    #Iterating through the List
    for num in nums: #Iterate through each element `num` in the `nums` list.
      prefix += num #Update the `prefix` by adding the current element `num` to it.
      ans += count[prefix - goal] #Update `ans` by adding the count of subarrays whose sum equals `goal - prefix`. This count is obtained from the `count` dictionary.
      count[prefix] += 1 #Update the `count` dictionary by incrementing the count of the current `prefix`.

    #Return the Result :
    return ans #After iterating through all elements in `nums`, return the final value of `ans`, which represents the total number of subarrays found with the sum equal to `goal`.

    #The above approach works by maintaining a running sum (`prefix`) of the elements encountered so far and keeping track of the count of each encountered prefix sum in the `count` dictionary. By leveraging prefix sums, it efficiently determines the number of subarrays with the desired sum without the need for nested loops. The time complexity of this solution is O(n), where n is the length of the `nums` list.