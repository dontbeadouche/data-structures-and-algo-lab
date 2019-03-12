
import java.util.*;
class Program
{

  public static void main (String args[])
  {

    long start, end, tot;
    Scanner sc = new Scanner (System.in);
      System.out.print ("Enter size of array 1 : ");
    int n = sc.nextInt ();

      System.out.print ("Enter size of array 2 : ");
    int m = sc.nextInt ();

    int arr[]=new int[n];
    int arr2[]=new int[m];
System.out.println("Array 1 :" );
      Program.arrayscan (arr, n);
   System.out.println("Array 2:");
      Program.arrayscan (arr2, m);

      start = System.currentTimeMillis ();

    boolean bal = Program.commoncheck (arr, arr2, n, m);

      end = System.currentTimeMillis ();
      tot = end - start;
      System.out.print ("\nAny common element(s) : " + bal);

     System.out.print("\nRunning time : "+tot+ " ms");



  }
  public static boolean commoncheck (int arr[], int arr2[], int n, int m)

  {
    for (int i = 0; i < n; i++)
      {
	for (int j = 0; j < m; j++)
	  {
	    if (arr[i] == arr2[j])
	      return true;

	  }

      }
    return false;
  }
  public static void arrayscan (int arr[], int size)

  {
Scanner sc=new Scanner(System.in);
    for (int i = 0; i < size; i++)
     { System.out.print ("Enter element : ");
    	arr[i]=sc.nextInt();

    }
}
}
