/*
Joan Chirinos
APCS1 pd8
HW20 For the -Lulz- Love of Strings
2017-10-19
*/

public class Foresrever {

    //This method brings back the fames fence method, except it utilizes
    //a for loop to build the fence.
    //pre-loop: String retFence = ""
    //init: postCounter = 1
    //test: postCounter < posts
    //update: postCounter++
    //body: adds "|--" to the end of the retFence
    //After the loop, the method adds the last post and then returns the
    //completed fence
    public static String fenceF(int posts) {
	String retFence = "";
	for (int postCounter = 1; postCounter < posts; postCounter++) {
	    retFence += "|--";
	}
	if (posts > 0)
	    retFence += "|";
	return retFence;
    }

    //String reverseF utilizes a for loop to reverse the characters in
    //String s.
    //pre-loop: String retstr = ""
    //init: int i = 0
    //test: i < s.length()
    //update: i++
    //loop: adds the i-th character of s to the front of retStr
    //After the loop, the method return retStr
    public static String reverseF(String s) {
	String retStr = "";
	for (int i = 0; i < s.length(); i++) {
	    retStr = s.substring(i, i + 1) + retStr;
	}
	return retStr;
    }

    //String reverseR utilizes recursion to reverse the characters in String s
    //base case: s is 1 character
    //--> Returns: s
    //recursive case: returns the last character of s + the reverseR of s
    //minus the last character
    public static String reverseR(String s) {
	if (s.length() == 1)
	    return s;
	return s.substring(s.length() - 1) +
	    reverseR(s.substring(0, s.length() - 1));
    }
    
    //sop methods
    public static void sop(String x) {
	System.out.println(x);
    }
    public static void sop(int x) {
	System.out.println(x);
    }
    public static void sop(boolean x) {
	System.out.println(x);
    }
    public static void sop(double x) {
	System.out.println(x);
    }


    public static void main ( String [] args ) {

	//Tests fenceF
	sop("\n========================================");
	sop("Testing String fenceF: Should return '', '|', and '|--|--|--|'\n");
	sop(fenceF(0)); // returns ""
	sop(fenceF(1)); // returns "|"
	sop(fenceF(4)); // returns "|--|--|--|"

	//Tests reverseF
	sop("\n========================================");
	sop("Testing String reverseF: Should return 'h', 'olneh', and 'Foresrever'\n");
	sop(reverseF("h")); // returns "h"
	sop(reverseF("henlo")); //return "olneh"
	sop(reverseF("reverseroF")); //returns "Foresrever"

	//Tests reverseR
	sop("\n========================================");
	sop("Testing String reverseR: Should return 'h', 'olneh', and 'Foresrever'\n");
	sop(reverseR("h")); // returns "h"
	sop(reverseR("henlo")); //return "olneh"
	sop(reverseR("reverseroF")); //returns "Foresrever"
    }
}
