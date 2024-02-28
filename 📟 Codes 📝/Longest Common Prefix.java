public class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        //Check for Empty Input Array:
        if (strs.length == 0) {
            return "";
        }
        //If the input array 'strs' is empty, there are no strings to compare, so the method returns an empty string.

        //Initialize Prefix:
        String prefix = strs[0];
        //The prefix is initialized with the first string in the array. This assumes that the first string is a potential common prefix.

        //Iterative Comparison:
        for (int i = 1; i < strs.length; i ++ ) {
            for (int j = 0; j < prefix.length(); j ++){
                if (j == strs[i].length() || prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        //The outer loop iterates through the strings in the array starting from the second string (index 1).
        //The inner loop iterates through each character position of the current prefix.
        //If the current character position 'j' is equal to the length of the current string 'strs[i]', or if the character at position 'j' in the prefix is different from the character at the same position in the current string, the prefix is updated to be the substring up to position 'j', and the inner loop breaks.
        //This ensures that the prefix only includes characters that are common across all strings.

        return prefix;
    }
}