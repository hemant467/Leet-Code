class Solution 
{
  public List<Integer> findSubstring(String s, String[] words) 
  {
    if (s.isEmpty() || words.length == 0)
      return new ArrayList<>();

    final int k = words.length;
    final int n = words[0].length();
    List<Integer> ans = new ArrayList<>();
    Map<String, Integer> count = new HashMap<>();

    // Count the occurrences of each word in the array 'words'.
    for (final String word : words)
      count.merge(word, 1, Integer::sum);

    // Iterate through all possible starting indices of substrings in 's'.
    for (int i = 0; i <= s.length() - k * n; ++i) 
    {
      Map<String, Integer> seen = new HashMap<>();
      int j = 0;

      // Iterate through each word in 'words' and check if it forms a valid substring.
      for (; j < k; ++j) 
      {
        final String word = s.substring(i + j * n, i + j * n + n);
        seen.merge(word, 1, Integer::sum);
        // Check if the current word exceeds the expected count in 'words'.
        if (seen.get(word) > count.getOrDefault(word, 0))
          break;
      }
      // If all words form a valid substring, add the starting index to the result.
      if (j == k)
        ans.add(i);
    }

    return ans;
  }
}