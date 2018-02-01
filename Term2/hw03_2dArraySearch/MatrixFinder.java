/*
  Team IDontReallyMindAnything - Joan Chirinos, Rohan Ahammed, Soojin Choi
  APCS2 pd08
  HW02 -- I Am Still Searching
  2018-2-1
*/
  
/**
 * MatrixFinder searches for a term in a semi-ordered 2d array in O(n)
 * The array must fit the following restrictions:
 *   Given any row, the elements increase from left to right
 *   Given any column, the elements increase from top to bottom
 * The search method searches for int x in int[][] nums by starting at the last
 * element of the first row. If this element is too high, it will test the
 * previous element of the same row. If this element is too low, it will search
 * the element in the next row of the same column. If the searching causes the
 * row or column to go out of bounds, it returns "(-1, -1)", meaning that the
 * search term is not found. If the search term was found, it returns "(r, c)"
 **/

public class MatrixFinder {

    //prereq: nums follows the above limitations
    public static String search(int[][] nums, int x) {
	int r = 0;
	int c = nums.length - 1;
	//"while you're still within the bounds of the int[][]"
	while (r < nums.length && c >= 0) {
	    if (nums[r][c] == x) {
		return "(" + r + ", " + c + ")";
	    }
	    else if (nums[r][c] > x) c--;
	    else r++;
	}
	return "(-1, -1)";
    }//end search

    public static void main(String[] args) {
	int[][] nums = { {1, 3, 5}, {3, 7, 8}, {5, 12, 15} };
	for (int[] a : nums) {
	    for (int i : a) {
		System.out.print(i + " ");
	    }
	    System.out.println();
	}
	System.out.print("Search for 9: ");
	System.out.println(search(nums, 9));

	System.out.print("\nSearch for 8: ");
	System.out.println(search(nums, 8));
    }//end main

}//end class
