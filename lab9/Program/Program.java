import java.util.*;
class Process
{

  String pid;
  int btime;

  public Process (String p, int b)
  {
    this.pid = p;
    this.btime = b;
  }
}


class MinHeap
{

  public Process[] data;
  public int heapSize;

  public MinHeap (int size)
  {
    data = new Process[size];
    heapSize = 0;
  }

  public int getmin ()
  {
    if (heapSize == 0)
      {
	throw new RuntimeException ("Size full");
      }
    else
      return data[0].btime;
  }

  public int getLeftChildIndex (int i)
  {
    return 2 * i + 1;
  }

  public int getRightChildIndex (int i)
  {
    return 2 * i + 2;
  }

  public int getParentIndex (int i)
  {
    return (i - 1) / 2;
  }

  public void Insert (String p, int b)
  {
    if (heapSize == data.length)
      {
	System.out.println ("Heap Full");
      }
    else
      {

	Process pr = new Process (p, b);
	heapSize++;
	data[heapSize - 1] = pr;
	Upheap (heapSize - 1);
      }
  }

  public void Upheap (int last)
  {
    int parent;
    Process temp;

    if (last != 0)
      {
	parent = getParentIndex (last);
	if (data[parent].btime > data[last].btime)
	  {
	    temp = data[parent];
	    data[parent] = data[last];
	    data[last] = temp;
	    Upheap (parent);
	  }
      }

  }

  public void removeMin ()
  {
    if (heapSize == 0)
      throw new RuntimeException ("Heap is empty");
    else
    {

      data[0] = data[heapSize - 1];
      data[heapSize - 1] = data[0];
      heapSize--;
      if (heapSize > 0)
	DownHeap (0);
    }
  }

  public void DownHeap (int first)
  {
    int left, right, min;
    Process temp;
    left = getLeftChildIndex (first);
    right = getRightChildIndex (first);

    if (right >= heapSize)
      {
	if (left >= heapSize)
	  return;
	else
	  min = left;
      }
    else
      {
	if (data[left].btime <= data[right].btime)
	  min = left;
	else
	  min = right;
      }

    if (data[first].btime > data[min].btime)
      {
	temp = data[min];
	data[min] = data[first];
	data[first] = temp;
	DownHeap (min);
      }

  }

  public void HeapSort ()
  {
    int i;
    int k = heapSize;
    Process arr[] = new Process[heapSize];

    for (i = 0; i < k; i++)
      {
	arr[i] = data[0];
	removeMin ();
      }
    heapSize = k;
    for (i = 0; i < k; i++)
      {
	data[i] = arr[i];
      }

    System.out.print ("SJF Scheduling : ");

    for (i = 0; i < k; i++)
      {
	System.out.print (arr[i].pid + " ");
      }
    System.out.println ();

  }

  public void printHeap ()
  {
    System.out.print ("(Process_ID,Burst_Time) : ");
    for (int i = 0; i < heapSize; i++)
      {
	System.out.print ("(" + data[i].pid + "," + data[i].btime + ")");
      }
    System.out.println ();
  }
}

public class Program
{
  public static void main (String[]args)
  {

    MinHeap n = new MinHeap (7);
      Process[] s = new Process[7];

      n.Insert ("p1", 45);
      n.Insert ("p2", 56);
      n.Insert ("p3", 12);
      n.Insert ("p4", 22);
      n.Insert ("p5", 54);
      n.Insert ("p6", 36);
      n.Insert ("p7", 15);

      n.printHeap ();
      System.out.println ("Min removal ...");
      n.removeMin ();
      n.printHeap ();
      n.HeapSort ();

  }

}
