/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    //Method Signature: The method 'averageOfSubtree' takes a 'TreeNode' as input and returns an 'int'. It initializes the 'ans' variable to 0.
  public int averageOfSubtree(TreeNode root) 
  {
    //DFS Function: The depth-first search (DFS) function 'dfs' is a recursive helper function that processes each node in the tree.
    
    //Main Function: The 'averageOfSubtree' function calls the DFS function and then returns the final value of 'ans'.
    dfs(root);
    return ans;
  }

  private int ans = 0;

  private Pair<Integer, Integer> dfs(TreeNode root) //The function returns a 'Pair<Integer, Integer>', where the first value is the sum of node values in the subtree rooted at 'root', and the second value is the count of nodes in that subtree.
  {
    //Base Case:
    if (root == null)
      return new Pair<>(0, 0); //If 'root' is 'null', it means the subtree is empty. In that case, the function returns a pair '(0, 0)'.

    //Recursive Calls: The function makes recursive calls to the left and right subtrees.
    Pair<Integer, Integer> left = dfs(root.left);
    Pair<Integer, Integer> right = dfs(root.right);

    //Calculate Sum and Count: The sum of the subtree rooted at 'root' is calculated by adding the value of the root, the sum of the left subtree ('left.getKey()'), and the sum of the right subtree ('right.getKey()'). The count is similarly calculated.
    final int sum = root.val + left.getKey() + right.getKey();
    final int count = 1 + left.getValue() + right.getValue();
    
    //Check Average and Update Answer: If the average value of the subtree ('sum / count') is equal to the value of the root ('root.val'), it means the subtree satisfies the condition. In this case, increment the 'ans' variable.
    if (sum / count == root.val)
      ++ans;
    
    //Return Pair: The function returns a new 'Pair' with the calculated sum and count for the current subtree.
    return new Pair<>(sum, count);
  }
}