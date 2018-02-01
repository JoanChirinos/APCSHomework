public class Search {

  //prereq: nums is int[n][n]
  //        nums[r][c]: as r increases, nums[r][c] increases; as c increases, nums[r][c] increases
  public static int[] search(int[][] nums, int x) {
    int n = nums.length;
    int r = 0;
    int c = n - 1;
    int[] ret = {-1, -1};
    while (r < n && c >= 0) {
      if (nums[r][c] == x) {
        ret[0] = r;
        ret[1] = c;
        return ret;
      }
      else if (nums[r][c] > x) c--;
      else r++;
    }
    return ret;
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
    System.out.println(search(nums, 9)[0] + ", " + search(nums, 9)[1]);

    System.out.print("\nSearch for 8: ");
    System.out.println(search(nums, 8)[0] + ", " + search(nums, 8)[1]);
  }//end main

}//end class
