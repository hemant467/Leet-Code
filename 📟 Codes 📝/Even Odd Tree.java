class Solution 
{
    //Method Signature:
  public boolean isEvenOddTree(TreeNode root) 
  //The method 'isEvenOddTree' takes the root of a binary tree as input and returns a boolean indicating whether the tree is an even-odd tree.
  {
    //Queue Initialization:
    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));
    //Initializes a queue ('q') with the root of the tree. The queue is used for level-order traversal.

    //Iteration through Levels:
    boolean isEven = true;

    for (; !q.isEmpty(); isEven = !isEven)
    //Initializes a boolean variable 'isEven' to 'true'. This variable is used to determine whether the current level should be even or odd.
    //Uses a 'for' loop to iterate through the levels of the tree.

     {
         //Checking Validity of Values in the Level:
      int prevVal = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      for (int sz = q.size(); sz > 0; --sz) {
        TreeNode node = q.poll();
        if (isEven && (node.val % 2 == 0 || node.val <= prevVal))
          return false; // invalid case on even level
        if (!isEven && (node.val % 2 == 1 || node.val >= prevVal))
          return false; // invalid case on odd level
        prevVal = node.val;
        if (node.left != null)
          q.offer(node.left);
        if (node.right != null)
          q.offer(node.right);
      }
      //Initializes 'prevVal' to either 'Integer.MIN_VALUE' or 'Integer.MAX_VALUE' based on whether the level is even or odd.
    //Uses another 'for' loop to iterate through the nodes at the current level.
    //Checks whether the values of the nodes are valid based on the rules for even and odd levels. If not, returns 'false'.
    //Updates 'prevVal' to the value of the current node.
    //Enqueues the left and right children of the current node into the queue.
    }

    return true;
    //Returns 'true' if the traversal completes without encountering any invalid cases.
  }
}