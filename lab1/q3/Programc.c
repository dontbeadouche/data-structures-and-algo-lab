#include<stdio.h>
#include<time.h>

int
main ()
{
  clock_t start_t, end_t;

  int n;
  printf ("Enter length of array : ");
  scanf ("%d",&n);
  int arr[n];
  for (int i = 0; i < n; i++)
    {

      printf ("Enter element : ");
      scanf ("%d",&arr[i]);

    }
  start_t = clock ();
  int q = checkDuplicate (arr, n);

  printf ("All unique elements in array : ");
  printf (q==1 ? "true" : "false");
  end_t = clock ();
  printf ("\nRunning time : %d ms", end_t - start_t);

 return 0;

}
int checkDuplicate( int array[], int n)

{
 int i,j;
  for( i = 0; i < n; i++ )
   {
     for( j = i+1; j < n; j++ )
       {
          if( array[i] == array[j] )
	      return -1;
	        }
		 }
		  return 1;
		  }
		   


