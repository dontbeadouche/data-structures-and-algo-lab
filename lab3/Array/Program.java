import java.util.*;

class Queue
{

  public static int MAX = 100;
  int arr[] = new int[MAX];
  private int front, rear;

    Queue ()
  {
    front = rear = -1;
  }

  public boolean isEmpty ()
  {
    return (front == -1 && rear == -1);
  }

  public void Enqueue (int x)
  {


    if ((rear + 1) % MAX == front)
      {
	System.out.println ("Queue is full");
	return;
      }

    else if (isEmpty ())
      {
	front = rear = 0;
      }

    else
      {
	rear = (rear + 1) % MAX;
      }
    arr[rear] = x;
  }


  public int Dequeue ()
  {
    System.out.println ("Dequeuing ...");

    int f = front;
    if (isEmpty ())
      {
	return f;

      }

    else if (front == rear)
      {
	front = rear = -1;
	return f;
      }

    else
      {
	front = (front + 1) % MAX;
	return f;
      }
  }

  public int Front ()
  {
    if (front == -1)
      {
      	System.out.println ("Queue is Empty");
	return -1;
      }

    return arr[front];
  }

  public int Size ()
  {
    return ((rear + MAX - front) % MAX + 1);


  }

  public void Display ()
  {
    System.out.print ("Queue :  ");

    for (int i = 0; i < Size (); i++)
      {
	System.out.print (arr[front + i] % MAX + "  ");

      }
    System.out.println ();
  }

}

class Program
{

  public static void main (String args[])
  {

    Queue Q = new Queue ();

      Q.Enqueue (8);
      Q.Enqueue (25);
      Q.Enqueue (5);
      Q.Display ();
      Q.Dequeue ();
      Q.Display ();
      Q.Enqueue (13);
      Q.Display ();
      Q.Dequeue ();
      Q.Display ();
  }
}
