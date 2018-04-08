/*
  Joan Chirinos
  APCS2 pd08
  HW21 -- Linked Lists
  2018-03-18
*/

public class LList implements List {

  private LLNode first;
  private int size;

  //initiates LList only with size 0
  public LList() {
    size = 0;
  }

  //adds a LLNode with cargo of String x onto the next of the last node, replacing null
  public boolean add(String x) {
    LLNode toAdd = new LLNode();
    toAdd.setCargo(x);
    if (size == 0) {
      first = toAdd;;
    }
    else {
      LLNode toChange = first;
      for (int i = this.size() - 1; i > 0; i--) {
        toChange = toChange.getNext();
      }
      toChange.setNext( toAdd );
    }
    size++;
    return true;
  }

  //returns cargo of ith node
  public String get(int i) {
    if (i >= size) {
      throw new IndexOutOfBoundsException();
    }
    LLNode toGetFrom = first;
    for ( ; i > 0; i--) {
      toGetFrom = toGetFrom.getNext();
    }
    return toGetFrom.getCargo();
  }

  //replaces node in position i with new node of cargo String x
  public String set(int i, String x) {
    if (i >= size) {
      throw new IndexOutOfBoundsException();
    }
    LLNode toSetTo = first;
    for ( ; i > 0; i--) {
      toSetTo = toSetTo.getNext();
    }
    return toSetTo.setCargo(x);
  }

  //returns the size of the LList
  public int size() {
    return size;
  }

  //returns the LList as concatenation of its nodes' toStrings
  public String toString() {
    if (this.size() == 0) return "";
    return first.toString();
  }

  public static void main(String[] args) {
    LList l1 = new LList();
    System.out.println("Empty LList l1:\n\t" + l1);

    l1.add("The cargo goes...");
    System.out.println("\nl1 after l1.add(\"The cargo goes\")\n\t" + l1);

    l1.add("...where the car goes");
    System.out.println("\nl1 after l1.add(\"...where the car goes\")\n\t" + l1);

    l1.set(0, "xd I didn't have much to add");
    System.out.println("\nl1 after l1.set(0, \"xd I didn't have much to add\")\n\t" + l1);

    System.out.println("\nl1.get(1) --> " + l1.get(1));

    System.out.println("\n========================================\n");

    LList l2 = new LList();
    for (int i = 1; i < 5; i++) {
      l2.add("and a " + i);
    }
    System.out.println("l2: " + l2);
    System.out.println("\tsize: " + l2.size() + "\n\tl2.get(2): " + l2.get(2));
  }

}
