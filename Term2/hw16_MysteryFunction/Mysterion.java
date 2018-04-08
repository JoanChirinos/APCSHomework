/*
  Joan Chirinos
  APCS2 pd08
  HW16 -- About Face
  2018-03-07
*/

public class Mysterion {

  /***
  int separate(int[] arr, int start, int end, int pivot) separates the array, within
  start to end, at index pivot. The numbers to the left of pivot are < pivot, in no particular order
  It first swaps the pivot point to the end of the arr in order to "save it for late"
  Then, it goes through the array from start to finish, swapping the els at index s
  and i if array[i] < v. After it's done, it replaces the pivot at its original point
  ***/

  //public static int fxn(int[] arr, int a, int b, int c)
  public static int separate(int[] arr, int start, int end, int pivot) {
    System.out.print("\n\nOriginal: " + stringify(arr));
    int v = arr[pivot];
    System.out.println("\nv = " + v);
    swap(arr, pivot, end);
    System.out.println("After first swap: " + stringify(arr));
    int s = start;
    System.out.println("s = " + s);
    for (int i = start; i < end; i++) {
      if (arr[i] < v) {
        swap(arr, s, i);
        s++;
        System.out.println(stringify(arr) + "\ns = " + s);
      }
    }
    swap(arr, end, s);
    System.out.println("Final: " + stringify(arr));
    return s;
  }//end separate

  public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }//end swap

  public static String stringify(int[] arr) {
    String retStr = "[";
    for (int i : arr) {
      retStr += i + ", ";
    }
    if (arr.length != 0) retStr = retStr.substring(0, retStr.length() - 2);
    return retStr + "]";
  }

  public static void main(String[] args) {
    //Test case established in class
    int[] test = {7, 3, 5, 12, 1};
      //pivot at 7
    separate(test, 0, 4, 2);

      //pivot at 5
    separate(test, 0, 4, 4);

    //How does it dea with multiples
    int[] test2 = {5, 5, 5, 13, 12};
    separate(test2, 0, 4, 2);

    //What does it do to a list that's already sorted
    int[] test3 = {1, 2, 3, 4, 5, 6};
    separate(test3, 0, 5, 2);

    //Descending?
    int[] test4 = {6, 5, 4, 3, 2, 1};
    separate(test4, 0, 5, 2);
  }

}//end class
