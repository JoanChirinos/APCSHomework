/*
  Joan Chirinos
  APCS1 pd08
  HW46 -- A|<B> Sorted!
  2017-12-04
*/

import java.util.ArrayList;

public class ALTester {

    //General populate method
    public static void populate(ArrayList<Comparable> arrlst) {

	populate(arrlst, 0);

    }//end populate

    //Populate method where you can specify if you want the arrlst sorted or
    //not. Really only for testing purposes
    public static void populate(ArrayList<Comparable> arrlst, int sorted) {

	//boolean sorted allows us to really test if the ArrayList is sorted
	//by making sure that ArrayList is sorted
	if (sorted == 1) {
	    for (int i = 0; i < 23; i++) {
		arrlst.add((Integer) i);
	    }
	}
	else if (sorted == -1) {
	    for (int i = 23; i > 0; i--) {
		arrlst.add((Integer) i);
	    }
	}
	else {
	    for (int i = 0; i < 23; i++) {
		arrlst.add((Integer)(int)(Math.random()*50));
	    }
	}

    }//end populate

    //Compares values and returns true if the ArrayList is sorted in ascending
    //order
    public static int isSorted(ArrayList<Comparable> arrlst) {

	boolean ascending = true;
	boolean descending = true;

	Comparable compare = arrlst.get(0);

	for (int i = 1; i < 23; i++) {
	    if (!ascending && !descending)
		break;
	    if (ascending && compare.compareTo(arrlst.get(i)) > 0) {
		ascending = false;
	    }
	    if (descending && compare.compareTo(arrlst.get(i)) < 0) {
		descending = false;
	    }
	    compare = arrlst.get(i);
	}
	
	//Lets you know if its ascending or descending
	if (ascending) return 1;
	if (descending) return -1;
	return 0;
		
    }//end isSorted

    //Returns ArrayList as a string of form "[e1,e2,e3...]"
    public static String stringify(ArrayList<Comparable> arrlst) {

	String retStr = "[";
	for (Object i : arrlst) {
	    retStr += i + ",";
	}
	if (retStr.length() > 1)
	    retStr = retStr.substring(0, retStr.length() - 1);
	retStr += "]";
	return retStr;
	
    }//end stringify


    public static void main(String[] args) {

	System.out.println("Making 2 ArrayLists. \"ascending\" will be " +
			   "ascending. \"descending\" will be descending. " +
			   " \"notsorted\" will not be sorted.");

	ArrayList<Comparable> ascending = new ArrayList<Comparable>();
	ArrayList<Comparable> notsorted = new ArrayList<Comparable>();
	ArrayList<Comparable> descending = new ArrayList<Comparable>();
	
	System.out.println("\nascending: " + stringify(ascending));
	System.out.println("notsorted: " + stringify(notsorted));
	System.out.println("descending: " + stringify(descending));

	System.out.println("\nPopulating the three ArrayLists");

	populate(ascending, 1);
	populate(notsorted);
	populate(descending, -1);

	System.out.println("\nascending: " + stringify(ascending));
	System.out.println("notsorted: " + stringify(notsorted));
	System.out.println("descending: " + stringify(descending));

	System.out.println("\nisSorted returns 1 if ascending or all equal" +
			   " values, -1 if descending, and 0 if not sorted");
	
	System.out.println("\nsorted is sorted: " + isSorted(ascending));
	System.out.println("notsorted is sorted: " + isSorted(notsorted));
	System.out.println("descending is sorted: " + isSorted(descending));
	
    }//end main

}//end class
