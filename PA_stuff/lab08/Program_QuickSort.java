import java.util.*;
import  java.io.*;

class Contact{

  String name;
  long phno;

  public Contact(String name, long phno){

    this.name = name;
    this.phno = phno;
  }
}

public class Program_QuickSort{

  public static void main(String[] args) throws FileNotFoundException{

    File input = new File("contacts.txt");
    Scanner sc = new Scanner(input);

    ArrayList <Contact> list = new ArrayList <Contact> ();

    while(sc.hasNextLine()){
      // Reading Comma separated File contents line by line
      String line = sc.nextLine();
      String[] tokens = line.split(", ");     // Spliting each line with comma-space (", ") as the delimiter
      String name = tokens[0];
      long phno = Long.parseLong(tokens[1]);      // Converting String input to type Long
      Contact temp = new Contact(name, phno);
      list.add(temp);
    }

    int len = list.size();

    Contact[] arr = list.toArray(new Contact[len]);     // Converting ArrayList of Contacts to an Array of Contacts
    System.out.println("\nUnsorted List :\n");
    display(arr);
    quickSort(arr, 0, arr.length - 1);
    System.out.println("\nList after Sorting :\n");
    display(arr);
  }

  public static void quickSort(Contact[] arr, int start, int end){

    if(start < end){

      int pIndex = partition(arr, start, end);
      quickSort(arr, start, pIndex - 1);
      quickSort(arr, pIndex + 1, end);
    }
  }

  public static int partition(Contact[] arr, int start, int end){

    String pivot = arr[end].name;
    int i = start - 1;

    for(int j = start; j <= end - 1; j++){
      if(arr[j].name.compareTo(pivot) <= 0){
        i++;
        // swapping arr[i] and arr[j]
        Contact temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    // swapping arr[i + 1] and arr[end]
    Contact temp = arr[i + 1];
    arr[i + 1] = arr[end];
    arr[end] = temp;

    return i + 1;
  }

  public static void display(Contact[] contacts){

    System.out.println("\tName\t" + "\t\tPhone no.\n");

    for(Contact temp : contacts){
      System.out.println("\t" + temp.name + "\t\t" + temp.phno);
    }
    System.out.println();
  }
}
