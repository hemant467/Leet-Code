class Solution {
    //Method Signature:
	    public ListNode removeNthFromEnd(ListNode head, int n)
        //The method 'removeNthFromEnd' takes the head of a linked list ('head') and an integer 'n' representing the Nth node from the end to remove. It returns the modified linked list.
         {
             //Result ListNode Initialization:
	        ListNode result = new ListNode(0);
	        result.next = head;
            //A new 'ListNode' named 'result' is created with a value of 0. Its 'next' pointer is set to the original head of the linked list.
            //This is a common technique to handle edge cases where the head needs to be modified.

            //First Pass - Calculate Length:
	        int len = 0;
	        ListNode temp = result;
	        while(temp.next != null){
	            temp = temp.next;
	            len ++;
	        }
            //A first pass is made through the linked list to calculate its length.
            //The variable len stores the length of the linked list.

            //Check for Invalid N:
	        if (len < n) return null;
            //If the calculated length is less than n, it means that the Nth node from the end does not exist, and null is returned.

            //Second Pass - Identify and Remove Nth Node:
	        int index = len + 1 - n;
	        len = 0;
	        temp = result;
	        while(temp.next != null){
	            len ++;
	            if(len == index){
	                temp.next = temp.next.next;//Remove
	                return result.next;
	            }
	            temp = temp.next;
	        }
            //A second pass is made through the linked list to identify the Nth node from the end.
            //Once the Nth node is identified, it is removed by updating the next pointer of the previous node.
            //The modified linked list is returned.

	        return result.next;
            //Final result
	    }
	}