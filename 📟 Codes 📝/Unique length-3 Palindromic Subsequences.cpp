class Solution 
{
 public:
  int countPalindromicSubsequence(string s) 
  {
    //Initialization:
    int ans = 0; //This variable stores the count of palindromic subsequences.
    vector<int> first(26, s.length()); //This vector of size 26 (representing the alphabet) stores the first occurrence index of each character in the string `s`. It is initialized with the length of `s` for each character, indicating that no occurrence has been found yet.
    vector<int> last(26); //This vector of size 26 stores the last occurrence index of each character in the string `s`. It is initially empty.

    //Finding First and Last Occurrences:
    for (int i = 0; i < s.length(); ++i) 
    //The code iterates over each character of the string `s`.
    {
      const int index = s[i] - 'a'; //For each character, it calculates the index (`index`) by subtracting the ASCII value of 'a' from the character.
      first[index] = min(first[index], i); //It updates the `first` vector to store the minimum index of each character encountered so far.
      last[index] = i; //It updates the `last` vector to store the maximum index of each character encountered so far.
    }

    //Counting Palindromic Subsequences:
    for (int i = 0; i < 26; ++i) //The code iterates over each character of the alphabet (26 characters).

      if (first[i] < last[i]) //For each character, if its first occurrence index (`first[i]`) is less than its last occurrence index (`last[i]`), it implies that the character appears at least twice in the string.

        ans += unordered_set<int>(s.begin() + first[i] + 1, s.begin() + last[i])
                   .size(); //It constructs a substring from `s` using the range `[first[i] + 1, last[i]]` (excluding the first and last occurrences).
                   //It constructs an unordered set from this substring, which automatically removes duplicate characters.
                   //It adds the size of this unordered set to the `ans`, representing the count of unique characters between the first and last occurrences of the character `i`.

    //Result:
    return ans;
    //Finally, the code returns the accumulated count of unique characters between the first and last occurrences of each character, which represents the count of unique palindromic subsequences in the string `s`.
  }
};