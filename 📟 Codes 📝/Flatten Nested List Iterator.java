//NestedIterator Class : It implements the 'Iterator<Integer>' interface, indicating that it will iterate over a collection of integers.
public class NestedIterator implements Iterator<Integer> 
{
  private Queue<Integer> q = new ArrayDeque<>();
  //Queue<Integer> q: An 'ArrayDeque' used to store the flattened list of integers. It acts as a buffer to facilitate iteration.

    //Constructor: 
  public NestedIterator(List<NestedInteger> nestedList) //It takes a 'List' of 'NestedInteger' as input and initializes the iterator. The constructor calls the 'addInteger' method to populate the queue.
  {
    addInteger(nestedList);
  }

  @Override
  public Integer next() //It retrieves and removes the head of the queue, effectively returning the next integer in the flattened list.
  {
    return q.poll();
  }

  @Override
  public boolean hasNext() //It checks whether the queue is empty, indicating whether there are more elements to iterate.
  {
    return !q.isEmpty();
  }
  
  //The 'next' and 'hasNext' methods then operate on the queue, providing a simple and efficient way to iterate over the flattened list of integers.

  private void addInteger(final List<NestedInteger> nestedList) //This is a recursive method that takes a 'List' of 'NestedInteger' and adds integers to the queue. If a 'NestedInteger' is an integer, it is added to the queue. If it is a nested list, the method is called recursively.
  {
    for (final NestedInteger ni : nestedList)
      if (ni.isInteger())
        q.offer(ni.getInteger());
      else
        addInteger(ni.getList());
  }
}