/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution
{
    //Input Parameter:
  public boolean hasCycle(ListNode head) 
    //'head': The head of the linked list.
  {
    //Two-Pointer Approach (Floyd's Tortoise and Hare):
    ListNode slow = head;
    ListNode fast = head;
    //Initialize two pointers, 'slow' and 'fast', both starting at the head of the linked list.

    //Loop to Detect Cycle: Use a 'while' loop that continues as long as 'fast' is not null and 'fast.next' is not null (to avoid null pointer exceptions).
    while (fast != null && fast.next != null) 
    //Inside the loop:
    {
      slow = slow.next; //Move the 'slow' pointer one step at a time ('slow = slow.next').
      fast = fast.next.next; //Move the 'fast' pointer two steps at a time ('fast = fast.next.next').
      if (slow == fast) //Check if the 'slow' and 'fast' pointers meet at the same node. If they do, there is a cycle.
        return true; //The function returns 'true'.
    }

    //Return Result: If the loop completes without finding a cycle (i.e., if 'fast' becomes null or 'fast.next' becomes null), the function returns 'false' as there is no cycle.
    return false;
  }
  
  //Explanation:

//The 'slow' and 'fast' pointers start at the head and traverse the linked list at different speeds.
//If there is no cycle, the 'fast' pointer will eventually reach the end of the list, and the loop exits.
//If there is a cycle, the 'fast' pointer will eventually catch up to the 'slow' pointer within the cycle, and the loop detects the cycle.

//Time Complexity: The time complexity is O(n), where n is the number of nodes in the linked list. In the worst case, the pointers traverse the entire linked list once.

//Space Complexity: The space complexity is O(1) since the algorithm uses only a constant amount of extra space for the two pointers.

//The code efficiently determines whether a linked list has a cycle by using the Tortoise and Hare algorithm, which is widely used for cycle detection in linked lists.

}