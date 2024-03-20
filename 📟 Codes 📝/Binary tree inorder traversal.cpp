//The below code implements an iterative solution to perform an inorder traversal of a binary tree.

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution 
{
 public:
  vector<int> inorderTraversal(TreeNode* root) //It defines a function `inorderTraversal` that takes a pointer to the root of the binary tree as input and returns a vector containing the inorder traversal of the tree.
  
    {
    //Inside the function:
    vector<int> ans; //It initializes an empty vector `ans` to store the traversal result
    stack<TreeNode*> stack; //It initializes a stack `stack` to perform iterative traversal.

    //It enters a loop that continues until either the current node (`root`) becomes `NULL` and the stack becomes empty.
    while (root || !stack.empty()) 
    //Inside the loop:
    {
      while (root) 
      {
        stack.push(root);
        root = root->left;
        //It traverses the left subtree of the current node (`root`) and pushes each node encountered onto the stack until there are no more left children. This step simulates the process of traversing all left children recursively.

      }
      //Once all left children are pushed onto the stack, it retrieves the top node from the stack (which is the leftmost node that has not been visited yet), pops it from the stack, and adds its value to the `ans` vector.

      root = stack.top(), stack.pop();
      ans.push_back(root->val);
      root = root->right;
      //It then moves to the right subtree of the current node by updating `root` to the right child of the popped node. If the right child exists, the process will continue with its left subtree in the next iteration of the loop.
    }

    //Return:
    return ans; //Finally, once the loop finishes, it returns the `ans` vector containing the inorder traversal of the binary tree.
  }
    //Time Complexity : O(n)
    //Space Complexity : O(n)

    //The above code efficiently performs an inorder traversal of the binary tree using an iterative approach with a stack. It avoids recursion and utilizes the stack to keep track of the nodes that need to be visited, mimicking the process of recursive traversal.
};