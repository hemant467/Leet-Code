#The below code is for finding the number of distinct numbers you can dial in exactly `n` presses of a phone dial pad starting from any digit (0-9) on the pad. It uses dynamic programming to solve the problem efficiently.
class Solution:
    #Initialization:
  def knightDialer(self, n: int) -> int:
    dirs = ((1, 2), (2, 1), (2, -1), (1, -2),
            (-1, -2), (-2, -1), (-2, 1), (-1, 2)) #Define the possible directions a knight can move on a dial pad as `dirs`. These are the valid moves a knight can make from any digit on the dial pad.
    kMod = 1_000_000_007 #Define a constant `kMod` to take the result modulo 1,000,000,007.

    # dp[i][j] := the number of ways stand on (i, j)
    dp = [[1] * 3 for _ in range(4)]
    dp[3][0] = dp[3][2] = 0 #Initialize a 4x3 2D array `dp` to represent the number of ways to stand on each key of the dial pad. Initialize all positions except those corresponding to the corners and edges to 1, as there is initially one way to stand on each of those keys.

    #Dynamic Programming :
    for _ in range(n - 1): #Iterate `n - 1` times to update the `dp` array for each press of the dial pad.
      newDp = [[0] * 3 for _ in range(4)]

      #For each position `(i, j)` on the dial pad, calculate the number of ways to reach it in the next step by considering all possible moves of a knight from adjacent keys. Update the `newDp` array accordingly.
      for i in range(4):
        for j in range(3):
          if (i, j) in ((3, 0), (3, 2)):
            continue
          for dx, dy in dirs:
            x = i + dx
            y = j + dy
            if x < 0 or x >= 4 or y < 0 or y >= 3:
              continue
            if (x, y) in ((3, 0), (3, 2)):
              continue
            newDp[x][y] = (newDp[x][y] + dp[i][j]) % kMod
      dp = newDp #After updating all positions, assign `dp` to `newDp` to prepare for the next iteration.

    #Calculate Total Ways & Return Result: Sum up all the values in the `dp` array to get the total number of distinct numbers that can be dialed in exactly `n` presses.
    return sum(map(sum, dp)) % kMod

    #The above approach efficiently calculates the number of distinct numbers that can be dialed in `n` presses using dynamic programming, considering the knight's moves on the dial pad.