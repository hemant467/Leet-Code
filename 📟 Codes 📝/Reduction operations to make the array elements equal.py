#The below python function calculates the total number of reduction operations needed to make all elements in the list `nums` equal.

class Solution:
    #Initialization:
  def reductionOperations(self, nums: List[int]) -> int:
    ans = 0 #Initialize the variable `ans` to store the total number of reduction operations needed.

    #Sorting:
    nums.sort() #Sort the list `nums` in non-decreasing order. Sorting the list simplifies the counting process as identical numbers will be grouped together.

    #Counting Reduction Operations:
    for i in range(len(nums) - 1, 0, -1): #Iterate over the sorted list `nums` from right to left (from the end to the beginning) using the indices `i` in reverse order.
      if nums[i] != nums[i - 1]: #At each iteration, compare the current element `nums[i]` with its previous element `nums[i - 1]`.
    #If the current element `nums[i]` is different from the previous element `nums[i - 1]`, it means we need to perform reduction operations to make them equal.
    #The number of reduction operations needed to make `nums[i]` equal to `nums[i - 1]` is equal to the number of elements from index `i` to the end of the list `nums`, which is `len(nums) - i`.
        
        ans += len(nums) - i #Add this count to the variable `ans`.

    #Return the Result:
    return ans
    #After iterating through all elements, return the total number of reduction operations stored in the variable `ans`.

#Time Complexity : O(sort)
#Space Complexity : O(sort)

    #The above code efficiently counts the number of reduction operations required to make all elements in the list `nums` equal by sorting the list and then counting the number of elements that need to be reduced at each step. Sorting the list simplifies the counting process and allows us to perform the counting in a single pass through the list.