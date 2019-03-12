
#include<stdio.h>
#define MAX 100

int S[MAX];
int top = -1;



int
size ()
{
  return top + 1;
}

void
push (int x)
{

  if (size () == MAX - 1)
    {
      printf ("STACK OVERFLOW !\n");
    }
  else
    {
      S[++top] = x;
    }
}

int
isEmpty ()
{

  if (top == -1)
    {
      return 1;
    }
  else
    {
      return 0;
    }
}

void
pop ()
{
  int y = isEmpty ();
  if (y == 1)
    {
      printf ("STACK UNDERFLOW !\n");
    }
  else
    {
      top--;
    }
}

int
Top ()
{
  return S[top];
}

void
Print ()
{

  printf ("Stack : ");
  for (int i = 0; i <= top; i++)
    {
      printf (" %d ", S[i]);

    }
  printf ("\n");
}

int
main ()
{

  push (2);
  Print ();
  push (6);
  Print ();
  pop ();
  Print ();
  push (5);
  Print ();
  push (3);
  Print ();
  int s = size ();
  printf ("current size : %d", s);


  return 0;

}
