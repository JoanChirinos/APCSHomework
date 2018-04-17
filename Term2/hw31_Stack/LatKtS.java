/*
  Joan Chirinos
  APCS2 pd08
  HW31 -- Stack: What Is It Good For?
  2010-04-10
*/

/*****************************************************
* skeleton for class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

  /**********************************************************
  * precondition:  input string has length > 0
  * postcondition: returns reversed string s
  *                flip("desserts") -> "stressed"
  **********************************************************/
  public static String flip( String s )
  {
    String ret = "";
    Latkes stack = new Latkes(s.length());
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.substring(i, i + 1));
    }
    while (!(stack.isEmpty())) {
      ret += stack.pop();
    }
    return ret;
  }//end flip()


  /**********************************************************
  * =============== ALGO ===============
  * I. Traverse through String
  *   1. if char is open parens
  *     a. push to stack
  *   2. is char is closing parens
  *     a. if stack.pop() doesn't match
  *       i. return false
  * II. return !( stack.isEmpty() )
  * ====================================
  * precondition:  s contains only the characters {,},(,),[,]
  * postcondition: allMatched( "({}[()])" )    -> true
  *                allMatched( "([)]" )        -> false
  *                allMatched( "" )            -> true
  **********************************************************/
  public static boolean allMatched( String s )
  {
    Latkes stack = new Latkes(s.length());
    for (int i = 0; i < s.length(); i++) {
      String curr = s.substring(i, i + 1);
      if (curr.equals("(") || curr.equals("{") || curr.equals("[")) {
        //System.out.println(curr + " in");
        stack.push(curr);
      }
      else {
        if (stack.isEmpty() && (curr.equals(")") || curr.equals("]") || curr.equals("}"))) {
          //System.out.println("empty stack");
          return false;
        }
        else if (curr.equals(")")) {
          if (stack.peek().equals("(")) {
            //System.out.println(stack.pop() + " out");
            stack.pop();
          }
          else {
            return false;
          }
        }
        else if (curr.equals("}")) {
          if (stack.peek().equals("{")) {
            //System.out.println(stack.pop() + " out");
            stack.pop();
          }
          else {
            return false;
          }
        }
        else if (curr.equals("]")) {
          if (stack.peek().equals("[")) {
            //System.out.println(stack.pop() + " out");
            stack.pop();
          }
          else {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));

    System.out.println("({}[()])" + "\n" + allMatched( "({}[()])" )); //true
    System.out.println();
    System.out.println("([)]" + "\n" + allMatched( "([)]" ) ); //false
    System.out.println();
    System.out.println("(){([])}" + "\n" + allMatched( "(){([])}" ) ); //true
    System.out.println();
    System.out.println("](){([])}" + "\n" + allMatched( "](){([])}" ) ); //false
    System.out.println();
    System.out.println("(){([])}(" + "\n" + allMatched( "(){([])}(" ) ); //false
    System.out.println();
    System.out.println("()[[]]{{{{((([])))}}}}" + "\n" + allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
