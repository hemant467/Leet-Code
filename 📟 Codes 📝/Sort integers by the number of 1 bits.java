class Solution 
{
  public int[] sortByBits(int[] arr) 
  {
    //Conversion to Integer Array:
    // Convert the primitive array to Integer array using Java Streams.
    Integer[] A = Arrays.stream(arr).boxed().toArray(Integer[] ::new); //Convert the primitive array 'arr' to an 'Integer' array 'A' using the 'Arrays.stream' method. The 'boxed()' method is used to box each 'int' into an 'Integer'. The 'toArray(Integer[] ::new)' converts the stream to an array of 'Integer'.

    //Sorting Based on Set Bits:
    //Sort the 'Integer' array based on the number of set bits in their binary representation. The provided comparator compares two integers based on:
//If the number of set bits is the same, sort by the integer value ('a - b').
//If the number of set bits is different, sort by the number of set bits ('Integer.bitCount(a) - Integer.bitCount(b)').
    Arrays.sort(A,
                (a, b)
                    -> Integer.bitCount(a) == Integer.bitCount(b)
                           ? a - b
                           : Integer.bitCount(a) - Integer.bitCount(b));
    
    // Convert the sorted Integer array back to primitive int array using Java Streams.

    //Conversion Back to Primitive Array:
    return Arrays.stream(A).mapToInt(Integer::intValue).toArray();
    //Convert the sorted 'Integer' array back to a primitive 'int' array. 'Arrays.stream(A)' creates a stream of 'Integer', 'mapToInt(Integer::intValue)' maps each 'Integer' to its 'int' value, and 'toArray()' converts the stream to an array of 'int'.
  }
  //The result is an array of integers sorted first by the number of set bits and then by their integer values. This implementation utilizes Java's functional programming features and the Stream API for a concise expression of the sorting logic.
}