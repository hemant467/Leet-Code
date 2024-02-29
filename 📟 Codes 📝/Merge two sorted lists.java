	class Solution 
    {
        //Method Signature:
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
        //The method 'mergeTwoLists' takes two linked lists, 'l1' and 'l2', as input and returns a new linked list that is the result of merging the two input lists.
        {
            //Dummy Node Initialization:
	        ListNode result = new ListNode(0);
	        ListNode head = result;
            //A dummy node '(result)' is created with a value of 0. Another node '(head)' is created to keep track of the head of the merged list.

            //Merging Loop:
	        while(l1 != null || l2 != null)
            //A 'while' loop is used to iterate through both linked lists until both are exhausted.
            {
                //Comparing Values and Merging:
	            if(l1 != null && l2 != null)
                {
	                if(l1.val <= l2.val)
                    {
	                    result.next = l1;
	                    l1 = l1.next;
	                }
                    else
                    {
	                    result.next = l2;
	                    l2 = l2.next;
	                }
	                result = result.next;
	            }
                //If both linked lists have elements, the code compares the values of the current nodes ('l1.val' and 'l2.val') and appends the smaller value to the merged list.
                //The pointer ('l1' or 'l2') of the selected node is then moved to the next node.

                //Handling Remaining Elements:
                else if(l1 != null && l2 == null)
                {
	                result.next = l1;
	                break;
	            }
                else
                {
	                result.next = l2;
	                break;
	            }
                //If one linked list is exhausted while the other still has elements, the remaining elements from the non-empty list are appended to the merged list.
                //The loop is then exited.
	        }
	        return head.next;
	    }
	}