class Solution 
{
    //Constants:
    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    //Method Signature: The method 'buildArray' takes an array 'target' (representing the target array) and an integer 'n' (representing the maximum size of the array) as input and returns a list of strings.
    public List<String> buildArray(int[] target, int n) 
    {
        //List Initialization: The method initializes a 'LinkedList' of strings to store the sequence of operations.
        List<String> l = new LinkedList<>();
        int preTarget = 0;

        //Iterating Through Target Array: The code iterates through each element 't' in the target array.
        for (int t : target) 
        {
            //Push Operation: For each element in the target array, a "Push" operation is added to the list.
            l.add(PUSH);

            //Difference Calculation and Pop-Push Sequence: The code calculates the difference (diff) between the current element 't' and the previous target value ('preTarget'). If the difference is not 1, it means there are missing values between the previous target and the current target. In this case, a sequence of "Pop" and "Push" operations is added to the list to fill the gap.
            int diff = t - preTarget;
            if (diff != 1) {
                for (int i = 0; i < diff - 1; i++) 
                {
                    l.add(POP);
                    l.add(PUSH);
                }
            }
        //Update Previous Target: The 'preTarget' variable is updated to the current target value.
            preTarget = t;
        }
        //Return Result
        return l;
    }
    //The code efficiently builds the sequence of operations to transform an empty array into the target array using "Push" and "Pop" operations based on the differences between consecutive elements in the target array.
}