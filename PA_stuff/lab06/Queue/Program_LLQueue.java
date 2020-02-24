import java.util.*;

class Node{

  int data;
  Node next;

  public Node(int data){
    this.data = data;
  }
}

class MyQueue{

  Node front, rear;      // Keeping track of both the front and rear of the LinkedList

  public void enqueue(int x){

    Node temp = new Node(x);

    if(isEmpty()){      // Insering when Queue is empty
      front = rear = temp;
      return;
    }

    rear.next = temp;     // Insertion at rear
    rear = temp;
  }

  public int dequeue(){

    if(isEmpty()){
      System.out.println("Queue already empty");
      return -1;
    }
    Node temp = front;
    int x = temp.data;
    front = front.next;   // Dequeuing from front

    if(front == null){    // In case Queue becomes empty after dequeuing
      rear = null;
    }
    System.out.println("\nElement : " + x + " Dequeued");
    return x;
  }

  public boolean isEmpty(){
    return (front == null);
  }

  public void display(){

    Node temp = front;

    System.out.print("\nQueue(front to rear) : ");

    while(temp != rear.next){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}

public class Program_LLQueue{

  public static void main(String[] args) {

    MyQueue queue = new MyQueue();

    queue.enqueue(8);
    queue.enqueue(4);
    queue.enqueue(1);
    queue.display();
    queue.dequeue();
    queue.display();
    queue.enqueue(10);
    queue.enqueue(7);
    queue.display();
    queue.dequeue();
    queue.display();
  }
}
