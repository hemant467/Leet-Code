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
    //Initialization:
  public ListNode removeZeroSumSublists(ListNode head) //Create a dummy node with value 0 and set its next node to the given 'head'. This is done to handle cases where the entire list needs to be removed.
  {
    ListNode dummy = new ListNode(0, head);
    int prefix = 0; //nitialize a variable 'prefix' to keep track of the running sum of the linked list values.
    Map<Integer, ListNode> prefixToNode = new HashMap<>(); //Create a map to store the running sum and the corresponding node where that sum was last seen.
    prefixToNode.put(0, dummy);

    //First Pass:
    for (; head != null; head = head.next) //Loop through the linked list.
    {
      prefix += head.val; //Update the running sum with the current node's value.
      prefixToNode.put(prefix, head); //Store the running sum and the corresponding node in the map.
    }

    //Reset and Second Pass:
    prefix = 0; //Reset the running sum.

    for (head = dummy; head != null; head = head.next) //Loop through the linked list starting from the dummy node.
    {
      prefix += head.val; //Update the running sum.
      head.next = prefixToNode.get(prefix).next; //Set the next pointer of the current node to the next node after the last occurrence of the running sum.
    }

    //Return Result:
    return dummy.next; //Return the modified linked list starting from the next node of the dummy node.
  }
}