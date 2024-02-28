class Solution {
    public int myAtoi(String str) {
        //Character to Integer Mapping
        Map<Character,Integer> m = new HashMap<>();
        String s = "0123456789";
        for(int i = 0; i < 10; i++){
            m.put(s.charAt(i), i);
        }
        //A map 'm' is created to map each numeric character to its corresponding integer value.

        int len = str.length();
        if(len == 0) return 0;
        Double result = 0D;
        Integer positive = 1;
        int i = 0;
        //'len' holds the length of the input string.
        //'result' is a variable to store the converted number (as a Double to handle potential decimal parts).
        //'positive' is a flag to indicate if the number is positive (initially set to 1).
        //'i' is the index used for iterating through the input string.

        //Trimming Whitespace:
        while(str.charAt(i) == ' '){
            i++;
            if(i == len){
            	return 0;
            }
        }

        Integer temp = m.get(str.charAt(i));
        if(null == temp && str.charAt(i) != '-' && str.charAt(i) != '+'){
            return 0;
        }else if(str.charAt(i) == '-'){
            positive = -1;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }
        //The first character is checked to see if it's a numeric character or a sign.
        //If it's neither, the method returns 0.
        // If it's a '-', the 'positive' flag is set to -1.
        //If it's a '+', the index 'i' is incremented.

        //Converting String to Integer:
        while(i <len && (temp = m.get(str.charAt(i))) != null){
            result = result * 10 + temp;
            i++;
        }
        //A loop iterates through the numeric characters in the string, converting them to an integer. It uses the map to get the corresponding numeric value.

        //Adjusting Sign of the Number:
        result = positive * result;
        //The sign of the number is adjusted based on the 'positive' flag.

        if(result > Integer.MAX_VALUE)  return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)  return Integer.MIN_VALUE;
        //The method checks if the converted number exceeds the bounds of a 32-bit signed integer and returns the corresponding boundary value in case of overflow.

        return result.intValue();
    }
}