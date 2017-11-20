/*
  Joan Chirinos
  APCS1 pd8
  HW21 -- Karmacomma
  2017-10-23
*/

public class Commafier {

    //Base case: x < 1000
    //--> Return: x + ""
    //Recursive case
    //--> Return commafyR of x (not including the last 3 digits) + a comma
    //    and the last 3 digits of x
    
    public static String commafyR(int x) {
	//I don't remember learning Integer.toString() yet, but this works

	/*if (x < 1000) return Integer.toString(x);*/

	//I add a blank string just to turn x into a string because when
	//an integer is added to a string, the integer turns into a string
	if (x < 1000) return x + "";
	if (x % 1000 == 0) return commafyR(x / 1000) + ",000";
	else return commafyR(x / 1000) + "," + (x % 1000);
    }

    //Pre-loop: init String retX as ""
    //Loop: no init b/c we're changing value of x
    //      Test if x >= 1000
    //      Update: remove last 3 digits of x
    //Loop body:
    //      if the last 3 digits of x are 0, then append ",000" to retX
    //      else just append a comma and the last 3 digits of x to retX
    //Post-loop: If there are still digits to prepend, prepend them then.
    //      return retX. Otherwise, just return retX
    public static String commafyF(int x) {
	String retX = "";
	for ( ; x >= 1000; x /= 1000) {

	    //This has to be done otherwise the "else" code would just append
	    //",0" to retX
	    if (x % 1000 == 0) retX = ",000" + retX;

	    //These else-ifs are needed bc if x%1000 is one digit,
	    //the code will prepend ",<digit>" and not ",00<digit>"
	    else if (x % 1000 < 10) retX = ",00" + x % 1000 + retX;
	    else if (x % 1000 < 100) retX = ",0" + x % 1000 + retX;
	    else retX += "," + x % 1000;
	    
	}
	if (x > 0) retX = x + retX;
	return retX;
    }
    
    public static void main ( String [] args ) {

	/*
	
	//This tests commafyR(int). Should return "1", "10", "101", "1,000",
	//and "12,345"
	sop(commafyR(1)); //Returns "1"
	sop(commafyR(10)); //Returns "10"
	sop(commafyR(101)); //Returns "101"
	sop(commafyR(1000)); //Returns "1,000"
	sop(commafyR(12345)); //Returns "12,345"

	//This tests commafyF(int). Should return the same as above
	sop(commafyF(1));
	sop(commafyF(10));
	sop(commafyF(101));
	sop(commafyF(1000));
	sop(commafyF(12345));

	*/


	//For each String str in array args: SOP(commafyF(<the integer rep. of
	//String str>)
	//--> You do Integer.parseInt(String) to get the int rep. of String
	for(String str: args) {
	    sop(commafyF(Integer.parseInt(str)));
	}
    }

    /* SOP METHODS FOR CONVENIENCY LOL */
    public static void sop (String x) {
	System.out.println(x);
    }
    public static void sop (int x) {
	System.out.println(x);
    }
    public static void sop (double x) {
	System.out.println(x);
    }
    public static void sop (boolean x) {
	System.out.println(x);
    }
}
