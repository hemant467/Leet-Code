public class Solution {
    //Public Method:
    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0);   
    }
    //The public method 'isMatch' is called with the input strings 's' and 'p'.
    //It initiates the recursive matching process by calling the private method 'match' with initial indices 's1' and 's2' set to 0.

    //Recursive Helper Method:
    private boolean match(String s, String p, int s1, int s2) {
        if (s1 == s.length() && s2 == p.length()) {
            return true;
        }
        if (s2 == p.length()) {
            return false;
        }
        if (s2 == p.length() - 1 || p.charAt(s2 + 1) != '*') {
            //normal check
            if (s1 < s.length() && (p.charAt(s2) == '.' || s.charAt(s1) == p.charAt(s2))) {
                return match(s, p, s1 + 1, s2 + 1);
            }
            else {
                return false;
            }
        }
        else {
            // * as zero
            if (match(s, p, s1, s2 + 2)) {
                return true;
            }
            // * as not zero
            if (s1 < s.length() && ((p.charAt(s2) == '.' ||s.charAt(s1) == p.charAt(s2)) && match(s, p, s1 + 1, s2))) {
                return true;
            }
        }
        return false;
    }
}

//The private recursive method match takes the input strings s and p and two indices s1 and s2.
//The base cases check if both s and p have been fully processed. If true, it returns true.
//If p has been fully processed but not s, or if the next character in p is not '*', it performs a normal character check.
//If the characters match or the pattern has a '.', it recursively calls match with incremented indices.
//If not, it returns false.
//If the next character in p is '*', it explores two possibilities: As zero: It skips the current pattern character and calls match with incremented pattern index (s2 + 2). As not zero: It checks if the current characters match, then recursively calls match with incremented string index (s1 + 1) and the same pattern index (s2).