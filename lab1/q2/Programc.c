
#import<stdio.h>
#import<time.h>
int
main ()
{
  


  clock_t start, end, tot;
  char arr[100];

  printf ("Enter expression : ");
  scanf ("%s", arr);
  int n = 0;
  while (arr[n] != '\0')
    {
      n++;
    }
  start = clock ();
  int bal;
  for (int i = 0; i < n; i++)
    {
      if (arr[i] == ')')
	bal++;
      else if (arr[i] == '(')
	bal--;
    }
  end = clock ();
  tot = end - start;
  printf ("\nBalanced expresssion : ");

  if (bal == 0)
    printf ("true");
  else
    printf ("false");
  printf ("\nRunning time : %d ms", tot);


return 0;
}
