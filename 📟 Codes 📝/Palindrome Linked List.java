//The below code aims to determine whether a given linked list is a palindrome.
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
  public boolean isPalindrome(ListNode head) //It defines a method `isPalindrome` that takes the head of a linked list as input and returns a boolean indicating whether the linked list is a palindrome.
  {
    //Initializing two pointers, `slow` and `fast`, both pointing to the head of the linked list. It uses the slow and fast pointers to find the middle of the linked list.
    ListNode slow = head; //The slow pointer moves one step at a time.
    ListNode fast = head; //The fast pointer moves two steps at a time.

    while (fast != null && fast.next != null) //When the fast pointer reaches the end of the list or becomes null, the slow pointer will be at the middle (or middle-left) of the list.
    {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast != null)
      slow = slow.next;
    slow = reverseList(slow);
    //After finding the middle of the linked list, it reverses the second half of the list using the `reverseList` method.
    //The `reverseList` method reverses the linked list starting from the node passed as an argument and returns the new head of the reversed list.

    //Once the second half of the list is reversed, it iterates through both halves of the list simultaneously:
    while (slow != null) 
    {
      if (slow.val != head.val) //It compares the values of corresponding nodes in the original list and its reversed second half.
        return false; //If any of the values do not match, it returns `false`, indicating that the linked list is not a palindrome.
      slow = slow.next;
      head = head.next;
      //If all values match, it continues moving the pointers forward until the end of the list is reached.
    }

    return true; //If the loop completes without finding any mismatched values, it returns `true`.

    //Indicating that the linked list is a palindrome.
  }

  private ListNode reverseList(ListNode head) 
  {
    ListNode prev = null;

    while (head != null) 
    {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }
  //the code efficiently determines whether a linked list is a palindrome by using two pointers to find the middle of the list, reversing the second half, and then comparing corresponding values in both halves.

    //Time Complexity : O(n)
    //Space Complexity : O(1)
}