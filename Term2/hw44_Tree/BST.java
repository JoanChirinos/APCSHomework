/*
Joan Chirinos, Shruthi Venkata
APCS2 pd08
HW43 -- BSTs is the Perfect Place for Shade
2018-05-01
*/

/*****************************************************
* class BST - v1:partial
* Implementation of the BINARY SEARCH TREE abstract data type (ADT)
*
* A BST maintains the invariant that, for any node N with value V,
* L<V && V<R, where L and R are node values in N's left and right
* subtrees, respectively.
* (Any value in a node's left subtree must be less than its value,
*  and any value in its right subtree must be greater.)
* This BST only holds ints (its nodes have int cargo)
*****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
  * default constructor
  *****************************************************/
  BST( )
  {
    _root = null;
  }

  /*****************************************************
  * void insert( int )
  * Adds a new data element to tree.
  *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
      stRoot.setLeft( newNode );
      else //recurse down left subtree
      insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
      stRoot.setRight( newNode );
      else //recurse down right subtree
      insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  /*****************************************************
  * TreeNode search(int)
  * returns pointer to node containing target,
  * or null if target not found
  *****************************************************/
  TreeNode search( int target )
  {
    TreeNode n = _root;
    while (n != null && n.getValue() != target) {
      if (n.getValue() < target) {
        n = n.getLeft();
      }
      else n = n.getRight();
    }
    return n;
  }


  /*****************************************************
  * int height()
  * returns height of this tree (length of longest leaf-to-root path)
  * eg: a 1-node tree has height 0
  *****************************************************/
  public int height()
  {
    return height(_root);
  }

  public int height(TreeNode t)
  {
    //no more height if a leaf is reached
    if (t == null || t.isLeaf()) return 0;

    int r = height(t.getRight());
    int l = height(t.getLeft());

    //find maximum height of either right or left subtree
    int max = (r < l) ? l : r;

    //add 1 to height to account for current level
    return 1 + max;
  }


  /*****************************************************
  * int numLeaves()
  * returns number of leaves in tree
  *****************************************************/
  public int numLeaves()
  {
    return numLeaves(_root);
  }

  public int numLeaves(TreeNode t)
  {
    if (t == null) return 0;
    //isLeaf (in TreeNode) returns true if both right and left subtrees are null
    if (t.isLeaf()) return 1;
    return numLeaves(t.getRight()) + numLeaves(t.getLeft());
  }

  public void remove(int i)
  {
    TreeNode[] l = parentChildFinder(i);
    TreeNode parent = l[0];
    TreeNode toRemove = l[1];
    int d = (parent.getLeft() == toRemove) ? 0 : 1;

    //leaf
    if (toRemove.isLeaf()) {
      if (d == 0) {
        parent.setLeft(null);
      }
      else parent.setRight(null);
    }

    //2 childs
    if (toRemove.getLeft() != null && toRemove.getRight() != null) {
      if (d == 0) {
        //need to find max
        TreeNode max, maxP;
        max = maxP = null;
        max = toRemove;
        while (max.getRight() != null) {
          maxP = max;
          max = max.getRight();
        }

        //set the parent of max to max's child
        maxP.setRight(max.getLeft());

        //make max point to toRemove's children
        max.setRight(toRemove.getRight());
        max.setLeft(toRemove.getLeft());

        //kill toRemove
        parent.setLeft(max);
      }
      else { //if d == 1
        //need to find min
        TreeNode min, minP;
        min = minP = null;
        min = toRemove;
        while (min.getLeft() != null) {
          minP = min;
          min = min.getLeft();
        }

        //set the parent of max to max's child
        minP.setLeft(min.getRight());

        //make max point to toRemove's children
        min.setRight(toRemove.getRight());
        min.setLeft(toRemove.getLeft());

        //kill toRemove
        parent.setLeft(min);
      }
    }

    //1 child
    if (toRemove.getRight() != null) {
      if (d == 0) {
        parent.setLeft(toRemove.getRight());
      }
      else parent.setRight(toRemove.getRight());
    }
    else {
      if (d == 0) {
        parent.setLeft(toRemove.getLeft());
      }
      else parent.setRight(toRemove.getLeft());
    }

  }

  private TreeNode[] parentChildFinder(int i)
  {
    TreeNode n = _root;
    TreeNode parent = null;
    while (n != null && n.getValue() != i) {
      parent = n;
      if (n.getValue() < i) {
        n = n.getLeft();
      }
      else n = n.getRight();
    }
    TreeNode[] t = {parent, n};
    return t;
  }

  /*
    look I'm very tired and I can't think anymore so I didn't finish but I'm trynna sleep
  */


  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");

    System.out.println("\nfound 4: " + (arbol.search(4) != null && arbol.search(4).getValue() == 4));
    System.out.println("found 25: " + (arbol.search(25) != null && arbol.search(25).getValue() == 25));
    System.out.println("height: " + arbol.height());
    System.out.println("number of leaves: " + arbol.numLeaves());

    System.out.println("\nremoving node with value 1");
    arbol.remove(1);
    System.out.print("in: ");
    arbol.inOrderTrav();
    System.out.print("\npre: ");
    arbol.preOrderTrav();

    System.out.println("\nremoving node with value 3");
    arbol.remove(3);
    System.out.print("in: ");
    arbol.inOrderTrav();
    System.out.print("\npre: ");
    arbol.preOrderTrav();

    System.out.println("\nremoving node with value 1");
    arbol.remove(2);
    System.out.print("in: ");
    arbol.inOrderTrav();
    System.out.print("\npre: ");
    arbol.preOrderTrav();
    System.out.println();

    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
