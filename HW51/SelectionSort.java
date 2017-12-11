/*
  Joan Chirinos
  APCS1 pd08
  HW51 -- Selection
  2017-12-11
*/

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {

	//el is the index of the element we are replacing
	for (int el = 0; el < data.size() - 1; el++) {
	    int index = el;
	    //i is the index of the least element in the unsorted part
	    for (int i = el; i < data.size(); i++) {
		if (data.get(index).compareTo(data.get(i)) >= 0) {
		    index = i;
		}
	    }
	    //swapping the 2 elements
	    Comparable temp = data.get(index);
	    data.set(index, data.get(el));
	    data.set(el, temp);
	}
	
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input ) 
    {
	//arr is the array to return
	ArrayList<Comparable> arr = new ArrayList<Comparable>();
	//"add every element in input to arr..."
	for (int i = 0; i < input.size(); i++) {
	    arr.add(input.get(i));
	}
	//"... then sort arr..."
	selectionSortV(arr);
	//"...and once you're done, return arr!"
	return arr;
	
    }//end selectionSort

    public static void main( String [] args ) 
    {
	/*
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );
	*/

	/*===============for VOID methods=============
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ============================================*/


	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = selectionSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = selectionSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
