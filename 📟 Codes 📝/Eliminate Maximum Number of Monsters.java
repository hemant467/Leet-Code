class Solution 
{
  public int eliminateMaximum(int[] dist, int[] speed) 
  {
    final int n = dist.length; //Get the length of the 'dist' array, which represents the number of monsters.
    int[] arrivalTime = new int[n]; //Initialize an array 'arrivalTime' to store the arrival time for each monster.

    for (int i = 0; i < n; ++i)
        //Calculate Arrival Time:
      arrivalTime[i] = (dist[i] - 1) / speed[i];
      //Calculate the arrival time for each monster using the formula '(dist[i] - 1) / speed[i]', where 'dist[i]' represents the distance to the 'i-th' monster, and 'speed[i]' represents the speed at which the group can move.
        //Store the arrival time for each monster in the 'arrivalTime' array.

    //Sort Arrival Time:
    Arrays.sort(arrivalTime); //Sort the 'arrivalTime' array in non-decreasing order. This arranges the monsters in the order they will be encountered based on their arrival time.

    //Elimination Process:
    for (int i = 0; i < n; ++i) //Iterate through each monster and check if the index 'i' is greater than the arrival time of the 'i-th' monster ('i > arrivalTime[i]'). If this condition is met, it means that the group will not be able to eliminate the 'i-th' monster before it arrives, so the loop terminates, and the function returns 'i', which represents the maximum number of monsters that can be eliminated.

      if (i > arrivalTime[i]) //If the loop completes without encountering any condition where 'i > arrivalTime[i]', it means that the group can eliminate all monsters before they arrive, so the function returns 'n', which represents the total number of monsters.

      //Return:
        return i; //If the loop terminates early, it returns the index 'i' representing the maximum number of monsters that can be eliminated before they arrive.

    return n; //If the loop completes without terminating early, it returns 'n', indicating that all monsters can be eliminated.
  }
    //The code calculates the arrival time for each monster, sorts them, and then iterates through the sorted list to find the maximum number of monsters that can be eliminated before they arrive. It returns this value as the result.
}