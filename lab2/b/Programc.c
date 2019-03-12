#include<stdio.h>
#include<string.h>
#define MAX 100
int top = -1;
char stack[MAX];

void
push (char x)
{

  if (top == MAX - 1)
    {
      printf ("STACK OVERFLOW !\n");
    }
  else
    {
      stack[++top] = x;
    }
}

char
pop ()
{


  if (top == -1)
    {
      printf ("STACK UNDERFLOW !\n");
    }
  else
    {
      return stack[top--];

    }
}

int
match_paranthesis (char a, char b)
{
  if (a == '[' && b == ']')
    {
      return 1;
    }
  else if (a == '{' && b == '}')
    {
      return 1;
    }
  else if (a == '(' && b == ')')
    {
      return 1;
    }
  return 0;
}

int
check_paranthesis (char expression[])
{
  int count;
  char temp;
  for (count = 0; count < strlen (expression); count++)
    {
      if (expression[count] == '(' || expression[count] == '{'
	  || expression[count] == '[')
	{
	  push (expression[count]);
	}
      if (expression[count] == ')' || expression[count] == '}'
	  || expression[count] == ']')
	{
	  if (top == -1)
	    {
	      printf
		("The Right Parentheses are more than the Left Parentheses\n");
	      return 0;
	    }
	  else
	    {
	      temp = pop ();
	      if (!match_paranthesis (temp, expression[count]))
		{
		  printf
		    ("The Mismatched Parentheses in the Expression are:\t%c and %c\n",
		     temp, expression[count]);
		  return 0;
		}
	    }
	}
    }
  if (top == -1)
    {
      printf ("The Expression has Balanced Parentheses\n");
      return 1;
    }
  else
    {
      printf ("The Expression has unbalanced parentheses\n");
      return 0;
    }
}

int
main ()
{

  char exp[MAX];
  int p;
  printf ("Enter expression : ");
  scanf ("%s", exp);
  printf ("\n");
  p = check_paranthesis (exp);

  if (p == 1)
    {
      printf ("Hence valid expression");
    }
  else
    {
      printf ("Hence invalid expression");
    }
  return 0;
}
