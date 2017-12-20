/*
  Joan Chirinos
  APCS1 pd08
  HW57 -- How deep does the rabbit hole go?
  2017-12-19
*/

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    // O(DEFEAULT_SIZE ^ 2) --> O(n^2)
    public Matrix( ) 
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    // O(a^2) --> O(n^2)
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    // O(1)
    private int size() 
    {
	return matrix.length;
    }


    //return the item at the specified row & column
    // O(1)
    private Object get( int r, int c ) 
    {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    // O(n^2)
    private boolean isEmpty() 
    {
	for (int r = 0; r < this.size(); r++)
	    for (int c = 0; c < this.size(); c++)
		if (this.get(r, c) == null) return true;
	return false;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    // O(1)
    private Object set( int r, int c, Object newVal ) 
    {
	Object temp = this.get(r, c);
	matrix[r][c] = newVal;
	return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    // O(n^2)
    public String toString() 
    {
	String retStr = "-";
	for (int col = 0; col < matrix[0].length; col++) {
	    retStr += " ";
	    if (matrix[0][col] == null) retStr += "    ";
	    else for (int i = 0; i < ((String)(matrix[0][col])).length(); i++)
		     retStr += " ";
	}
	retStr += " -\n";
	for (int r = 0; r < this.size(); r++) {
	    retStr += "| ";
	    for (int c = 0; c < this.size(); c++)
		retStr += this.get(r, c) + " ";
	    retStr += "|\n";
	}
	retStr += "- ";
	for (int col = 0; col < matrix[0].length; col++) {
	    retStr += " ";
	    if (matrix[0][col] == null) retStr += "    ";
	    else for (int i = 0; i < ((String)(matrix[0][col])).length(); i++)
		     retStr += " ";
	}
	retStr += "-";
	return retStr;
	
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    // O(n^2)
    public boolean equals( Object rightSide ) 
    {
	if (!(rightSide instanceof Matrix)) {
	    return false;
	}
	if (((Matrix)rightSide).size() != this.size()) return false;
	for (int r = 0; r < this.size(); r++)
	    for (int c = 0; c < this.size(); c++) {
		Object valone = this.get(r, c);
		Object valtwo = ((Matrix)rightSide).get(r, c);
		if (!(valone.equals(valtwo)))
		    return false;
	    }
	return true;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    // O(n)
    public void swapColumns( int c1, int c2  ) 
    {
	if (c1 < 1 || c2 < 1) {
	    System.out.println("Invalid column(s)");
	    return;
	}
	c1--;
	c2--;
	for (int r = 0; r < this.size(); r++)
	    this.set(r, c2, this.set(r, c1, this.get(r, c2)));
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    // O(n)
    public void swapRows( int r1, int r2  ) 
    {
	if (r1 < 1 || r2 < 1) {
	    System.out.println("Invalid row(s)");
	    return;
	}
	r1--;
	r2--;
	for (int c = 0; c < this.size(); c++)	    
	    this.set(r1, c, this.set(r2, c, this.get(r1, c)));
    }

    //populates Matrix with characters
    //if random = true, then it populates with random characters
    //if random = false, then it populates with ordered characters
    // O(n^2)
    public void charPop(boolean random) {
	String alp = "abcdefghijklmnopqrstuvwxyz";
	if (!random) {
	    int alpi = 0;
	    for (int r = 0; r < this.size(); r++)
		for (int c = 0; c < this.size(); c++) {
		    this.set(r, c, alp.substring(alpi, alpi + 1));
		    alpi++;
		    alpi %= 26;
		}
	}
	else {
	    for (int r = 0; r < this.size(); r++)
		for (int c = 0; c < this.size(); c++) {
		    int rind = (int)(Math.random() * 26);
		    this.set(r, c, alp.substring(rind, rind + 1));
		}
	}
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	Matrix m = new Matrix(4);
	System.out.println("\nNewly Initialized Matrix m:\n" + m);
	System.out.println("Is m empty?\t" + m.isEmpty());
	m.charPop(false);
	System.out.println("Matrix m:\n" + m);
	System.out.println("Is m empty now?\t" + m.isEmpty());
	m.swapRows(1, 3);
	System.out.println("Matrix m after swapping row 1 with row 3:\n" + m);
	m.swapColumns(1, 3);
	System.out.println("Matrix m after swapping col 1 with col 3:\n" + m);
	System.out.println("\n=========================================\n");
	Matrix mat = new Matrix();
	Matrix pat = new Matrix();
	Matrix lol = new Matrix();
	mat.charPop(false);
	pat.charPop(false);
	lol.charPop(true);
	System.out.println("Matrix mat:\n" + mat);
	System.out.println("Matrix pat:\n" + pat);
	System.out.println("Matrix lol:\n" + lol);
	System.out.println("mat.equals(pat) --> " + mat.equals(pat));
	System.out.println("pat.equals(lol) --> " + pat.equals(lol));
    }

}//end class Matrix
