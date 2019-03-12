import java.io.*;

import java.util.*;

class Student
{

  String name;
  int ID;
  int year;
  float GPA;

  void add (int ID, int year, float GPA, String name)
  {
    this.ID = ID;
    this.year = year;
    this.GPA = GPA;
    this.name = name;
    
  }
}

class Program
{


  static Student[] QuickSort (Student[]S, int start, int end)
  {
    if (start < end)
      {
	int pIndex = partition (S, start, end);
	  QuickSort (S, start, pIndex - 1);
	  QuickSort (S, pIndex + 1, end);
      }
    return S;
  }

  public static int partition (Student[]S, int start, int end)
  {
    String p = S[end].name;
    int i = start - 1;
    for (int j = start; j <= end - 1; j++)
      {
	if (S[j].name.compareTo (p) < 0)
	  {
	    i++;
	    Student t= S[i];
	    S[i] = S[j];
	    S[j] = t;
	  }

      }
    Student t= S[i + 1];
    S[i + 1] = S[end];
    S[end] = t;
    return i + 1;
  }

  static void display (ArrayList < Student > stlist)
  {
  for (Student st:stlist)
      {
	System.out.print ("  ID : " + st.ID);

	System.out.print ("  Name : " + st.name);
	System.out.print ("  Year : " + st.year);
	System.out.print ("  GPA : " + st.GPA);
	System.out.println ();

      }
  }

  public static void main (String args[]) throws FileNotFoundException
  {
    Student st;
    File f = new File ("Student.txt");
    Scanner s = new Scanner (f);

    int ID;
    int year;
    float GPA;
    String name;
    int count = 0;
      ArrayList < Student > l = new ArrayList < Student > ();

    while (s.hasNext ())
      {
	st = new Student ();
	ID = Integer.parseInt (s.next ());
	year = Integer.parseInt (s.next ());
	GPA = Float.parseFloat (s.next ());
	name = s.next();
	st.add (ID, year, GPA,name);
	l.add (st);
	count++;
      }

    System.out.println ("Data Sorted by Name : \n");

    Student[]S = new Student[count];
    S = (Student[])l.toArray (S);
    S = QuickSort (S, 0, count - 1);
    l.clear ();
    l = new ArrayList < Student > (Arrays.asList ());
    int i = 0;
    while (i < count)
      {
	st = new Student ();
	st.add (S[i].ID, S[i].year, S[i].GPA, S[i].name);
	l.add (st);
	i++;
      }

    display (l);
    s.close ();
  }
}


