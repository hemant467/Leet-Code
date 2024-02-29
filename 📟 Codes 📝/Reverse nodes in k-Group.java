class Solution 
{
    //Method Signature:
    public ListNode reverseKGroup(ListNode head, int k) 
    //The method 'reverseKGroup' takes the head of a linked list and an integer 'k' as input and returns the head of the modified linked list where nodes are reversed in groups of size 'k'.
    {
        //Initialization:
        ListNode curr = head;
        int count = 0;
        //Initializes a pointer 'curr' to the head of the linked list.
        //Initializes a variable 'count' to 0 to keep track of the number of nodes processed.

        //Counting Nodes:
        while(curr != null && count != k)
        {
            count++;
            curr = curr.next;
        }
        //Uses a 'while' loop to count the number of nodes in the current group (up to 'k' nodes) and move the 'curr' pointer accordingly.

        //Recursive Call for Reversing Groups:
        if(count == k)
        {
            curr = reverseKGroup(curr, k);
            while(count-- > 0)
            {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        //Checks if the count is equal to 'k', indicating that there are enough nodes to reverse.
        //Recursively calls 'reverseKGroup' for the remaining nodes after the current group.
        //Reverses the current group of nodes by adjusting the 'next' pointers.
        //Updates the head of the linked list to the new head of the reversed group ('head = curr').

        return head;
    }
}