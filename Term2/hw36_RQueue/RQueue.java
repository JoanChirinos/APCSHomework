/*
Joan Chirinos, George Liang
APCS2 pd08
HW36 -- Now Let’s Consider You Lot at Fake Terry’s
2018-04-17
*/

/*****************************************************
* class RQueue
* A linked-list-based, randomized queue
* (a collection with FIIDKO property)
*
*       -------------------------------
*   end |  --->   Q U E U E   --->    | front
*       -------------------------------
*
*  linkages point opposite direction for O(1) en/dequeuing
*            N <- N <- ... <- N <- N
*      _end -^                     ^- _front
*
******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _size = 0;
    _front = _end = null;
  }//end default constructor


  public void enqueue( T enQVal )
  {
    LLNode<T> t = new LLNode<T>(enQVal, null);
    if (this.isEmpty()) {
      _front = _end = t;
    }
    else {
      _end.setNext(t);
      _end = _end.getNext();
    }
    _size++;
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    sample();
    if (this.isEmpty()) return null;
    _size--;
    T t = _front.getValue();
    _front = _front.getNext();
    return t;
  }//end dequeue()

  public T peekFront()
  {
    if (this.isEmpty()) return null;
    return _front.getValue();
  }


  /******************************************
  * void sample() -- a means of "shuffling" the queue
  * reassigns _front
  * Algo:
  * Repeat n times, n being a random integer from 0 to _size - 1 inclusive:
  * 1. dequeue the front of the stack
  * 2. enqueue the value just dequeued
  ******************************************/
  public void sample()
  {
    for (int i = (int)(Math.random() * _size); i > 0; i--) {
      _size--;
      T t = _front.getValue();
      _front = _front.getNext();
      this.enqueue(t);
    }
  }//end sample()


  public boolean isEmpty()
  {
    return _size == 0;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String ret = "FRONT ";
    LLNode<T> tempPointer = _front;
    int tempsize = _size;
    while (tempsize > 0) {
      ret += " " + tempPointer.getValue() + " ";
      tempPointer = tempPointer.getNext();
      tempsize--;
    }
    return ret + " BACK";
  }//end toString()

  //main method for testing
  public static void main( String[] args )
  {

    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Robert");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...");
    System.out.println( PirateQueue.dequeue() );

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
