#import<stdio.h>
#import<time.h>
int
main ()
{
  int n, m;

  clock_t start, end, tot;


  printf ("Enter size of array 1 : ");
  scanf ("%d",&n );
  printf ("\nEnter size of array 2 : ");

  scanf ("%d",&m);
  int arr[n], arr2[m];

printf("Array 1 :\n"); 
arrayscan (arr, n);
printf("Array 2 :\n"); 
  arrayscan (arr2, m);



  start = clock ();

int bal=  commoncheck (arr, arr2, n, m);

end = clock ();
  tot = end - start;
  printf ("\nAny common element(s) : ");

  if (bal == 1)
    printf ("true");
  else
    printf ("false");
  printf ("\nRunning time : %d ms", tot);


}

int
commoncheck (int arr[], int arr2[], int n, int m)
{
  for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < m; j++)
	{
	  if (arr[i] == arr2[j])
	    return 1;
	    

	}
      
    }
    return -1;
}

void
arrayscan (int arr[], int size)

{
  for (int i = 0; i < size; i++)
   { printf ("Enter element : ");
    scanf ("%d", &arr[i]);
}

}
