import java.util.*;

class Program
{
	public static void main (String args[])
  {

    char arr[];
    Scanner sc = new Scanner (System.in);
      System.out.print ("Enter expression : ");
      arr = (sc.nextLine ()).toCharArray ();

    int n = arr.length;

    int bal=0;
    long start=System.currentTimeMillis();
    for (int i = 0; i < n; i++)
	  {
	  if(arr[i]==')')
	  	bal++;


	else if (arr[i] == '(')
	  bal--;
	  }
	  
	long end=System.currentTimeMillis();	  
	  System.out.print("\nBalanced expression  : "); 

	  if (bal == 0)
	  System.out.println ("True");

	else
	  System.out.println ("False");

        
	System.out.println("Running time : "+(end-start)+" ms");
}

}



