/*
Joan Chirinos
APCS1 pd 8
HW17 -- Do I repeat myself?
2017-10-16
*/

public class Repeater {

    //===Recursive Fence Method===
    //Base case: numPosts = 1
    //--> Returns: String "|"
    //Recursive Case: numPosts > 1
    //--> Returns: "|--" + fenceR(numPosts - 1)
    public static String fenceR(int numPosts) {
	if (numPosts == 1)
	    return "|";
	else
	    return "|--" + fenceR(numPosts - 1);
    }

    //===While Loop Fence Method===
    //Names String fence = "|"
    //Condition: numPosts > 1
    //True --> add "--|" to String fence, subtracts 1 from numPosts
    //False --> returns String fence
    public static String fenceW(int numPosts) {
	String fence = "|";
	while (numPosts > 1) {
	    fence += "--|";
	    numPosts -= 1;
	}
	return fence;
    }

    public static void main(String [] args) {
	System.out.println("===While Loop Version===\n");
	//This tests the while loop fence maker
	System.out.println(fenceW(5)); //returns "|--|--|--|--|"
	System.out.println(fenceW(1)); //returns "|"
	System.out.println("\n========================\n");

	System.out.println("===Recursive  Version===\n");
	//This tests the recursive fence maker. It returns the same thing
	//as the code above so that you see it can be done both ways
	System.out.println(fenceR(5)); //returns "|--|--|--|--|"
	System.out.println(fenceR(1)); //returns "|"
	System.out.println("\n========================\n");
    }
}
