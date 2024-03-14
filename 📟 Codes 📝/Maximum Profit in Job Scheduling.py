#The below Python code is designed to find the maximum profit that can be obtained by scheduling jobs within a given time frame.
class Solution:
  def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int: #First, it sorts the jobs based on their start time, end time, and profit, using the `sorted` function and list comprehension.
    jobs = sorted([(s, e, p) for s, e, p in zip(startTime, endTime, profit)]) #It then extracts the start times from the sorted list of jobs and stores them in the `startTime` list.

    # Will use binary search to find the first available startTime
    for i in range(len(startTime)):
      startTime[i] = jobs[i][0]
    
    #It defines a dynamic programming function `dp` using memoization (with the help of `functools.lru_cache(None)`), which takes an index `i` as input and returns the maximum profit that can be obtained by scheduling jobs starting from index `i` to the end of the list.

    @functools.lru_cache(None)
    def dp(i: int) -> int:
        #Inside the `dp` function, if the index `i` reaches the end of the list (`len(startTime)`), it returns 0, indicating that there are no more jobs to schedule.
      """Returns the maximum profit to schedule jobs[i..n)."""
      if i == len(startTime):
        return 0
      j = bisect.bisect_left(startTime, jobs[i][1]) #Otherwise, it uses binary search (`bisect.bisect_left`) to find the index `j` of the first job whose start time is greater than or equal to the end time of the current job (`jobs[i][1]`). This represents the earliest possible start time for the next job after completing the current job.
      return max(jobs[i][2] + dp(j), dp(i + 1)) #It recursively calculates the maximum profit by considering two scenarios:
   #Including the current job's profit (`jobs[i][2]`) and the maximum profit that can be obtained by scheduling jobs starting from index `j` (which represents the first available start time after the current job).
   #Excluding the current job and considering the maximum profit that can be obtained by scheduling jobs starting from the next index (`i + 1`).

   #The function returns the maximum profit calculated from the above two scenarios.

    return dp(0) #Finally, it returns the result of calling the `dp` function with the starting index `0`, which represents scheduling jobs from the beginning of the list.

    #The above approach efficiently computes the maximum profit by recursively considering all possible combinations of scheduling jobs and memorizing the results to avoid redundant calculations.