/*
  Joan Chirinos
  APCS2 pd08
  HW32 -- Leon Leonwood Stack
  2018-04-11
*/

/*****************************************************
* class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
*****************************************************/

public class Stckr
{
  public static void main( String[] args )
  {
    //Stack<Integer> cakes = new ALStack<Integer>();
    Stack<Integer> cakes = new LLStack<Integer>();

    System.out.println("Stack cakes:\n\t" + cakes);

    System.out.println("\ncakes is empty: " + cakes.isEmpty());

    System.out.println("\nPushing elements...");
    for (int i = 0; i < 10; i++) {
      cakes.push(i);
      System.out.println("\t" + cakes);
    }

    System.out.println("\ncakes is empty: " + cakes.isEmpty());

    System.out.println("\ntaking a peek shows: " + cakes.peek());
    System.out.println("cakes:\n\t" + cakes);

    System.out.println("\nPopping elements...\n\t" + cakes);
    while (!(cakes.isEmpty())) {
      System.out.println("popped " + cakes.pop());
      System.out.println("\t" + cakes);
    }

    System.out.println("\nCan I pop again?");
    try {
      cakes.pop();
      System.out.println("\tYes!");
    }
    catch (Exception e) {
      System.out.println("Nope!");
    }


  }//end main

}//end class
