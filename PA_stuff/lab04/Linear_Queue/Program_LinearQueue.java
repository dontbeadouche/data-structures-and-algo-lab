import java.util.*;

class MyLinearQueue{

	final int N;
	int arr[];
	int front, rear;

	public MyLinearQueue(int N){
		
		this.N = N;
		arr = new int[N];
		front = rear = 0;

	}

	public void enqueue(int x){

		if(rear == N){

			System.out.println("Queue is Full");	// Since it is not a Circular queue
			return;

		}

		else{

			arr[rear] = x;
			rear++;

		}

	} 

	public int dequeue(){

		int f = front();

		if(isEmpty()){

			System.out.println("Queue is Empty");

		}

		else{

			System.out.println("Element : " + front() + " dequeued");
			front++;

		}

		return f;

	}

	public boolean isEmpty(){

		return(front == rear);
	}

	public int size(){

		return(rear - front);

	}

	public int front(){

		if(isEmpty()){

			return 0;

		}

		int x = arr[front];

		return x;

	}

	public void display(){

		System.out.print("Queue : " );

		for(int i = 0; i < size(); i++){

			System.out.print(arr[front + i] + " ");

		}

		System.out.println();

	}
}

class Program_LinearQueue{

	public static void main(String[] args) {
		
		MyLinearQueue queue = new MyLinearQueue(6);

		queue.enqueue(2);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.display();
		queue.dequeue();
		queue.enqueue(4);
		queue.display();
		queue.enqueue(1);
		queue.dequeue();
		queue.display();
		queue.enqueue(12);
		queue.display();
		queue.enqueue(15);	// rear already reached at the end hence Queue will be full

	}
}

