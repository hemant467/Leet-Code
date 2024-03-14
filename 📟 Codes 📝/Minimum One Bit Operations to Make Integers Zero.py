#The given code defines a Python function `minimumOneBitOperations` that calculates the minimum number of one-bit operations required to convert the binary representation of a non-negative integer `n` to 0 using the following operation:

#- Flip the rightmost (least significant) 1-bit in `n` to 0, along with all the bits to its right.
class Solution:
  def minimumOneBitOperations(self, n: int) -> int:
    # Observation: e.g. n = 2^2
    #        100 (2^2 needs 2^3 - 1 ops)
    # op1 -> 101
    # op2 -> 111
    # op1 -> 110
    # op2 -> 010 (2^1 needs 2^2 - 1 ops)
    # op1 -> 011
    # op2 -> 001 (2^0 needs 2^1 - 1 ops)
    # op1 -> 000
    #
    # So 2^k needs 2^(k + 1) - 1 ops. Note this is reversible, i.e., 0 -> 2^k
    # also takes 2^(k + 1) - 1 ops.

    # e.g. n = 1XXX, our first goal is to change 1XXX -> 1100.
    #   - If the second bit is 1, you only need to consider the cost of turning
    #     the last 2 bits to 0.
    #   - If the second bit is 0, you need to add up the cost of flipping the
    #     second bit from 0 to 1.
    # XOR determines the cost minimumOneBitOperations(1XXX^1100) accordingly.
    # Then, 1100 -> 0100 needs 1 op. Finally, 0100 -> 0 needs 2^3 - 1 ops.

    #Base Case:
    if n == 0: #If the input `n` is 0.
      return 0 #return 0, as there are no operations needed to convert 0 to 0.
    
    #Calculate x:
    #Calculate `x` as the largest power of 2 less than or equal to `n`. This is done by left-shifting 1 by the number of bits in the binary representation of `n` minus 1 (`n.bit_length() - 1`).
    #For example, if `n` is 5 (101 in binary), `x` will be 4 (100 in binary).

    #Recursion :
    # x is the largest 2^k <= n.
    # x | x >> 1 -> x >> 1 needs 1 op.
    #     x >> 1 -> 0      needs x = 2^k - 1 ops.
    x = 1 << n.bit_length() - 1
    #Recursively call the `minimumOneBitOperations` function with the bitwise XOR of `n` and `(x | x >> 1)`.
    #`(x | x >> 1)` sets the rightmost 1-bit of `x` and all bits to its right to 1. This creates a number with all 1s to the right of the rightmost 1-bit of `x`.
    #XORing `n` with this value flips all bits to the right of the rightmost 1-bit of `x` in `n`.
    #Add 1 to the result of the recursive call to account for the operation of flipping the rightmost 1-bit.
    #Subtract 1 from `x` and add it to the result to account for the operation of flipping the rightmost 1-bit of `n` to 0.

    #Return the Result:
    return self.minimumOneBitOperations(n ^ (x | x >> 1)) + 1 + x - 1
    #Return the final result calculated recursively.

#The function essentially performs a kind of dynamic programming where it breaks down the problem of converting `n` to 0 into smaller subproblems by flipping the rightmost 1-bit in `n` and recursively solving the subproblems until `n` becomes 0. The time complexity of this solution is O(log n) due to the recursive calls.