class Solution {
    public boolean isPalindrome(int x) {
        //Negative Check:
        if(x < 0) return false;
        //If the input integer 'x' is negative, the method immediately returns 'false' since negative numbers cannot be palindromes.
        
        //Digit Extraction:
        List l = new ArrayList();
        while(x/10 != 0){
            l.add(x % 10);
            x /= 10;
        }
        if(x % 10 != 0){
            l.add(x%10);
        }
        //The code extracts individual digits from the input integer x and stores them in a list l. The loop continues until there are no more digits left. The condition x % 10 != 0 is used to handle the case when the last digit is not zero.
        
        //List Length Calculation:
        int len = l.size();
        //The length of the list is stored in the variable 'len'.

        //Palindrome Check:
        for(int i = 0; i < len/2; i++){
            if(l.get(i) != l.get(len-i-1)){
                return false;
            }
        }
        //A loop compares the elements of the list from the beginning to the middle with the elements from the end to the middle. If any pair of corresponding digits is not equal, the method returns 'false', indicating that the number is not a palindrome.

        return true;
    }
}