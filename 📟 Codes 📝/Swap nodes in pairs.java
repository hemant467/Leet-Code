	class Solution 
    {
        //Method Signature:
	    public ListNode swapPairs(ListNode head) 
        //The method 'swapPairs' takes the head of a linked list as input and returns the head of the modified linked list where adjacent nodes are swapped.
        {
            //Initialization:
	        ListNode result = new ListNode(0);
	        result.next = head;
	        ListNode temp = result;
            //Initializes a dummy node ('result') with a value of 0 to simplify the swapping process.
            //Sets the 'next' pointer of the dummy node to the input head.
            //Initializes a temporary pointer ('temp') to the dummy node.

            //Swapping Pairs:
	        while(temp.next != null && temp.next.next != null)
            {
	            ListNode pre = temp.next;
	            temp.next = pre.next;
	            pre.next = temp.next.next;
	            temp.next.next = pre;
	            temp = temp.next.next;
	        }
            //Uses a 'while' loop to iterate through the linked list while there are at least two nodes remaining to be swapped.
            //'pre' is a pointer to the first node in the pair to be swapped.
            //The 'temp.next' pointer is updated to point to the second node in the pair.
            //'pre.next' is updated to point to the node following the second node in the pair.
            //The 'temp.next.next' pointer is updated to point to the original 'pre' node, effectively swapping the pair.
//'temp' is moved two steps forward to the next pair.

	        return result.next;
            //Returns the modified linked list starting from the next node of the dummy node ('result.next').
	    }
	}