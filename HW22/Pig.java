/*
  Joan Chirinos
  APCS1 pd8
  HW22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
  2017-10-24
*/


/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: idk tbh
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	if (w != null && letter.length() == 1) {
	    for (int i = 0; i < w.length(); i++) {
		if (w.substring(i, i + 1).equals(letter)) return true;
	    }
	}
	return false;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	if (letter.length() == 1) return hasA(VOWELS, letter);
	return false;
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	int vowelCounter = 0;
	for (int i = 0; i < w.length(); i++) {
	    if (isAVowel(w.substring(i, i + 1))) vowelCounter++;
	}
	return vowelCounter;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	if (w != null) return countVowels(w) > 0;
	return false;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	String retStr = "";
	if (w != null) {
	    for (int i = 0; i < w.length(); i++) {
		String temp = w.substring(i, i + 1);
		if (isAVowel(temp)) retStr += temp;
	    }
	}
	return retStr;
    }


    public static void main( String[] args ) 
    {

	sop("========================================");
	sop("Testing hasA: Should return true, true, false, false");
	sop(hasA("hello", "e")); //true
	sop(hasA("henlo", "l")); //true
	sop(hasA(null, "n")); //false
	sop(hasA("help me pls", "z")); //false
	sop("\n");

	sop("========================================");
	sop("Testing isAVowel: Should return true, true, false, false");
	sop(isAVowel("e"));
	sop(isAVowel("a"));
	sop(isAVowel("t"));
	sop(isAVowel("y"));
	sop("\n");

	sop("========================================");
	sop("Testing countVowels: should return 1, 2, 16, 0");
	sop(countVowels("a")); //1
	sop(countVowels("ego")); //2
	sop(countVowels("elephants are pretty cool, but turtles are cooler xD")); //16
	sop(countVowels("Sly lynx: fly by my crwth.....,,,,,,,!!!????@#$%^&*():;{}][1234567890<>/")); //0
	sop("\n");

	sop("========================================");
	sop("Testing hasAVowel: should return true, true, false, false");
	sop(hasAVowel("ears"));
	sop(hasAVowel("elephant toes xD"));
	sop(hasAVowel("rhythms"));
	sop(hasAVowel("!"));
	sop("\n");
	
	sop("========================================");
	sop("Testing allVowels: should return aeouieiaao, io, iooaoao, and <empty string>");
	sop(allVowels("why are you like this a-aron")); //aeouieiaao
	sop(allVowels("hi mr brown!!!")); //io
	sop(allVowels("this dont got any of da 2nd vowl xDDD")); //iooaoao
	sop(allVowels("2 + 2 = 4, - 1 = 3")); //<empty string>
	
    }//end main()

    //SOP methods

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
}//end class Pig
