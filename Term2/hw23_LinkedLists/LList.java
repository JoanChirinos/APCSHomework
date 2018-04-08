//Team SushiWithCheerios
//Joan Chirinos, Shruthi Venkata
//APCS2 pd8
//HW23 -- Give and Take
//2018-03-22

public class LList {

  //instance vars
  private LLNode _liste;
  private int _size;

  //default constructor
  public LList( )
  {
    _liste = null;
    _size = 0;
  }

  public boolean add( String newVal )
  {
    _liste = new LLNode( newVal, _liste );
    _size++;
    return true;
  }

  public boolean add(int index, String newVal) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      _liste = new LLNode(newVal, _liste);
    }
    else {
      LLNode temp = _liste; //alias
      for( ; index > 0; index-- ) //don't need to instantiate new int
        temp = temp.getNext();

      temp.setNext(new LLNode(newVal, temp.getNext())); //cool one-liner woot woot
    }

    _size++;

    return true;
  }

  public String remove(int index) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    String old;

    if (index == 0) {
      old = _liste.getCargo();
      _liste = _liste.getNext();
    }
    else {
      LLNode temp = _liste; //alias
      for( ; index > 1; index-- ) //don't need to instantiate new int
      temp = temp.getNext();

      old  = temp..getNext().getCargo();

      temp.setNext(temp.getNext().getNext());
    }

    _size--;
    return old;
  }

  public String get( int index ) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    LLNode temp = _liste; //alias
    for( int i=0; i < index; i++ )
    temp = temp.getNext();

    return temp.getCargo();
  }

  public String set( int index, String newVal )
  {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    LLNode temp = _liste; //alias
    for( int i=0; i < index; i++ )
    temp = temp.getNext();

    String old = temp.getCargo();
    temp.setCargo( newVal );
    return old;
  }

  //accessor
  public int size() {
    return _size;
  }

  //for testing purposes
  public String toString() {
    String str = "";
    LLNode temp = _liste; //init tr
    while( temp != null ) {
      str += temp.getCargo() + ", ";
      temp = temp.getNext();
    }
    str += "null";
    return str;
  }

  public static void main( String[] args ) {
    LList list = new LList();

    System.out.println( list );

    list.add("crepe ");
    System.out.println( list );

    list.add("a ");
    System.out.println( list );

    list.add("would like ");
    System.out.println( list );

    list.add("I ");
    System.out.println( list );


    System.out.println( "index 0 " + list.get(0));
    System.out.println( "index 1 " + list.get(1));
    System.out.println( "index 2 " + list.get(2));
    System.out.println( "index 3 " + list.get(3));

    System.out.println("replacing 1st index with 'want'");
    list.set( 1, "want" );
    System.out.println( "index 1 " + list.get(1));

    System.out.println( list );

    System.out.println("adding nutella at index 3");
    list.add(3, "nutella ");
    System.out.println( list );

    System.out.println("removing contents of index 3");
    list.remove(3);
    System.out.println( list );

    list.add(0, "Jeebus");
    System.out.println("\n\n" + list);

    list.remove(0);
    System.out.println("\n\n" + list);
  }
}
