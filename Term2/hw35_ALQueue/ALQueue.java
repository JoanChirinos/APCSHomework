/*
Joan Chirinos
APCS2 pd08
HW35 -- ...Nor Do Aussies
2018-04-16
*/

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {

  private ArrayList<T> _queue;
  public int _endIndex;
  public int _startIndex;

  public ALQueue() {
    _queue = new ArrayList<T>();
    _endIndex = _startIndex = 0;
  }

  public T dequeue() {
    if (this.isEmpty()) return null;
    _startIndex++;
    return _queue.get(_startIndex - 1);
  } //O(1)

  public void enqueue( T x ) {
    _queue.add(x);
    _endIndex++;
  } //amortized O(1)

  public boolean isEmpty() {
    return _startIndex == _endIndex;
  } //constant

  public T peekFront() {
    if (this.isEmpty()) return null;
    return _queue.get(_startIndex);
  } //constant

  public String toString() {
    String ret = "";
    for (int i = _startIndex; i < _endIndex; i++) {
      ret += " |" + _queue.get(i).toString() + "| ";
    }
    return "START: " + ret + " :END";
  }

  public static void main(String[] args) {
    ALQueue<String> alq = new ALQueue<String>();
    System.out.println("alq: " + alq + "\n");
    System.out.println("\nalq is empty: " + alq.isEmpty() + "\n");
    System.out.println("\n==========\nEnqueueing\n==========\n");
    for (int i = 0; i < 5; i++) {
      System.out.println("Enueueing " + i);
      alq.enqueue(i + "");
      System.out.println("alq: " + alq + "\n");
    }
    System.out.println("\nalq is empty: " + alq.isEmpty() + "\n");
    System.out.println("\n==========\nDequeueing\n==========\n");
    while (!alq.isEmpty()) {
      System.out.println("Dequeueing " + alq.dequeue());
      System.out.println("alq: " + alq);
    }
    System.out.println("\nalq is empty: " + alq.isEmpty() + "\n");
  }//end main

}
