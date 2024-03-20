//The below C++ function `findDiagonalOrder` takes a 2D vector `nums` as input, representing a matrix of integers, and returns a vector containing the elements of the matrix in diagonal order.
class Solution 
{
 public:
  vector<int> findDiagonalOrder(vector<vector<int>>& nums) 
  {
    //Initialization:
    vector<int> ans; //It initializes an empty vector `ans` to store the elements in diagonal order.
    unordered_map<int, vector<int>> keyToNums;  // key := row + column. It creates an unordered map `keyToNums` to map the sum of row and column indices to the corresponding numbers in the matrix. This mapping is used to group elements that fall on the same diagonal.
    int maxKey = 0; //It initializes a variable `maxKey` to keep track of the maximum key value encountered.

    //Populating the Map: 
    for (int i = 0; i < nums.size(); ++i)
      for (int j = 0; j < nums[i].size(); ++j)
      //It iterates through each element in the input matrix `nums` using nested loops. 
      {
        const int key = i + j;
        keyToNums[key].push_back(nums[i][j]); //For each element at position `(i, j)`, it calculates the key as the sum of `i` and `j` and stores the element in the corresponding entry in the `keyToNums` map.
        maxKey = max(maxKey, key); //It updates the `maxKey` to ensure that it covers all possible diagonal keys.
      }

    //Constructing the Diagonal Order:
    for (int i = 0; i <= maxKey; ++i) //It iterates through keys from `0` to `maxKey`.
    //For each key, it iterates through the corresponding vector of numbers in reverse order (using reverse iterators).
      for (auto it = keyToNums[i].rbegin(); it != keyToNums[i].rend(); ++it)
        ans.push_back(*it); //It appends each number to the `ans` vector, effectively traversing each diagonal in reverse order.

    //Return Result:
    return ans; //Finally, it returns the `ans` vector containing the elements of the matrix in diagonal order.
  }
  //the above code efficiently constructs the diagonal order of the matrix by grouping elements based on their diagonal positions and traversing these groups in reverse order to achieve the desired diagonal traversal.
};