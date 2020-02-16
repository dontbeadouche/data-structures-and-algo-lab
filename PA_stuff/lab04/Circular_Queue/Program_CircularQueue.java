import java.util.*;

class MyCircularQueue{

	final int N;
	int arr[];
	int front, rear;

	public MyCircularQueue(int N){
		
		this.N = N;
		arr = new int[N];
		front = rear = 0;

	}

	public void enqueue(int x){

		if(size() == N - 1){	// one index always reseved for rear, hence making the size of queue N-1 

			System.out.println("Queue is full");

		}

		else{

			arr[rear] = x;
			rear = (rear + 1) % N;

		}

	} 

	public int dequeue(){

		int f = front();

		if(isEmpty()){

			System.out.println("Queue is Empty");

		}

		else{

			System.out.println("Element : " + front() + " dequeued");
			front = (front + 1) % N;

		}

		return f;

	}

	public boolean isEmpty(){

		return(front == rear);
	}

	public int size(){

		return(((rear - front) + N) % N);

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

			System.out.print(arr[(front + i) % N] + " ");

		}

		System.out.println();

	}

}

class Program_CircularQueue{

	public static void main(String[] args) {
		
		MyCircularQueue queue = new MyCircularQueue(6);

		queue.enqueue(2);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.display();
		queue.dequeue();
		queue.display();
		queue.enqueue(4);
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(23);
		queue.display();
		queue.enqueue(12);
		queue.display();
		queue.enqueue(15);	// Max elements (5) already  hence Queue will be full

	}
}

