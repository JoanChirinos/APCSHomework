/*
  Joan Chirinos
  APCS1 pd08
  HW47 -- ascending
  2017-5-17
*/

import java.util.ArrayList;

public class OrderedArrayList {

    ArrayList<Comparable> _data;

    // makes _data a blank ArrayList<Comparable>
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>();
    }//end constructor

    // set replaces object o at index index and returns index ONLY if it would
    // keep the OrderedArrayList sorted. Otherwise, throws
    // IllegalArgumentException
    public Object set(int index, Comparable o) {
	if (_data.get(index - 1).compareTo(o) <= 0 &&
	    _data.get(index + 1).compareTo(o) >= 0) {
	    return _data.set(index, o);
	}
	throw new IllegalArgumentException("\n\tObject o must keep the " +
					   "OrderedArrayList sorted! " +
					   "Try add(Object o)");
    }//end set

    // add adds the Object o to a place where it would keep the OrderedArrayList
    // sorted. Returns true once done
    public boolean add(Comparable o) {
	int index = 0;
	for ( ; index < _data.size(); index++) {
	    if (_data.get(index).compareTo(o) > 0) { break; }
	}
	_data.add(index, o);
	return true;
    }//end add

    // returns the OrderedArrayList as a string in the format [e0, e1, e2...]
    public String toString() {
	String str = "[";
	for (Object o : _data) {
	    str += o + ",";
	}
	if (str.length() > 1)
	    str = str.substring(0, str.length() - 1);
	return str + "]";
    }//end toString

    /********************
     * Methods below are the same as in ArrayList
     ********************/
    
    public Object get(int index) {
	return _data.get(index);
    }//end get

    public int size() {
	return _data.size();
    }//end size

    public Object remove(int index) {
	return _data.remove(index);
    }//end remove
    
    public static void main(String[] args) {
	
	System.out.println("Making new OrderedArrayList arr");
	OrderedArrayList arr = new OrderedArrayList();
	System.out.println(arr + "\n");
	
	System.out.println("Trying arr.add(5);");
	arr.add(5);
	System.out.println(arr + "\n");
	
	System.out.println("Trying arr.add(7);");
	arr.add(7);
	System.out.println(arr + "\n");
	
	System.out.println("Trying arr.add(4);");
	arr.add(4);
	System.out.println(arr + "\n");
	
	System.out.println("Trying arr.add(5);");
	arr.add(5);
	System.out.println(arr + "\n");
	
	System.out.println("Trying arr.set(1, 1000);");
	try { arr.set(1, 1000); }
	catch (IllegalArgumentException e) {
	    System.out.println("Caught IllegalArgumentException");
	}
	catch (Exception e) {
	    System.out.println("Caught a generic Exception");
	}
	System.out.println(arr + "\n");
	
	System.out.println("Trying arr.set(2, 6);");
	try { arr.set(2, 6); }
	catch (IllegalArgumentException e) {
	    System.out.println("Caught IllegalArgumentException");
	}
	catch (Exception e) {
	    System.out.println("Caught a generic Exception");
	}	
	System.out.println(arr + "\n");
	
    }//end main

}//end class
