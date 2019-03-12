#include<stdio.h>
#include<time.h>
int
main ()
{
  clock_t start, end;
  int n, x;

  printf ("Enter length of array : ");
  scanf ("%d", &n);

  int arr[n];
  for (int i = 0; i < n; i++)
    {
      printf ("Enter element : ");
      scanf ("%d", &arr[i]);
    }
  printf ("Enter element to be searched : ");

  scanf ("%d", &x);
  start = clock ();
  int q = search (arr, n, x);
  printf ("Element found : ");
  printf (q == 1 ? "true" : "false");
  end = clock ();
  printf ("\nRunning time : %d ms", end - start);
  return 0;
}

int
search (int arr[], int n, int x)
{
  int i;
  for (i = 0; i < n; i++)
    if (arr[i] == x)
      return 1;

  return -1;
}
