//This C++ function `numBusesToDestination` calculates the minimum number of buses needed to reach the target from the source using the given routes. It employs a breadth-first search (BFS) algorithm to traverse the graph of routes and stops.

class Solution
{
    //Initialization:
 public:
  int numBusesToDestination(vector<vector<int>>& routes, int source,
                            int target) 
    //It first checks if the source is the same as the target. If they are the same, it returns `0` because the destination is already reached.
    //It initializes an unordered map `graph`, where the keys are the bus stops (routes), and the values are vectors containing the indices of buses that pass through each stop.
    //It also initializes an unordered set `usedBuses` to keep track of the buses that have been used during the BFS traversal.
    
    {
    //Building the graph :

    if (source == target)
      return 0;

    //It iterates through the given `routes` vector, which contains vectors representing the bus routes.
    unordered_map<int, vector<int>> graph;  // {route: [buses]}
    unordered_set<int> usedBuses;

    //For each route, it iterates through the stops and adds the index of the route to the `graph` map corresponding to each stop.
    for (int i = 0; i < routes.size(); ++i)
      for (const int route : routes[i])
        graph[route].push_back(i);

    //BFS traversal:
    int ans = 0; //It initializes a variable `ans` to store the minimum number of buses required to reach the target.
    queue<int> q{{source}}; //It initializes a queue `q` with the source stop.

    //While the queue is not empty, it performs a BFS traversal:
    while (!q.empty()) 
    {
      ++ans;
      for (int sz = q.size(); sz > 0; --sz) //For each stop in the current level (measured by the queue size), it retrieves the route from the front of the queue.
      {
        const int route = q.front();
        q.pop(); //It pops the route from the queue.

        for (const int bus : graph[route])
          if (usedBuses.insert(bus).second) //For each bus that passes through this route, if the bus has not been used before (checked using the `usedBuses` set), it adds it to the set and explores the next routes connected to this bus.
            for (const int nextRoute : routes[bus]) 
            {
              if (nextRoute == target) //If any of the next routes is the target, it returns the current number of steps (`ans`), as the destination has been reached.
                return ans;
              q.push(nextRoute);
            }
      }
    }

    //If the target is not found after traversing all possible routes, it returns `-1`, indicating that it is not possible to reach the target.

    //Returning the result :
    //If the target is reached during the BFS traversal, the function returns the minimum number of steps (`ans`) required to reach the target.

    return -1; //If the target cannot be reached, it returns `-1`.
  }
  //Overall, this function efficiently finds the minimum number of buses needed to reach the target from the source by performing a BFS traversal on the graph of routes and stops.
};