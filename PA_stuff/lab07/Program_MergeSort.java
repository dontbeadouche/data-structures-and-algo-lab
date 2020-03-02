import java.util.*;
import java.io.*;

class Student{

  String name;
  int id, year;
  float cgpa;

  public Student(String name, int id, int year, float cgpa){

    this.name = name;
    this.id = id;
    this.year = year;
    this.cgpa = cgpa;
  }
}

public class Program_MergeSort{

  public static void main(String[] args) throws FileNotFoundException{

    Student st;
    File input = new File("students.txt");
    Scanner sc = new Scanner(input);

    ArrayList <Student> list = new ArrayList<Student> ();

    while(sc.hasNextLine()){
      // Reading Comma separated File contents line by line
      String line = sc.nextLine();
      String[] tokens = line.split(", ");     // Spliting each line with comma-space (", ") as the delimiter
      String name = tokens[0];
      int id = Integer.parseInt(tokens[1]);       // Converting String input to integer
      int year = Integer.parseInt(tokens[2]);
      float cgpa = Float.parseFloat(tokens[3]);

      st = new Student(name, id, year, cgpa);
      list.add(st);
    }

    int len = list.size();
    ArrayList <Student> res = new ArrayList<Student> ();
    System.out.println("\nUnsorted List :\n");
    display(list);
    res = mergeSort(list);
    System.out.println("\nList after Sorting :\n");
    display(res);
  }

  public static ArrayList<Student> mergeSort(ArrayList<Student> arr){

    if(arr.size() == 1){
      return arr;         // Base case
    }

    ArrayList <Student> left = new ArrayList<Student>();
    ArrayList <Student> right = new ArrayList<Student>();

    int mid = arr.size()/2;
    // Filling left and right arrays
    for(int i = 0; i < mid; i++){
      left.add(arr.get(i));
    }
    for(int j = mid; j < arr.size(); j++){
      right.add(arr.get(j));
    }
    // Recursive calls
    left = mergeSort(left);
    right = mergeSort(right);
    arr = merge(left, right);
    return arr;
  }

  public static ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right){

    ArrayList <Student> arr = new ArrayList<Student> ();
    int i = 0;
    int j = 0;

    while(i < left.size() && j < right.size()){

      if((left.get(i).name).compareTo(right.get(j).name) <= 0){
        arr.add(left.get(i));
        i++;
      }
      else{
        arr.add(right.get(j));
        j++;
      }
    }

    while(i < left.size()){
      arr.add(left.get(i));
      i++;
    }

    while(j < right.size()){
      arr.add(right.get(j));
      j++;
    }
    return arr;
  }

  public static void display(ArrayList<Student> students){

    System.out.println("\tName\t" + "\t\tID" + "\t\tYear" + "\t\tCGPA\n");

    for(Student temp : students){
      System.out.println("\t" + temp.name + "\t\t" + temp.id + "\t\t" + temp.year + "\t\t" + temp.cgpa);
    }
    System.out.println();
  }
}
