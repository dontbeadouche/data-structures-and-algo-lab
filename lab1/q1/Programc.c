#include<stdio.h>
#include<time.h>

int
main ()
{
  clock_t start, end;
  char st[100];
  printf ("Enter char array : ");
  scanf ("%s", st);
  int count = 0;
  while (st[count] != '\0')
    {
      count++;
    }

  char stcp[100];
  int i, j = 0;
  start=clock();
  for (i = count - 1; i >= 0; i--)
    {
      stcp[j] = st[i];
      j++;
    }
end=clock();
  printf("Reversed array : ");
  puts (stcp);
  printf("Running time : %d ms",end-start);
  return 0;
}

