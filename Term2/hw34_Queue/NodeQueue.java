/*
Joan Chirinos
APCS2 pd08
HW34 -- The English Do Not Wait In Line
2018-04-13
*/

public class NodeQueue<T> implements Queue<T> {

  LLNode<T> _front, _back;
  int _size;

  //initializes an empty queue of size 0
  public NodeQueue() {
    _front = null;
    _back = null;
    _size = 0;
  }//end constructor

  //returns value of and removes front node of queue
  //substracts one from queue size
  public T dequeue() {
    if (this.isEmpty()) return null;
    T toDequeue = _front.getValue();
    _front = _front.getNext();
    _size--;
    return toDequeue;
  }//end dequeue

  //adds new node to back of queue. If queue was empty,
  //front = back = new LLNode
  //adds 1 to queue size
  public void enqueue( T x ) {
    if (this.isEmpty()) {
      _front = _back = new LLNode<T>(x, null);
    }
    else {
      _back.setNext(new LLNode<T>(x, null));
      _back = _back.getNext();
    }
    _size++;
  }//end enqueue

  //returns true if _size == 0 (queue is empty)
  public boolean isEmpty() {
    return _size == 0;
  }//end isEmpty

  public T peekFront() {
    if (this.isEmpty()) return null;
    return _front.getValue();
  }//end peekFront

  public String toString() {
    String ret = "FRONT ";
    LLNode<T> tempPointer = _front;
    int tempsize = _size;
    while (tempsize > 0) {
      ret += " " + tempPointer.getValue() + " ";
      tempPointer = tempPointer.getNext();
      tempsize--;
    }
    return ret + " BACK";
  }

  public static void main(String[] args) {
    NodeQueue<String> nq = new NodeQueue<String>();
    System.out.println("nq: " + nq + "\n");
    System.out.println("\nnq is empty: " + nq.isEmpty() + "\n");
    System.out.println("\n==========\nEnqueueing\n==========\n");
    for (int i = 0; i < 5; i++) {
      System.out.println("Enueueing " + i);
      nq.enqueue(i + "");
      System.out.println("nq: " + nq + "\n");
    }
    System.out.println("\nnq is empty: " + nq.isEmpty() + "\n");
    System.out.println("\n==========\nDequeueing\n==========\n");
    while (!nq.isEmpty()) {
      System.out.println("Dequeueing " + nq.dequeue());
      System.out.println("nq: " + nq);
    }
    System.out.println("\nnq is empty: " + nq.isEmpty() + "\n");
  }//end main

}//end class
