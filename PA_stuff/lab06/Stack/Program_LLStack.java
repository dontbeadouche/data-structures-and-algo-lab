import java.util.*;

class Node{

  int data;
  Node next;

  public Node(int data){
    this.data = data;
  }
}

class MyStack{

  Node top;     // keeping track of the head of LinkedList

  public void push(int x){

    Node node = new Node(x);
    node.next = top;
    top = node;     // Pushing at top
  }

  public boolean isEmpty(){

    return (top == null);
  }

  public int pop(){

    if(isEmpty()){
      System.out.println("\nStack Underflow");
      return -1;
    }
    int x = top.data;
    top = top.next;       // Popping the top
    System.out.println("\nElement : " + x + " Popped");
    return x;
  }

  public void display(){

    Node current = top;

    System.out.print("\nStack(top to bottom) : ");

    while(current != null){
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
}

public class Program_LLStack{

  public static void main(String[] args) {

    MyStack stack = new MyStack();

    stack.push(8);
    stack.push(4);
    stack.push(1);
    stack.display();
    stack.pop();
    stack.display();
    stack.push(15);
    stack.display();
  }
}
