class Solution {
    //Method Signature:
    public List<String> letterCombinations(String digits)
    //The 'letter Combinations' method takes a string of digits as input and returns a list of all possible letter combinations.
     {
         //Check for Empty Input:
        List<String> ans = new ArrayList<>();
        if (!digits.isEmpty()) {
            dfs(digits, 0, new StringBuilder(), ans);
        }
        return ans;
        //A list 'ans' is initialized to store the final letter combinations.
        //It checks if the input string 'digits' is not empty before proceeding. If it's empty, an empty list is returned.
    }

    //Digit to Letters Mapping:
    private static final String[] digitToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //A static array 'digitToLetters' is defined to map each digit (0 to 9) to the corresponding letters on a phone keypad.

    //DFS Method:
    private void dfs(String digits, int i, StringBuilder sb, List<String> ans) 
    //The 'dfs' method takes the current digit string ('digits'), the current index 'i', a 'StringBuilder' to build the current combination, and the final list of combinations 'ans'.
    {
        //Base Case Check:
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
            //If the index 'i' reaches the length of the digit string, it means a valid combination is formed. The current combination is added to the result list, and the method returns.
        }

        //Recursive DFS [Distributed File System] Loop:
        for (char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        //The method enters a loop over the characters corresponding to the current digit.
        //For each character, it appends the character to the current combination, makes a recursive call with the next index ('i + 1'), and then removes the last character to backtrack and explore other possibilities.
        }
    }
}