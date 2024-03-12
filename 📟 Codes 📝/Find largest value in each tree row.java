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
  public List<Integer> largestValues(TreeNode root) 
  {
    //Check if the tree is empty:
    if (root == null) //If the root of the binary tree is 'null', return an empty list since there are no levels to process.
      return new ArrayList<>();

    //Initialize result list and a queue:
    List<Integer> ans = new ArrayList<>(); //This list will store the maximum value in each level.
    Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root)); //Initialize a queue with the root node.

    //Breadth-First Search (BFS) traversal:
    //Use a BFS traversal to process each level of the tree.
    while (!q.isEmpty()) //Continue the process until the queue is empty.
    {
      int max = Integer.MIN_VALUE; //Initialize a variable to track the maximum value in the current level.

      //Process nodes at the current level:
      for (int sz = q.size(); sz > 0; --sz) //Loop through all nodes at the current level.
      {
        TreeNode node = q.poll(); //Poll the front node from the queue.
        max = Math.max(max, node.val); //Update the maximum value if the current node's value is greater.

        //Enqueue the children of the current node:
        if (node.left != null)
          q.offer(node.left); //Enqueue the left child if it exists.

        if (node.right != null)
          q.offer(node.right); //Enqueue the right child if it exists.
      }
      //Add the maximum value to the result list:
      ans.add(max); //Add the maximum value found in the current level to the result list.
    }
    //Return the final result list:
    return ans; //The function returns a list containing the maximum values in each level of the binary tree.
  }
}