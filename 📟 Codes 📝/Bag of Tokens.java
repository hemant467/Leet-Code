class Solution 
{
  public int bagOfTokensScore(int[] tokens, int power) 
  {
    int ans = 0;               //It represents the maximum score achieved.
    int score = 0;             //It represents the current score.
    int i = 0;                 //It is the index of the smallest token that can be played face up.
    int j = tokens.length - 1; //It is the index of the largest token that can be played face down.

    //Sorting:
    Arrays.sort(tokens);
    //The 'tokens' array is sorted in ascending order.

    //Main Loop:
    //The main loop continues as long as there are tokens to be played ('i <= j') and either there is enough power to play the smallest token face up or there are tokens face up ('score > 0').
    while (i <= j && (power >= tokens[i] || score > 0)) 
    {
      while (i <= j && power >= tokens[i]) 
      {
        //Inner Loop (Face Up):
        //The inner loop plays tokens face up as long as there is enough power to play the smallest token.

        // Play the smallest face up.
        power -= tokens[i++];
        ++score;
        //It subtracts the power of the played token from the total power ('power -= tokens[i]') and increments the score ('++score').
      }

      //Update Maximum Score:
      ans = Math.max(ans, score);
      //After playing face up as many tokens as possible, the maximum score is updated using 'ans = Math.max(ans, score)'.

      //Inner Loop (Face Down):
      if (i <= j && score > 0) 
      //If there are still tokens to be played and there are face-up tokens ('score > 0'), the inner loop plays the largest token face down.
      {
        // Play the largest face down.
        power += tokens[j--];
        --score;
        //It adds the power of the played token to the total power ('power += tokens[j]') and decrements the score ('--score').
      }
    }
    //Return Maximum Score:
    return ans;
    //The final maximum score is returned.
  }
}