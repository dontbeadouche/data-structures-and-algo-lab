import java.util.*;

class Node{

  String name, id;
  double cgpa;
  Node next;

  Node(String name, String id, double cgpa){

    this.name = name;
    this.id = id;
    this.cgpa = cgpa;
    this.next = null;
  }
}

class MyLinkedList{

  Node head;

  public void insert(int index, String name, String id, double cgpa){

    Node node = new Node(name, id, cgpa);
    Node current = head;
    Node previous = null;

    if(head == null && index != 0){      // Inserting at wrong index while the list is empty
      System.out.println("List already empty. So cannot insert at specified index");
      return;
    }
    if(index > size()){     // Inserting at index greater thn current size of the list
      System.out.println("Cannot insert at the specified index");
      return;
    }

    for(int i = 0; i < index; i++){     // Iterate to the provided index
      previous = current;
      current = current.next;
    }

    node.next = current;

    if(previous == null){
      head = node;
    }
    else{
      previous.next = node;
    }
    System.out.println("\nRecord inserted successfully");
  }

  public int find(String x){

    int i = 0;
    Node current = this.head;

    while(current != null){

      if((current.name).equals(x)){
        return i;      // found
      }
      current = current.next;
      i++;
    }
    return -1;     // Not found
  }

  public void delete(String name){

    int x = find(name);
    Node temp = this.head;

    if(x != -1){
      if(x == 0){     // Deletion of head
        head = head.next;
        System.out.println("Deleted record with name : "+ name);
        return;
      }
      else{
        for(int i = 0; temp != null && i < x - 1; i++){
          temp = temp.next;
        }
        Node next = (temp.next).next;
        temp.next = next;
        System.out.println("Deleted record with name : "+ name);
      }
    }
    else{
      System.out.println("Record not present");
    }
  }

  public void print(){

    Node temp = this.head;
    int i = 1;

    System.out.println("\nStudents list : \n");

    while(temp != null){
      System.out.println(i + "\t" + temp.name + "\t" + temp.id + "\t" + temp.cgpa);
      temp = temp.next;
      i++;
    }
    System.out.println();
  }

  public int size(){

    Node temp = head;
    int size = 0;

    while(temp != null){
      size++;
      temp = temp.next;
    }
    return size;
  }

  public boolean isEmpty(){
    return(size() == 0);
  }
}

public class Program_LinkedList{

  public static void main(String[] args) {

    MyLinkedList list = new MyLinkedList();

    menu(list);
  }

  public static void menu(MyLinkedList list){

    int choice;
    boolean quit = false;
    Scanner sc = new Scanner(System.in);

    do{

      System.out.println("\nEnter 1 for Inserting a student record");
      System.out.println("Enter 2 for Deleting a student record");
      System.out.println("Enter 3 to find a student record");
      System.out.println("Enter 4 for Displaying all student records");
      System.out.println("Enter 5 to check if List is Empty or not");
      System.out.println("Enter 6 to check the Size of the List");
      System.out.println("Enter 7 to Exit");
      System.out.println();

      System.out.print("Enter Choice : ");
      choice = sc.nextInt();
      System.out.println();
      switch(choice){

        case 1:
              String name, id;
              double cgpa;
              int index;

              System.out.print("Enter name : ");
              name = sc.next();
              System.out.print("Enter id : ");
              id = sc.next();
              System.out.print("Enter cgpa : ");
              cgpa = sc.nextDouble();
              System.out.print("Enter index to insert : ");
              index = sc.nextInt();

              System.out.println();
              list.insert(index, name, id, cgpa);
              System.out.println();
              break;

        case 2:

              String x;

              System.out.print("Enter the name to delete : ");
              x = sc.next();

              System.out.println();
              list.delete(x);
              System.out.println();
              break;

        case 3:

              String y;
              int ind;

              System.out.print("Enter the name to find : ");
              y = sc.next();

              ind = list.find(y);

              if(ind == -1){
                System.out.println("\nRecord not found");
              }
              else{
                System.out.println("\nRecord found at index : " + ind);
              }
              System.out.println();
              break;

        case 4:

              list.print();
              System.out.println();
              break;

        case 5:

              boolean emp;

              emp = list.isEmpty();

              if(emp){
                System.out.println("\nList is empty");
              }
              else{
                System.out.println("\nList is not empty");
              }
              System.out.println();
              break;

        case 6:

              System.out.println("\nCurrent size of list : " + list.size());
              System.out.println();
              break;

        case 7:

              System.out.println("Thank you");
              System.out.println();
              quit = true;
              break;

        default:

              System.out.println("Enter valid choice");
              System.out.println();
              break;

      }
    } while(!quit);
  }
}
