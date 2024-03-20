#The below code defines a function `largestGoodInteger` that takes a string `num` as input and returns the largest substring of length 3 in `num` where all digits are the same.
class Solution:
  def largestGoodInteger(self, num: str) -> str:
    #Iterating Over the String: The code iterates over the indices of the string `num` starting from index 2 (since we need to check substrings of length 3).
    
    #Checking Substrings:
    return max(num[i - 2:i + 1] #For each index `i`, it checks if the digit at index `i` is equal to the digits at indices `i - 1` and `i - 2`.
               if num[i] == num[i - 1] == num[i - 2] #If they are equal, it forms a substring of length 3 where all digits are the same.
               #It does this check using an inline if-else statement. If the condition is true (i.e., `num[i] == num[i - 1] == num[i - 2]`), it returns the substring `num[i - 2:i + 1]`.
               else '' for i in range(2, len(num))) #Otherwise, it returns an empty string `''`.

#Time Complexity : O(n)
#Space Complexity : O(1)

#The code efficiently finds the largest substring of length 3 where all digits are the same in the given input string `num`. If no such substring exists, it returns an empty string.