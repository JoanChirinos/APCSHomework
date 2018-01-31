/*
  Joan Chirinos
  APCS1 pd 08
  HW38 -- Put It Together
  2017-11-21
*/

/*
  Creates a 3x3 2D String array, populates it with random 3 to 4 character
  Strings composed of lowercase and uppercase letters, numbers, and some
  letters. Displays it and then prompts user to pick 2 locations, swap
  these elements, and redisplay the 2D array
 */

import cs1.Keyboard;

public class Swapper {

    private static final String CHARACTERS = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
					    "abcdefghijklmnopqrstuvwxyz" +
					    "!@#$%^&*1234567890`~=+-_.,/?");

    //Swapping method checks if rows and columns are valid and, if so, swaps
    //the elements. Otherwise, prints error statement
    public static void swap(String[][] arr,
			    int r1, int c1,
			    int r2, int c2) {

	//Makes sure rows and columns are valid
	if (r1 < 0 || r2 < 0 || c1 < 0 || c2 < 0 ||
	    r1 > arr.length - 1 || r2 > arr.length - 1||
	    c1 > arr[r1].length - 1 || c2 > arr[r2].length - 1) {

	    System.out.println("\nInvalid value for >= 1 row/column");
	    
	}

	else {
	    
	    String stored = arr[r1][c1];
	    arr[r1][c1] = arr[r2][c2];
	    arr[r2][c2] = stored;
	    
	}
	
    }//end Swap

    //Displays 2D array by printing each array as a row
    public static void displayArray(String[][] arr) {
	    
	System.out.println();
	int numColumns = 0;
	System.out.print("\t    ");
	for ( ; numColumns < arr[0].length; numColumns++) {
	    System.out.print(numColumns + "     ");
	}
	System.out.print("\n");

	int numRows = 0;
	for (String[] r : arr) {
	    System.out.print("\t" + numRows + "  ");
	    numRows++;
	    for (String c : r) {
		if (c.length() == 3)
		    System.out.print(c + "   ");
		else
		    System.out.print(c + "  ");
	    }
	    System.out.print("\n");
	}
	
    }//end displayArray

    //Uses randomString to populate each element of the 2D array
    public static void populate(String[][] arr) {

	for (int r = 0; r < arr.length; r++) {
	    for (int c = 0; c < arr[r].length; c++) {
		arr[r][c] = randomString();
	    }
	}
	
    }//end populate

    //Generates a random String using CHARACTERS
    public static String randomString() {
	
	String retStr = "";
	int index;
	int charCount = (int) (Math.random() * 2 + 3);
	while (charCount > 0) {
	    index = (int) (Math.random() * CHARACTERS.length());
	    retStr += CHARACTERS.substring(index, index + 1);
	    charCount--;
	}
	return retStr;

    }//end randomString

    //Makes a 2D array with r rows and c columns
    public static String[][] makeArray(int r, int c) {

	return new String[r][c];
	
    }//end makeArray

    public static void main(String[] args) {

	System.out.println("Examples of randomString: " +
			   randomString() + ", " +
			   randomString() + ", " +
			   randomString());
	
<<<<<<< HEAD
	String[][] arr = makeArray(3, 4);
=======
	String[][] arr = new String[4][5];
>>>>>>> 484f5d153a348f5dbeb29892ce7a071e8e200949
	populate(arr);

	int row1, row2, column1, column2;
	String confirm = "N";

	//Makes sure user wants to swap
	while (true) {

	    displayArray(arr);
	    
	    System.out.println("\nSwap Locations\nFirst String");
	
	    System.out.print("\tRow: ");
	    row1 = Keyboard.readInt();
	
	    System.out.print("\tColumn: ");
	    column1 = Keyboard.readInt();

	    System.out.println("\nSecond String");
	
	    System.out.print("\tRow: ");
	    row2 = Keyboard.readInt();
	    
	    System.out.print("\tColumn: ");
	    column2 = Keyboard.readInt();

	    System.out.println("Are you sure you want to swap (" +
			       row1 + ", " + column1 + ") with (" +
			       row2 + ", " + column2 + ")? Y/N");
	    confirm = Keyboard.readString();

	    if (confirm.equals("Y") || confirm.equals("y")) break;
	}
	    
	swap(arr, row1, column1, row2, column2);

	System.out.println();
	displayArray(arr);
	System.out.println();
	
    }//end main
    
}//end class
