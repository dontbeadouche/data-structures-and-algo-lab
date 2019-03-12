import java.util.*;

class Program
{
  public static void main (String args[])
  {

    Scanner sc = new Scanner (System.in);
      System.out.print ("Enter length of array : ");
    int n = sc.nextInt ();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++)
      {
	System.out.print("Enter element : ");
	arr[i] = sc.nextInt ();
      }

    System.out.print("Enter element to search : ");
    int x = sc.nextInt ();

    long startTime = System.currentTimeMillis ();
    boolean q = Program.search (arr, n, x);
    System.out.print ("Element found : " + q);
    long endTime = System.currentTimeMillis ();
    long totalTime = endTime - startTime;
    System.out.println ("\nRunning Time : " + totalTime + " ms");
  }

  static boolean search (int arr[], int n, int x)
  {
    for (int i = 0; i < n; i++)
      {

	if (arr[i] == x)
	  return true;
      }

    return false;

  }

}
