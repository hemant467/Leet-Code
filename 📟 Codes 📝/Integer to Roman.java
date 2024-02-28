public class Solution {
    public String intToRoman(int num) {
        //Base Values and Corresponding Roman Characters:
        int[] base = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX", "V", "IV", "I"};
        //Two arrays base and chars are defined to store the base values and their corresponding Roman characters.
        //1000 corresponds to 'M', 900 to 'CM', 500 to 'D', 400 to 'CD' , 100 to 'C' , 90 to 'XC' , 50 to 'L' , 40 to 'XL' , 10 to 'X' , 9 to 'IX' , 5 to 'V' , 4 to 'IV' , 1 to 'I'

        //expand the "base" char to make sure that the roman numeric can be only the 1 - 3 appearance of the characters above

        String result = "";
        for (int i = 0; i < base.length; i ++) {
            if (num / base[i] > 0) {
                for (int j = 0; j < num/base[i]; j ++) {
                    result = result + chars[i];
                }
                num = num - (num / base[i]) * base[i];
            }
        }
        //A result variable is initialized to an empty string.
        //The code iterates through the base array.
        //For each base value, it checks how many times the base value can be subtracted from the given number (num).
        //It then appends the corresponding Roman character to the result that many times.
        //The value of num is updated by subtracting the product of the division result and the base value.
        //This process continues until num becomes 0.

        return result;
    }
}