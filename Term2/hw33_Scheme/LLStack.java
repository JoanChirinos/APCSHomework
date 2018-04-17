/*
  Joan Chirinos
  APCS2 pd08
  HW32 -- Leon Leonwood Stack
  2018-04-11
*/

/*****************************************************
* class LLStack
* Implements interface Stack using a LinkedList
* Allows for generic typing
*****************************************************/

import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {

  //instance var for LL
  private LinkedList<T> _stack;

  //constructor
  public LLStack()
  {
    _stack = new LinkedList<T>();
  }

  //utilizes LL isEmpty method
  public boolean isEmpty()
  {
    return _stack.isEmpty();
  }

  //returns the first element of the LL
  public T peek()
  {
    return _stack.getLast();
  }

  //removes and returns the last element of the LL (top of stack)
  public T pop()
  {
    if (this.isEmpty()) return null;
    return _stack.removeLast();
  }

  //pushes x to the end of LL (top of stack)
  //LL uses a doubly-linked list so adding at the end is O(1)
  public void push(T x)
  {
    _stack.add(x);
  }

  //Stringifies --> BOTTOM  e1  e2  e3  e4  e5  ...  TOP
  public String toString()
  {
    String ret = "BOTTOM ";
    for (T o : _stack) {
      ret += " " + o + " ";
    }
    return ret + " TOP";
  }

  //main method for testing
  public static void main( String[] args )
  {

    Stack<String> tastyStack = new LLStack<String>();

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //coocoo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //joo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //ioo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //hoo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //goo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //foo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //eoo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //doo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //coo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //boo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    //aoo
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( "peek: " + tastyStack.peek() );
    System.out.println( "pop: " + tastyStack.pop() );
    System.out.println( tastyStack.pop() );
  }//end main

}//end class
