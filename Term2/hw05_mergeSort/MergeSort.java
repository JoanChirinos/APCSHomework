/*
  Joan Chirinos
  APCS2 pd8
  HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
  2018-2-6
*/

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:

  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b ) {
    int[] ret = new int[a.length + b.length];
    int ai = 0;
    int bi = 0;
    int i = 0;
    while (ai < a.length && bi < b.length) {
      if (a[ai] < b[bi]) {
        ret[i] = a[ai];
        ai++;
      }
      else {
        ret[i] = b[bi];
        bi++;
      }
      i++;
    }
    for ( ; ai < a.length; ai++) {
      ret[i] = a[ai];
      i++;
    }
    for ( ; bi < b.length; bi++) {
      ret[i] = b[bi];
      i++;
    }
    return ret;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr ) {
    if (arr.length == 1) {
      return arr;
    }
    int[] a1 = new int[arr.length / 2];
    int[] a2 = new int[arr.length - a1.length];
    for (int i = 0; i < a1.length; i++) {
      a1[i] = arr[i];
    }
    for (int i = 0; i < a2.length; i++) {
      a2[i] = arr[i + a1.length];
    }
    return merge(sort(a1), sort(a2));
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?

  //It is evident that elements work as if they were passed by reference

  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    if (a.length > 0) {
      System.out.print("\b");
    }
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
