public class Solution {
   public int lengthOfLongestSubstring(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }

       int i = 0, maxLen = 0;
       int[] charMap = new int[256];
       Arrays.fill(charMap, -1);

       for (int j = 0; j < s.length(); j++) {
           if (charMap[s.charAt(j)] >= i) {
               i = charMap[s.charAt(j)] + 1;
           }

           charMap[s.charAt(j)] = j;
           maxLen = Math.max(maxLen, j-i+1);
       }

       return maxLen;
   }
}