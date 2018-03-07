/*
SooanhanAharinoi
Rohan Ahammed, Joan Chirinos, Soojin Choi
APCS2 pd08
HW15 -- Thinkers of the Corn
2018-03-06
*/
/***
* SKEELTON for class
* MazeSolver
* Implements a blind depth-first exit-finding algorithm.
* Displays probing in terminal.
*
* USAGE:
* $ java Maze [mazefile]
* (mazefile is ASCII representation of maze, using symbols below)
*
* ALGORITHM for finding exit from starting position:
*  If you are in the void or a wall, return again and try another space to move to. If you are in the exit, stop. You have solved the problem. If you are on the path, choose 1 of the 4 directions adjacent to you to move to and try to find the exit. If you fail to find the exit, try another adjacent direction to go to in order to find the exit.
***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  private char[][] maze;
  private int h, w; //height, width of maze
  private boolean solved;

  //initialize constants for map component symbols
  final private char HERO =         '@';
  final private char PATH =         '#';
  final private char WALL =         ' ';
  final private char EXIT =         '$';
  final private char VISITED_PATH = '.';


  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
        w = line.length();

        for( int i=0; i<line.length(); i++ )
        maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
      maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    solved = false;
  }//end constructor


  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
      retStr = retStr + maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }


  //helper method to keep try/catch clutter out of main flow
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /*********************************************
  * void solve(int x,int y) -- recursively finds maze exit (depth-first)
  * @param x starting x-coord, measured from left
  * @param y starting y-coord, measured from top
  *********************************************/
  public void solve( int x, int y ) {

    delay(50); //slow it down enough to be followable

    //primary base case
    if ( solved ) {
      System.exit(0);
    }
    //other base case(s)...
    else if ( x > w - 1 || y > h - 1 || x < 0 || y < 0) {
      return;
    }
    else if ( maze[x][y] == EXIT)  {
      solved = true;
    }
    else if ( maze[x][y] != PATH ) {
      return;
    }
    //recursive reduction
    else {
      maze[x][y] = HERO;
      System.out.println(this);
      solve(x + 1, y);
      solve(x - 1, y);
      solve(x, y + 1);
      solve(x, y - 1);

      maze[x][y] = PATH;
    }
  }

  public void solveDefined(int x, int y) {
    maze[x][y] = '#';
    this.solve(x, y);
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

  public char[][] getMaze() { return maze; }
  public void set(int x, int y, char setTo) { maze[x][y] = setTo; }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    try {
      String mazeInputFile = args[0];

      MazeSolver ms = new MazeSolver( mazeInputFile );
      //clear screen
      System.out.println( "[2J" );

      //display maze
      System.out.println( ms );

      //drop hero into the maze (coords must be on path)
      //comment next line out when ready to randomize startpos
      // ms.solve( 4, 3 );



      char[][] maze = ms.getMaze();
      for (int r = 0; r < maze.length; r++) {
        for (int c = 0; c < maze[r].length; c++) {
          if (maze[r][c] == '@') {
            ms.set(r, c, '#');
            ms.solve(r, c);
            System.exit(0);
          }
        }
      }

      //drop our hero into maze at random location on path
      //the Tim Diep way:
      Random r = new Random();
      int startX = r.nextInt( 80 );
      int startY = r.nextInt( 25 );
      while ( !ms.onPath(startX,startY) ) {
        startX = r.nextInt( 80 );
        startY = r.nextInt( 25 );
      }

      ms.solve( startX, startY );
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "Usage: java Maze <filename>" );
    }
  }

}//end class Maze
