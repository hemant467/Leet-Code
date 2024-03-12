class Solution 
{
    public int countVowelPermutation(int n) 
    {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'}; //Initialize an array of vowels.
        long[][] dp = new long[n][5]; //Initialize a 2D array 'dp' to store the count of strings ending with each vowel for each length up to 'n'.
        int MOD = (int) 1e9 + 7; //Initialize a constant 'MOD' for taking the modulo in the final result.
        for(int i=0;i<5;i++)
        {
            dp[0][i] = 1; //For strings of length 1, each vowel can form one string.
        }

        //Dynamic Programming Loop:
        // a:0, e:1, i:2, o:3, u:4
        for(int i=1;i<n;i++) //Iterate from length 2 to 'n' to build the dynamic programming table for strings of length 'n'.
        {
            // e,i,u->a
            dp[i][0] = (dp[i-1][1]) % MOD;
            // a,i->e
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            // e,o->i
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % MOD;
            // i->o
            dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % MOD;
            // i->u
            dp[i][4] = (dp[i-1][0]) % MOD;
            //Update Counts ('dp[i][j]') :Calculate the counts of strings ending with each vowel based on the rules mentioned in the comments.
        }
        //Return Result:
        long count = 0; //Initialize a variable to store the total count of valid strings.
        for(int col=0;col<5;col++)
            count= (count+dp[n-1][col]) % MOD; //Sum up the counts of strings for each vowel in the dynamic programming table.
        return (int) count; //Return the final count, taking the modulo with 'MOD'.
    }
    //The approach uses dynamic programming to build the count of strings iteratively, considering the rules for each vowel. The final result is the sum of counts for all vowels, modulo 'MOD'. The use of 'long' is for avoiding integer overflow in the intermediate results.
}