#The below Python code aims to find the number of submatrices within the given matrix `matrix` that sum up to the target value `target`.
class Solution:
  def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
    #Get the dimensions of the matrix `matrix`:
    m = len(matrix) #`m` represents the number of rows.
    n = len(matrix[0]) #`n` represents the number of columns.
    ans = 0 #Initialize a variable `ans` to store the number of submatrices found.

    # Transfer each row in the matrix to the prefix sum.
    #Compute prefix sums for each row in the matrix:
    for row in matrix: #Iterate over each row in the matrix.
      for i in range(1, n): #For each row, iterate over the columns starting from index 1.
        row[i] += row[i - 1] #Update each element in the row by adding the value of the previous column.
        #After this step, each element in the row will represent the prefix sum up to that column.

    #Iterate over each column pair `(baseCol, j)`:
    for baseCol in range(n): #`baseCol` represents the base column index, and `j` represents the current column index.
      for j in range(baseCol, n):
        prefixCount = collections.Counter({0: 1}) #Initialize a Counter `prefixCount` to store the prefix sum frequencies.
        summ = 0 #Initialize a variable `summ` to keep track of the sum of elements in the current submatrix.

        #Iterate over each row `i`:
        for i in range(m):
          if baseCol > 0: #If `baseCol > 0`
            summ -= matrix[i][baseCol - 1] #subtract the value of the element at column `baseCol - 1` from `summ`.
          summ += matrix[i][j] #Add the value of the element at column `j` to `summ`.
          ans += prefixCount[summ - target] #Update the `ans` by adding the count of submatrices with sum equal to `target - summ` from the `prefixCount`.
          prefixCount[summ] += 1 #Increment the count of prefix sum `summ` in `prefixCount`.

    #Return the final value:
    return ans #Return the final value of `ans`, which represents the number of submatrices with the target sum.

    #The above code effectively utilizes prefix sums and the Counter data structure to efficiently compute the number of submatrices with the target sum.