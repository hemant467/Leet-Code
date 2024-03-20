#The below code calculates the sum of absolute differences for each element in the array `nums`.
class Solution:
  def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
    
    #Prefix and Suffix Sum Arrays :
    prefix = list(itertools.accumulate(nums)) #`prefix`: This list contains the cumulative sum of elements from the beginning of the array `nums`.

    suffix = list(itertools.accumulate(nums[::-1]))[::-1] #`suffix`: This list contains the cumulative sum of elements from the end of the array `nums`. To achieve this, the code first reverses the array `nums`, calculates the cumulative sum, and then reverses it back to maintain the original order.

    #Calculate Sum of Absolute Differences : For each element `num` in the array `nums`, the code calculates the sum of absolute differences using the formula:
    return [num * (i + 1) - prefix[i] + suffix[i] - num * (len(nums) - i)

    #`num * (i + 1)`: This part calculates the sum of all absolute differences from `num` to the left of the array up to the `i`-th index.
    #`prefix[i]`: This part subtracts the cumulative sum up to the `i`-th index, representing the sum of elements to the left of `num`.
    #`suffix[i]`: This part subtracts the cumulative sum up to the `i`-th index from the end of the array, representing the sum of elements to the right of `num`.
    #`num * (len(nums) - i)`: This part calculates the sum of all absolute differences from `num` to the right of the array starting from the `i`-th index.

    #Return Result: The calculated sum of absolute differences for each element is returned as a list.
            for i, num in enumerate(nums)]
    
    #Time Complexity : O(n)
    #Space Complexity : O(n)
        
    #The above code efficiently calculates the sum of absolute differences for each element in the array `nums` by utilizing prefix and suffix sum arrays. This approach reduces the time complexity to O(n) where n is the length of the array `nums`.