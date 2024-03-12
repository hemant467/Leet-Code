class Solution 
{
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() <= 1) return s; //If the input string 's' is 'null' or has a length less than or equal to 1, return the input string itself since it's already a palindrome.
        String res = ""; //Initialize an empty string 'res' to store the result, which will be the longest palindrome substring.

        //Nested Loop to Generate Substrings:
        for(int i = 0; i <= s.length() - Math.max(1, res.length()); i++) //Iterate over all possible starting indices for the substring.
        {
            for(int j = i + Math.max(1, res.length()); j <= s.length(); j++) //Iterate over all possible ending indices for the substring.
            {
                String temp = s.substring(i, j); //Create a substring 'temp' from the current indices 'i' to 'j'.

                //Check Palindrome:
                if(check(temp))
                    res = temp;
                    //Check if the generated substring 'temp' is a palindrome using the check method. If it is, update the result 'res' with the current substring.
            }
        }
        return res;
    }
    //Palindrome Checking Method (check):
    private boolean check(String s) //The 'check' method takes a string 's' and checks if it is a palindrome. It uses two pointers ('low' and 'high') starting from the beginning and end of the string, moving towards each other until they meet in the middle. If characters at corresponding positions are not equal, return 'false'; otherwise, return 'true' if the entire string is checked.
    {
        int low = 0, high = s.length() - 1;
        while(low < high)
        {
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        }
        //Return Result:
        return true; //After considering all substrings, return the result, which is the longest palindrome substring found.
    }
    //Time complexity is O(n^3) due to the nested loops and the check method, making it inefficient for large inputs.
}