class Solution 
{
    //Method Signature:
  public boolean isValid(String s) 
  //The method 'isValid' takes a string 's' as input and returns a boolean indicating whether the string is well-formed.
  {
      //Stack Initialization:
    Deque<Character> stack = new ArrayDeque<>();
    //A 'Deque' (double-ended queue) of characters is used as a stack to keep track of the opening brackets.
    //The stack will be used to check the correctness of the closing brackets.

    //Iterating Through the String:
    for (final char c : s.toCharArray())
    //The code iterates through each character in the input string 's'.

    //Handling Opening Brackets:
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
        //If the current character is an opening bracket ('(', '{', or '['), the corresponding closing bracket (')', '}', or ']') is pushed onto the stack.
        //This effectively keeps track of the expected closing bracket for each opening bracket.
        
        //Handling Closing Brackets:
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
        //If the current character is a closing bracket, the code checks whether the stack is empty or if the popped character from the stack matches the current closing bracket.
        //If the conditions are not met, it means that the brackets are not well-formed, and the method returns false.

    return stack.isEmpty();
    //After processing all characters in the string, a final check is performed to see if the stack is empty.
    //If the stack is empty, it means that all opening brackets had corresponding closing brackets, and the string is well-formed. In this case, the method returns 'true'.
    //If the stack is not empty, there are unmatched opening brackets, and the method returns 'false'.

  }
}