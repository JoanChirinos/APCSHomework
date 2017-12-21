/*
  Joan Chirinos
  APCS1 pd08
  HW59 -- Make the Matrix Work For You
  2017-12-20
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

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix()
    {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return _matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return _matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) 
    {
	return get(r,c) == null;

    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	Object retVal = _matrix[r-1][c-1];
	_matrix[r-1][c-1] = newVal;
	return retVal;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {
	String foo = "";
	for( int i =0; i < size(); i++ ) {
	    foo += "| ";
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	
	return foo;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	boolean foo = false;

	if (this == rightSide) foo = true;  
	// checks for aliases  ex. m1.equals(m1) is true

	else if ( rightSide instanceof Matrix 
		  && size() == ( (Matrix)rightSide).size() ) {
	    Matrix r = (Matrix) rightSide; //for cleaner code later
	    foo = true;
	    outer:
	    for( int i = 0; i < size(); i++ ) {
		for( int j = 0; j < size(); j++ ) {
		    if ( !isEmpty(i,j) && ( !get(i,j).equals(r.get(i,j) ) ) ) {
			foo = false;
			break outer;
		    }
		    else if ( !( isEmpty(i,j) && r.isEmpty(i,j) ) ) {
			foo = false;
			break outer;
		    }
		}
	    }
	}
	return foo;
    }//end equals()



    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	c1 = c1-1;
	c2 = c2-1;
    
	for( int i = 0; i < size(); i++ ) {
	    set( i, c1, set( i, c2, get(i,c1) ) );
	}
    }//O(n) b/c must visit n rows


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	r1 = r1-1;
	r2 = r2-2;
	Object [] temp = _matrix[r1];
	_matrix[r1] = _matrix[r2];
	_matrix[r2] = temp; 
    }//O(1)


    //            PHASE 2
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //returns copy(!) of row r
    public Object[] getRow( int r )
    {
	Object[] arr = new Object[size()];
	for (int i = 0; i < size(); i++)
	    arr[i] = _matrix[r - 1][i];
	return arr;
    }//O(?)

    //replaces row r with 1D array newRow
    //returns old row
    public Object[] setRow( int r, Object[] newRow )
    {
	Object[] ret = _matrix[r - 1];
	_matrix[r - 1] = newRow;
	return ret;
    }//O(1)

    //replaces elements of column c with elements of 1D array newCol
    //returns old column
    public Object[] setCol( int c, Object[] newCol )
    {

	Object[] ret = new Object[size()];
	for (int j = 0; j < size(); j++)
	    ret[j] = _matrix[j][c - 1];
	for (int i = 0; i < newCol.length && i < size(); i++)
	    _matrix[i][c - 1] = newCol[i];
	return ret;
	
    }//O(n)

    //M[i,j] -> M[j,i] for all i,j
    public void transpose()
    {
	for (int r = 0; r < size(); r++)
	    for (int c = 0; c < r; c++) {
		Object temp = _matrix[r][c];
		_matrix[r][c] = _matrix[c][r];
		_matrix[c][r] = temp;
		//set(r, c, set(c, r, get(r, c)));
	    }
    }//O(?)
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   
    
    //main method for testing
    public static void main( String[] args ) 
    {
	/*
	Matrix m1 = new Matrix(); // 2 x 2
	Matrix m2 = new Matrix(10); // 10 x 10
	System.out.println("m1 size: " + m1.size());
	System.out.println("m2 size: " + m2.size());
	System.out.println("m1 get(1,1) : " + m1.get(1,1));
	System.out.println("m1 isEmpty(1,1) : " + m1.isEmpty(1,1));	

	Matrix x = new Matrix(2); // 2x2
	System.out.println(x);
	x.set(1,1,"how"); 
	x.set(1,2,"now"); 
	x.set(2,1,"bro"); 
	x.set(2,2,"cow"); 
	System.out.println(x);

	Matrix m3 = new Matrix(3); //3x3
	System.out.println(m1);
	*/

	Matrix m1 = new Matrix(4);
	System.out.println("m1:\n" + m1);
	for (int r = 1; r < 5; r++)
	    for (int c = 1; c < 5; c++)
		m1.set(r, c, (((r - 1) * 4) + c - 1) % 8);
	System.out.println("m1 after populating:\n" + m1);
	
	Object[] r = {"l", "m", "a", "o"};
	System.out.println("\nObject[] r: [l,m,a,o]");
	m1.setRow(1, r);
	System.out.println("m1 after m1.setRow(1, r):\n" + m1);
	
	Object[] c = {"O", "N", "o", "!"};
	System.out.println("\nObject[] c: [O,N,o,!]");
	m1.setCol(4, c);
	System.out.println("m1 after m1.setCol(4, c):\n" + m1);

	m1.transpose();
	System.out.println("\nm1 after transposing:\n" + m1);
	
    }//end main()

}//end class Matrix
