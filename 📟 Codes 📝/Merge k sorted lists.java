	class Solution 
    {
        //Method Signature:
	    public ListNode mergeKLists(ListNode[] lists) 
        //The method 'mergeKLists' takes an array of ListNode arrays 'lists' and returns a single merged sorted linked list.
        {
            //Input Validation:
	        if(null == lists || lists.length == 0) return null;
            //Checks if the input array 'lists' is null or empty. If true, returns null as there are no lists to merge.

            //Initialization:
	        int len = lists.length;
	        ListNode result = new ListNode(0);
	        ListNode temp = result;
            //Initializes variables 'len' to store the length of the 'lists' array, 'result' as a dummy node to simplify the merging process, and 'temp' to keep track of the current node in the merged list.

            //Priority Queue Initialization:
	        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, new Comparator<ListNode>(){
	            @Override
	            public int compare(ListNode v1, ListNode v2){
	                return v1.val - v2.val;
	            }
	        });
        //Initializes a priority 'queue' queue to store ListNode elements with a comparator that compares nodes based on their values ('val'). The priority queue is used to efficiently find the smallest element among the heads of the k linked lists.

            //Populating Priority Queue:
	        for(ListNode node:lists){
	            if(null != node)   
                queue.offer(node);
	        }
            //Populates the priority queue with the head nodes of all non-null linked lists.

            //Merging Process:
	        while(!queue.isEmpty()){
	            ListNode node = queue.poll();
	            if(null != node){
	                temp.next = node;
	                temp = temp.next;
	                if(node.next != null)   
                    queue.offer(node.next);
	            }
	        }
            //The merging process occurs in a loop as long as the priority queue is not empty.
            //The smallest node is dequeued from the priority queue and appended to the merged list ('temp.next)'.
            //If the dequeued node has a non-null next node, it is added back to the priority queue.
            // The loop continues until all nodes have been merged.
	        return result.next;
	    }
	}