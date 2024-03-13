class SeatManager 
{
    //Constructor:
  public SeatManager(int n) {} //This is the constructor of the 'SeatManager' class. It takes an integer 'n' as a parameter, which represents the total number of seats in the venue. However, it seems that the constructor is empty, so it doesn't perform any initialization tasks.

    //Reserve a seat:
  public int reserve() //This method is used to reserve a seat. It checks if the 'minHeap' (which represents the available seats) is empty. If it is empty, it means there are no available seats, so it returns the next available seat number (stored in the 'num' variable) by incrementing 'num'. Otherwise, it removes and returns the smallest seat number from the 'minHeap'.

    //The 'minHeap' is used to keep track of available seats. When a seat is reserved, it is removed from the 'minHeap'.

  {
    if (minHeap.isEmpty())
      return ++num;
    return minHeap.poll();
  }

    //Unreserve a seat:
  public void unreserve(int seatNumber) //This method is used to unreserve a seat. It takes the seat number as a parameter and adds it back to the 'minHeap', indicating that the seat is now available for reservation.
  {
    minHeap.offer(seatNumber); //When a seat is unreserved, it is added back to the 'minHeap', so it becomes available for reservation again.
  }

    //Data members:
  private Queue<Integer> minHeap = new PriorityQueue<>(); //This is a priority queue ('minHeap') that stores the available seat numbers. It ensures that the smallest seat number is always at the front of the queue, making it efficient to reserve seats.
  private int num = 0; //This variable is used to keep track of the next available seat number when the 'minHeap' is empty. It starts from 0 and gets incremented each time a seat is reserved.
}