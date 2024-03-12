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
  public int[] findMode(TreeNode root) 
  {
    // List to store the mode(s).
    List<Integer> ans = new ArrayList<>();
    // count[0] := currCount
    // count[1] := maxCount
    int[] count = new int[2];

    inorder(root, count, ans);
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }

  private TreeNode pred = null;

    //Inorder Helper Method:
  private void inorder(TreeNode root, int[] count, List<Integer> ans) //The 'inorder' method is a recursive function that traverses the BST in an inorder fashion. It calls the 'updateCount' method for each node.
  {
    if (root == null)
      return;

    inorder(root.left, count, ans);
    updateCount(root, count, ans);
    inorder(root.right, count, ans);
  }

    //Update Count Method:
  private void updateCount(TreeNode root, int[] count, List<Integer> ans) 
  {
    if (pred != null && pred.val == root.val)
      ++count[0];
    else
      count[0] = 1;
      //The 'updateCount' method updates the count based on the current node's value. It checks if the current node has the same value as the predecessor. If yes, it increments the current count ('count[0]'); otherwise, it resets the count to 1.

    if (count[0] > count[1]) 
    {
      count[1] = count[0];
      ans.clear();
      ans.add(root.val);
      //It then compares the current count with the maximum count ('count[1]'). If the current count is greater, it updates the maximum count and clears the mode list ('ans'). If the counts are equal, it simply adds the current value to the mode list.
    } 
    //Finally, it updates the predecessor to the current node.
    else if (count[0] == count[1]) 
    //Result:
    {
      ans.add(root.val); //The mode(s) are stored in the 'ans' list, which is then converted to an array and returned.
    }

    pred = root;
  }
}