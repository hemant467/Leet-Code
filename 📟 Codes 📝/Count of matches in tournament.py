#Number of Matches Calculation: In a tournament where each match results in one team being eliminated, except for the final match where the winner is determined, the total number of matches required to determine the ultimate winner is one less than the total number of teams. This is because in each match, one team is eliminated until there is only one team left as the winner.
class Solution:
  def numberOfMatches(self, n: int) -> int:
    #Return Value:
    return n - 1 #The function simply returns `n - 1`, which calculates the number of matches needed based on the total number of teams `n`.

    #The above code efficiently computes the number of matches required to determine the winner in a tournament with `n` teams.