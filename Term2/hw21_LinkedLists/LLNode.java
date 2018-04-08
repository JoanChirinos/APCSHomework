/*
  Joan Chirinos
  APCS2 pd08
  HW21 -- Linked Lists
  2018-03-18
*/

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String cargo;
    private LLNode next;

    // constructor
    public LLNode() {
      setCargo(null);
      setNext(null);
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
      return cargo;
    }

    public LLNode getNext()
    {
      return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String newCargo)
    {
      String oldCargo = cargo;
      cargo = newCargo;
      return oldCargo;
    }

    public LLNode setNext(LLNode newNext)
    {
      LLNode oldNext = next;
      next = newNext;
      return oldNext;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
      if (next == null) {
        return cargo;
      }
      return cargo + " | " + next.toString();
    }


    //main method for testing
    public static void main( String[] args )
    {
      LLNode node1 = new LLNode();
      System.out.println("Blank LLNode:\n\t" + node1);

      node1.setCargo("The cargo goes...");
      System.out.println("\nAfter node1.setCargo(\"The cargo goes\"):\n\t" + node1);


      LLNode node2 = new LLNode();
      node2.setCargo("...where the car goes");
      System.out.println("\nnode2:\n\t" + node2);

      node1.setNext(node2);
      System.out.println("\nnode1 after node1.setNext(node2):\n\t" + node1);
    }//end main

}//end class LLNode
