/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    //Method Signature:
  public ListNode middleNode(ListNode head) //This method takes the head of a linked list as input and returns the middle node.
  {
    //Initialization: Two pointers, 'slow' and 'fast', are initially set to the head of the linked list ('ListNode slow = head'; and 'ListNode fast = head;').
    ListNode slow = head;
    ListNode fast = head;

    //Traversal with Slow and Fast Pointers:
    while (fast != null && fast.next != null) 
    //The method enters a while loop that continues as long as the 'fast' pointer and 'fast.next' are not 'null'. The condition 'fast != null && fast.next != null' ensures that the fast pointer can make two moves as long as it has not reached the end of the list.
    //In each iteration of the loop, the 'slow' pointer moves one step ('slow = slow.next'), and the 'fast' pointer moves two steps ('fast = fast.next.next').
    //This results in the 'slow' pointer moving at half the speed of the 'fast' pointer.

    //Finding the Middle Node:

        //When the 'fast' pointer reaches the end of the linked list (i.e., 'fast == null' or 'fast.next == null'), the 'slow' pointer will be at the middle node of the list.
        //If the length of the linked list is odd, the 'slow' pointer will be exactly at the middle node.
        //If the length is even, the 'slow' pointer will be at the second middle node (the one closer to the end).
    {
      slow = slow.next;
      fast = fast.next.next;
    }

    //Returning the Middle Node: The method returns the 'slow' pointer, which is pointing to the middle node of the linked list.
    return slow;
  }
    
    //Time Complexity: The time complexity is O(n), where n is the number of nodes in the linked list.
        //The slow and fast pointers traverse the linked list in a single pass.

    //Space Complexity: The space complexity is O(1) as the algorithm uses a constant amount of extra space regardless of the input size.
        //The slow and fast pointers are the only additional variables used.
}