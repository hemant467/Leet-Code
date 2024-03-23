//The given code aims to compute the transpose of a given matrix represented by a 2D vector `A`. The transpose of a matrix is obtained by swapping its rows and columns.
class Solution 
{
 public:
  vector<vector<int>> transpose(vector<vector<int>>& A) //It defines a method `transpose` that takes a 2D vector `A` representing the matrix as input and returns another 2D vector representing the transpose of the matrix.
  {
    //Inside the `transpose` method:
    vector<vector<int>> ans(A[0].size(), vector<int>(A.size())); //It initializes a new 2D vector `ans` with dimensions swapped from `A`. The number of rows in `A` becomes the number of columns in `ans`, and vice versa. This is because the transpose of an `m x n` matrix is an `n x m` matrix.

    //It iterates over each element of the input matrix `A` using nested loops:
    //The outer loop iterates over the rows of `A`, and the inner loop iterates over the columns of `A`.
    for (int i = 0; i < A.size(); ++i)
      for (int j = 0; j < A[0].size(); ++j)
        ans[j][i] = A[i][j]; //Assigning the value of `A[i][j]` to `ans[j][i]`.

        //For each element at position `(i, j)` in `A`, it assigns the value of `A[i][j]` to `ans[j][i]`. This effectively transposes the matrix, swapping rows and columns.

    //Return ans:
    return ans; //Once all elements have been processed, it returns the transposed matrix `ans`.
  }
  //The above code efficiently computes the transpose of a given matrix by swapping rows and columns. It achieves this by iterating over each element of the input matrix and assigning it to the corresponding position in the transposed matrix.
};