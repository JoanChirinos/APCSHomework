/*
  Joan Chirinos
  APCS2 pd08
  HW33 -- What a Racket
  2018-04-12
*/

/*****************************************************
* class Scheme
* Simulates a rudimentary Scheme interpreter
*
* ALGORITHM for EVALUATING A SCHEME EXPRESSION:
*   1. Store first number
*   2. While the next element in the stack is a number, pop it and do the operation
*   3. If the next element is a open parens, start the algo over using the new
*      operation
*   4. If the next element is a closing parens, pop it and return the result
*
* STACK OF CHOICE: LLStack by Joan Chirinos
* b/c ... LinkedLists kinda look like sideways stacks when we draw them. Also,
* we don't need the indexing capabilities of AL (which, on second thought, indexing
* probably takes less space than pointers because an indexed collection of things
* automatically knows the next item is at the adjacent memory location, so it doesn't
* need to store a pointer. hmm...)
******************************************************/

public class Scheme
{
  /******************************************************
  * precond:  Assumes expr is a valid Scheme (prefix) expression,
  *           with whitespace separating all operators, parens, and
  *           integer operands.
  * postcond: Returns the simplified value of the expression, as a String
  * eg,
  *           evaluate( "( + 4 3 )" ) -> 7
  *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
  ******************************************************/
  public static String evaluate( String expr )
  {
    Stack<String> s = new LLStack<String>();
    String[] exprarr = expr.split("\\s+");
    for(int i = exprarr.length - 1; i > 0; i--) {
      s.push(exprarr[i]);
    }
    String op = s.pop();
    if (op.equals("+")) return unload(1, s);
    else if (op.equals("-")) return unload(2, s);
    return unload(3, s);
  }//end evaluate()


  /******************************************************
  * precond:  Assumes top of input stack is a number.
  * postcond: Performs op on nums until closing paren is seen thru peek().
  *           Returns the result of operating on sequence of operands.
  *           Ops: + is 1, - is 2, * is 3
  ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
    int result = Integer.parseInt(numbers.pop());

    //while the stack has stuff in it
    while (!numbers.isEmpty()) {
      while (isNumber(numbers.peek())) {

        //while the next element is a number, do the operation specified and pop it
        switch (op) {
          case 1:
            result += Integer.parseInt(numbers.pop());
            break;
          case 2:
            result -= Integer.parseInt(numbers.pop());
            break;
          case 3:
            result *= Integer.parseInt(numbers.pop());
            break;
        }
      }

      //if found open parens, evaluate the stuff inside it
      if (numbers.peek().equals("(")) {
        //pop the "(" out first
        numbers.pop();

        //next el will be +, -, or *. Use this to figure out what to eval
        String newOp = numbers.pop();
        //each of these will ultimately lead to their respective closing parens
        //  after evaluating everything within them.
        if (newOp.equals("+")) numbers.push(unload(1, numbers));
        else if (newOp.equals("-")) numbers.push(unload(2, numbers));
        else numbers.push(unload(3, numbers));
      }

      //counting on always finding open parens before closing parens
      //upon finding closing parens, you finished the operations within it and
      //  its pair. return the results
      else if (numbers.peek().equals(")")) {
        numbers.pop();
        return result + "";
      }
    }

    //i don't think this should ever happen, but can't compile without it
    return result + "";
  }//end unload()

  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }


  //main method for testing
  public static void main( String[] args )
  {

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    //...7

    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
    System.out.println(zoo2);
    System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
    //...17

    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
    System.out.println(zoo3);
    System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
    //...29

    String zoo4 = "( - 1 2 3 )";
    System.out.println(zoo4);
    System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
    //...-4

    String zoo5 = "( + 1 ( + 1 ( + 1 1 ) 1 ) 1 )";
    System.out.println(zoo5);
    System.out.println("zoo5 eval'd: " + evaluate(zoo5) );
    //...6
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
