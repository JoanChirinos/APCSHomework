/*
  Joan Chirinos
  APCS2 pd08
  HW32 -- Leon Leonwood Stack
  2018-04-11
*/

/*****************************************************
* class ALStack
* Implements interface stack using an ArrayList
* Allows for generic typing
*****************************************************/

import java.util.ArrayList;

public class ALStack<T> implements Stack<T> {

  //instance var
  private ArrayList<T> _stack;

  //constructor
  public ALStack()
  {
    _stack = new ArrayList<T>();
  }

  //utilizes AL isEmpty method
  public boolean isEmpty()
  {
    return _stack.isEmpty();
  }

  //returns last element from AL (top of stack)
  public T peek()
  {
    if (this.isEmpty()) return null;
    return _stack.get(_stack.size() - 1);
  }

  //removes and returns last element from AL (top of stack)
  public T pop()
  {
    if (this.isEmpty()) return null;
    int i = _stack.size() - 1;
    T temp = _stack.get(i);
    _stack.remove(i);
    return temp;
  }

  //adds x to end of AL (top of stack)
  public void push( T x )
  {
    _stack.add(x);
  }

  //Stringifies --> BOTTOM  e1  e2  e3  e4  e5  ...  TOP
  public String toString()
  {
    String ret = "BOTTOM ";
    for (T o : _stack) {
      ret += "  " + o + "  ";
    }
    return ret + " TOP";
  }

}//end class
