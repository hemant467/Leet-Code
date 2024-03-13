class Solution 
{
  public String sortVowels(String s) 
  {
    //Initialization:
    StringBuilder sb = new StringBuilder(); //Initialize a `StringBuilder` `sb` to construct the sorted string.
    List<Character> vowels = new ArrayList<>(); //Create an `ArrayList<Character>` `vowels` to store the vowels encountered in the string.

    //Iterate through the String:
    for (final char c : s.toCharArray()) //Iterate through each character `c` in the input string `s`.
      if (isVowel(c)) //Check if the character `c` is a vowel using the `isVowel` method.
        vowels.add(c); //If `c` is a vowel, add it to the `vowels` list.

    //Sort the Vowels
    Collections.sort(vowels); //Sort the `vowels` list using the `Collections.sort` method. This sorts the vowels in ascending order.

    //Construct the Sorted String
    int i = 0; //Initialize an index `i` to track the position of the next vowel in the `vowels` list.Vowels' index.
    for (final char c : s.toCharArray()) //Iterate through each character `c` in the input string `s` again.
      sb.append(isVowel(c) ? vowels.get(i++) : c); //If `c` is a vowel (determined by `isVowel(c)`), append the vowel at index `i` from the `vowels` list to the `StringBuilder` `sb`, and increment `i`.
      //If `c` is not a vowel, append it directly to the `StringBuilder` `sb`.

    //Return the Sorted String:
    return sb.toString(); //Convert the `StringBuilder` `sb` to a string using the `toString` method and return it.
  }

    //Helper Method `isVowel`
  private boolean isVowel(char c) //The `isVowel` method determines if a character `c` is a vowel by checking if it exists in the string `"aeiouAEIOU"`. If `c` is found in this string, it returns `true`; otherwise, it returns `false`.
  {
    return "aeiouAEIOU".indexOf(c) != -1;
  }
  //The code sorts the vowels in the input string `s` while preserving the order of non-vowel characters. The time complexity of the code is O(n log n), where n is the length of the input string `s`, due to the sorting operation.
}