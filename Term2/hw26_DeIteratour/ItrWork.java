/*
  Joan Chirinos, Shruthi Venkata
  APCS2 pd08
  HW26 -- DeIteratour
  2018-03-26
*/

/*****************************************************
* class ItrWork -- skeleton
* Allows for familiarization with iterators
*****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{
  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key, List<Integer> L )
  {
    for (Integer i : L) {
      if (key.equals(i)) return true;
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key, List<Integer> L )
  {
    Iterator it = L.iterator();
    while (it.hasNext()) {
      if (((Integer)it.next()).equals(key)) return true;
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> retL = new ArrayList<Integer>();
    for (Integer i : L) {
      if (i % 2 != 0) retL.add(i);
    }
    return retL;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    List<Integer> retL = new ArrayList<Integer>();
    Iterator it = L.iterator();
    while (it.hasNext()) {
      Integer toTest = (Integer) it.next();
      if (toTest % 2 != 0) retL.add(toTest);
    }
    return retL;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator it = L.iterator();
    while (it.hasNext()) {
      if (((Integer)it.next()) % 2 == 0) it.remove();
    }
  }


  public static void main( String [] args )
  {
    //var type: List   obj type: ArrayList
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
    L.add(i);


    // TASK: write code to print the contents of ArrayList L...

    String toPrint;

    // a) using a FOREACH loop
    System.out.println("Print using FOREACH:");

    toPrint = "";
    for (Integer i : L) {
      toPrint += i + ",";
    }
    if (L.size() > 1) {
      toPrint = toPrint.substring(0, toPrint.length() - 1);
    }
    System.out.println("\t" + toPrint);

    // b) explicitly using an iterator

    System.out.println("\nPrint using iterator:");

    toPrint = "";
    Iterator it = L.iterator();
    while (it.hasNext()) {
      toPrint += it.next() + ",";
    }
    if (L.size() > 1) {
      toPrint = toPrint.substring(0, toPrint.length() - 1);
    }
    System.out.println("\t" + toPrint);


    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork

/*
  Throwback to the good old days when you told us to ignore iterator() when we were
  learning ArrayList

  Helps us remove stuff without needing a simple for loop.

  Would be kinda weird to have a nested iterator thing but I'm sure it works
*/
