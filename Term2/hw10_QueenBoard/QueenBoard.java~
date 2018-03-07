/*
  Joan Chirinos
  APCS2 pd08
  HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
  2018-02-27
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;

    /***
     * precondition: size > 0
     */
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition:
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	return solveH(0);
    }

  
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
        if (col == _board.length) return true;
	for (int row = 0; row < _board.length; row++) {
	    if (addQueen(row, col) && solveH(col + 1)) return true;
	    else removeQueen(row, col);
	}
	return false;
    }//end solveH


    public void printSolution()
    {
	String ret = "";
	for (int r = 0; r < _board.length; r++) {
	    for (int c = 0; c < _board[r].length; c++) {
		if (_board[r][c] == 1) ret += "Q\t";
		else ret += "_\t";
	    }
	    ret += "\n";
	}
	System.out.println(ret);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Replaces 0 at _board[row][col] with 1 and subtracts one from all the
     * spots with greater cols that a queen could "move" to
     * precondition: row, col < _board.length
     * postcondition: _board[row][col] == 0
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Replaces 1 at _board[row][col] with 0 and adds one from all the spots
     * with greater cols that the queen could previously "move" to 
     * precondition: row, col < _board.length
     * postcondition: returns (_board[row][col] == 1)
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Iterates through rows and cols of _board adding each element plus a \t
     * to String ans and separating each row with a new line character
     * precondition: 
     * postcondition: returns stringified board
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
	System.out.println(b);
	b.removeQueen(3,0);
	System.out.println(b);
	System.out.println("\nSolving a 1x1 board\n");
	b = new QueenBoard(1);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 2x2 board\n");
	b = new QueenBoard(2);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 3x3 board\n");
	b = new QueenBoard(3);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 4x4 board\n");
	b = new QueenBoard(4);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 5x5 board\n");
	b = new QueenBoard(5);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 6x6 board\n");
	b = new QueenBoard(6);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 7x7 board\n");
	b = new QueenBoard(7);
	b.solve();
	b.printSolution();
	System.out.println("\nSolving a 8x8 board\n");
	b = new QueenBoard(8);
	b.solve();
	b.printSolution();
    }
    
}//end class

/*
  We can see that a solution cannot be found for a 2x2 and a 3x3 board. This
  can be easily checked and it is clear why.
*/
