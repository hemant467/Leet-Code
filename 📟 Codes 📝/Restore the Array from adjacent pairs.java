//The Java function `restoreArray` takes an array of adjacent pairs `adjacentPairs` as input and reconstructs the original array. Each adjacent pair represents two adjacent elements in the original array.

class Solution 
{
  public int[] restoreArray(int[][] adjacentPairs) 
  //Initialization
  {
    int[] ans = new int[adjacentPairs.length + 1]; //Initialize an array `ans` with a length of one more than the number of adjacent pairs. This is because the original array will have one more element than the number of pairs.
    int i = 0; // ans' index. Initialize an integer variable `i` to keep track of the current index in the `ans` array.
    Map<Integer, List<Integer>> numToAdjs = new HashMap<>(); //Create a HashMap `numToAdjs` to map each number to its adjacent numbers.

    //Processing Adjacent Pairs :
    for (int[] pair : adjacentPairs) 
    //Iterate through each pair in the `adjacentPairs` array
    {
    //For each pair, add the numbers to the `numToAdjs` map, ensuring that each number is associated with its adjacent numbers.
      numToAdjs.putIfAbsent(pair[0], new ArrayList<>());
      numToAdjs.putIfAbsent(pair[1], new ArrayList<>());
      numToAdjs.get(pair[0]).add(pair[1]);
      numToAdjs.get(pair[1]).add(pair[0]);
    }

    //Finding Start Element
    for (Map.Entry<Integer, List<Integer>> entry : numToAdjs.entrySet()) //Iterate through the entries in the `numToAdjs` map.
      if (entry.getValue().size() == 1) //Find the entry where the list of adjacent numbers has size 1. This indicates that the corresponding number is a start or end element of the array.
      {
        //Add this number and its adjacent number to the `ans` array, incrementing the index `i` accordingly.
        ans[i++] = entry.getKey();
        ans[i++] = entry.getValue().get(0);
        break;
      }

    //Restoring the Array :  
    //Continue filling in the `ans` array until it is completely restored.

    while (i < adjacentPairs.length + 1) //For each index `i` from `2` to `adjacentPairs.length + 1`:
    {
      final int tail = ans[i - 1]; //Get the adjacent numbers of `tail` from the `numToAdjs` map.
      final int prev = ans[i - 2]; //Retrieve the previous element `prev` and the tail element `tail` from the `ans` array.
      List<Integer> adjs = numToAdjs.get(tail);
      if (adjs.get(0) == prev) //Determine the next element based on whether the first adjacent number is equal to `prev`.
        ans[i++] = adjs.get(1); //If it is, then the second adjacent number becomes the next element
      else
        ans[i++] = adjs.get(0); //Otherwise, the first adjacent number becomes the next element.
        //Add the next element to the `ans` array and increment the index `i`.
    }

    //Return Result : After restoring the array, return the `ans` array containing the original array.
    return ans;
  }
  //This code efficiently reconstructs the original array from the given adjacent pairs by traversing the adjacency information and determining the correct order of elements.

  //Time complexity of O(n) where n is the number of adjacent pairs.
}