import java.util.*;
class Program{

	public static void main(String args[]){
				
		int i,n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter length of char array : ");
		n=sc.nextInt();
		char arr[]=new char[n];
		char arr2[]=new char[n];
		for(i=0;i<n;i++){
			System.out.print("Enter char : ");
			char c=sc.next().charAt(0);
			arr[i]=c;
			}
		long startTime = System.currentTimeMillis();
		
		int j;
		for(i=0,j=n-1;i<n;i++,j--){
			arr2[i]=arr[j];
		}
		
		System.out.print("Original char array : ");
		for(i=0;i<n;i++){
			System.out.print(arr[i]);
		}

		System.out.println();
		System.out.print("Reversed char array : ");
		for(int k=0;k<n;k++){
			System.out.print(arr2[k]);
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("\nRunning Time : "+totalTime+" ms");

	}
}
	

