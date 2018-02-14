/*
  Joan Chirinos
  APCS2 pd08
  HW07 -- A Man, A Plan, A Canal: Panama!
  2018-02-13
*/

public class Resrever {

    //Reverses a String in O(n)
    public static String linReverse(String s) {
	String ret = "";
	for (int i = 0; i < s.length(); i++) {
	    ret = s.substring(i, i + 1) + ret;
	}
	return ret;
    }//end simpleReverse

    //Reverses a string in log(n) time
    //Each "split" takes O(1) time because there are no real splits occuring
    //Like with mergeSort, there are 2*ceil(log(n)) layers, so the time in
    //big Oh notation is written as O(n). This is much faster than the O(n)
    //method for large strings
    public static String logReverse(String s) {
	if (s.length() <= 1) return s;
        int len = s.length();
	String s1 = s.substring(0, len/2);
	String s2 = s.substring(len/2, len);
	return logReverse(s2) + logReverse(s1);
    }//end logReverse

    public static void main(String[] args) {
	System.out.println(linReverse("AManAPlanACanalPanama"));
	System.out.println(logReverse("AManAPlanACanalPanama"));
	System.out.println(logReverse(""));
    }//end main

}//end class
