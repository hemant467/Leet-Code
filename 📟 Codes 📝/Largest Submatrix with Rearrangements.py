#The below code finds the size of the largest submatrix containing only 1s within the given matrix.
class Solution:
    #Initialization : Initialize `ans` to store the maximum area of the largest submatrix. Initialize `hist` as a list of zeros with the length equal to the number of columns in the matrix. This list will represent the height of the histogram for each column.
  def largestSubmatrix(self, matrix: List[List[int]]) -> int:
    ans = 0
    hist = [0] * len(matrix[0])

    #Iterating Through Rows:
    for row in matrix:
      # Accumulate the histogram if possible.
      for i, num in enumerate(row): #Iterate through each row in the matrix
        hist[i] = 0 if num == 0 else hist[i] + 1 #For each element in the row, update the corresponding element in the `hist` list. If the element in the matrix is 0, set the height in the histogram to 0. Otherwise, increment the height in the histogram by 1.

    #Sorting and Calculating Area:
        #For each row in the matrix, sort the `hist` list in non-decreasing order.
        #Then, iterate through the sorted histogram and calculate the area of the largest submatrix. The width of the submatrix is given by `len(row) - i` where `i` is the index in the sorted histogram, and the height of the submatrix is given by the histogram value `h`.

      # Get the sorted histogram.
      sortedHist = sorted(hist)

      # Greedily calculate the answer.
      for i, h in enumerate(sortedHist):
        ans = max(ans, h * (len(row) - i))

    #Return Maximum Area: Finally, return the maximum area `ans`.
    return ans

    #Time Complexity : O(mn log n)
    #Space Complexity : O(n)

#The above code efficiently iterates through the matrix and maintains a histogram of heights for each column. By sorting the histogram and calculating the area of the largest submatrix for each row, it finds the maximum area of the largest submatrix containing only 1s. This approach has a time complexity of O(m * n * log(n)), where m is the number of rows and n is the number of columns in the matrix.