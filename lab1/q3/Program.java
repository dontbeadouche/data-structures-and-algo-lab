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
	System.out.print ("Enter element : ");
	arr[i] = sc.nextInt ();
      }
long startTime=System.currentTimeMillis();

    boolean q = Program.checkDuplicate (arr, n);
	
	System.out.print("All unique elements in array : ");  
	System.out.println (q);
    long endTime=System.currentTimeMillis();
    long totalTime=endTime-startTime;
    System.out.println("\nRunning Time : "+totalTime+" ms");
   } 



  public static boolean checkDuplicate (int array[], int n)
  {
    int i, j;
    for (i = 0; i < n; i++)
      {
	for (j = i + 1; j < n; j++)
	  {
	    if (array[i] == array[j])
	      return false;

	  }
      }
    return true;
  }
}

