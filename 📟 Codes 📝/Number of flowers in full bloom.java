class Solution 
{
  public int[] fullBloomFlowers(int[][] flowers, int[] persons) 
  {
    int[] ans = new int[persons.length];
    List<Integer> starts = new ArrayList<>();
    List<Integer> ends = new ArrayList<>();

    // Extract starting and ending periods of flowers and store them in lists.
    for (int[] flower : flowers) 
    {
      starts.add(flower[0]);
      ends.add(flower[1]);
    }

    // Sort the starting and ending lists.
    Collections.sort(starts);
    Collections.sort(ends);

    // Iterate over each person and find the count of full bloom flowers.
    for (int i = 0; i < persons.length; ++i) 
    {
        // Find the index of the first flower that starts after the person's preference.
      final int started = firstGreater(starts, persons[i]);

      // Find the index of the first flower that ends after or at the person's preference.
      final int ended = firstGreaterEqual(ends, persons[i]);

      // Calculate the count of full bloom flowers for the person.
      ans[i] = started - ended;
    }

    return ans;
  }

  // Binary search to find the index of the first element greater than 'target'.
  private int firstGreater(List<Integer> A, int target) 
  {
    int l = 0;
    int r = A.size();
    while (l < r) {
      final int m = (l + r) / 2;
      if (A.get(m) > target)
        r = m;
      else
        l = m + 1;
    }
    return l;
  }
  
  // Binary search to find the index of the first element greater than or equal to 'target'.
  private int firstGreaterEqual(List<Integer> A, int target) 
  {
    int l = 0;
    int r = A.size();
    while (l < r) {
      final int m = (l + r) / 2;
      if (A.get(m) >= target)
        r = m;
      else
        l = m + 1;
    }
    return l;
  }
}