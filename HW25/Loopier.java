/*
Joan Chirinos
APCS pd8
HW25 -- All Hallow's Eve
2017-10-31
*/

/*
                 _
                /))
             __(((__
           .' _`""`_`'.
          /  /\\  /\\  \
         |  /)_\\/)_\\  |
         |  _  _()_  _  |
         |  \\/\\/\\//  |
          \  \/\/\/\/  /
           '.___..___.'

creds to some random website

*/

public class Loopier {

    //This method will take an already initialized array and replace each
    //element with an int in the set [0, 9)
    public static void fillArray(int[] arr) {
	for(int i = 0; i < arr.length; i++){ 
	    arr[i] = (int) (Math.random() * 10);
	}
    }

    //This method returns a String representation of an array
    public static String arrToString(int[] arr) {
	String retStr = "[";
	for (int i = 0; i < arr.length - 1; i++) {
	    retStr += arr[i] + ",";
	}
	retStr += arr[arr.length - 1] + "]";
	return retStr;
    }

    //This method does a linear search of an array and returns the index of
    //the first occurence of the target. Returns -1 if target not found
    public static int linSearch(int[] a, int target) {
	for(int i = 0; i < a.length; i++) {
	    if (a[i] == target) return i;
	}
	return -1;
    }

    //This method should do the same as above, but recursively.
    public static int linSearchR(int[] a, int target) {
	//I don't know what the base case should do
	if (a.length == 0) {
	    return 1;
	}
	else if (a[0] == target) {
	    return 0;
	}
	else {
	    int[] arr = new int[a.length - 1];
	    for (int i = 0; i < arr.length; i++) {
		arr[i] = a[i + 1];
	    }
	    return 1 + linSearchR(arr, target);
	}
    }

    //This method returns the frequency of target in int array a
    public static int freq(int[] a, int target) {
	int counter = 0;
	for(int i = 0; i < a.length; i++) {
	    if (a[i] == target) counter++;
	}
	return counter;
    }

    //This method does the same as freq, but recursively. 
    public static int freqR(int[] a, int target) {
	if (a.length == 0) return 0;
	int[] arr = new int[a.length - 1];
	for (int i = 0; i < arr.length; i++) {
	    arr[i] = a[i + 1];
	}
	if (a[0] == target) return 1 + freq(arr, target);
	else return freq(arr, target);
    }


    //Main Method
    public static void main(String[] args) {
	sop("========================================");
	sop("Testing fillArray: Returns a random array of length 20");
	sop("Also testing arrToString, as the random array will be");
	sop("returned as a String");
	int[] randArray = new int[20];
	fillArray(randArray);
	sop("\n" + arrToString(randArray) + "\n");

	sop("========================================");
	sop("Testing linSearch on above array: Should return the index");
	sop("of the first 4, 1, and 4224 (linSearch(4224) should return -1)");
	sop(linSearch(randArray, 4));
	sop(linSearch(randArray, 1));
	sop(linSearch(randArray, 4224));

	sop("========================================");
	sop("Testing linSearchR on above array: Should return the same");
	sop("values as linSearch");
	sop("However, I was unable to find a suitable base case, so if the");
	sop("number is > the original length of the array (>20), it should");
	sop("be treated as -1");
	sop(linSearchR(randArray, 4));
	sop(linSearchR(randArray, 1));
	sop(linSearchR(randArray, 4224));

        sop("========================================");
	sop("Testing freq on above array: Should return the frequency");
	sop("of 0, 4, and 4224 (freq(4224) should be 0)");
	sop(freq(randArray, 0));
	sop(freq(randArray, 4));
	sop(freq(randArray, 21));

	sop("========================================");
	sop("Testing freqR on above array: Should return the same values as");
	sop("freq");
	sop(freqR(randArray, 0));
	sop(freqR(randArray, 4));
	sop(freqR(randArray, 21));
    }

    public static void sop(String x) {
	System.out.println(x);
    }
    public static void sop(int x) {
	System.out.println(x);
    }
    public static void sop(double x) {
	System.out.println(x);
    }
    public static void sop(boolean x) {
	System.out.println(x);
    }
}
