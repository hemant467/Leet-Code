//The given below code is designed to validate whether a given set of nodes and their edges represent a valid binary tree. It performs this validation by checking the following conditions:
class Solution 
{
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    //In-Degree Check:
    int[] inDegrees = new int[n];//It maintains an array 'inDegrees' to store the in-degrees of each node.
    //For each child in both the 'leftChild' and 'rightChild' arrays, it increments the in-degree of the child.
    //If at any point the in-degree of a node becomes greater than 1, it indicates that there are multiple incoming edges to the node, and the function returns 'false'.
    int root = -1;

    // If the in-degree of any node > 1, return false.
    for (final int child : leftChild)
      if (child != -1 && ++inDegrees[child] == 2)
        return false;

    for (final int child : rightChild)
      if (child != -1 && ++inDegrees[child] == 2)
        return false;

    //Root Identification:
    //It iterates through the in-degrees array to identify the root of the binary tree.
    //If a node has an in-degree of 0, it could potentially be a root candidate.
    //If there is no root found or if there are multiple nodes with in-degree 0, it returns 'false' as there should be exactly one root in a binary tree.

    // Find the root (the node with in-degree == 0).
    for (int i = 0; i < n; ++i)
      if (inDegrees[i] == 0)
        if (root == -1)
          root = i;
        else
          return false; // There're multiple roots.

    //DFS Count Nodes:
    //It uses a recursive depth-first search (DFS) function 'countNodes' to count the total number of nodes in the binary tree starting from the identified root.
    //The 'countNodes' function recursively explores the left and right children of each node and increments the count.

    // Didn't find the root.
    //Node Count Validation:
    //It checks whether the total number of nodes counted using DFS is equal to the total number of nodes 'n' in the input.
    if (root == -1)
      return false; //If they are equal, it indicates a valid binary tree; otherwise, it returns 'false'.
    return countNodes(root, leftChild, rightChild) == n;
  }

  private int countNodes(int root, int[] leftChild, int[] rightChild) 
  {
    if (root == -1)
      return 0;
    return 1 + //
        countNodes(leftChild[root], leftChild, rightChild) +
        countNodes(rightChild[root], leftChild, rightChild);
  }
    //The code effectively validates a binary tree by checking in-degrees, root identification, and counting nodes using DFS.
    //The time complexity is O(n), where n is the number of nodes, as it processes each node and edge once.
    //The space complexity is O(n), mainly due to the in-degrees array and the recursive call stack during DFS.
}