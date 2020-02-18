package baekjoon;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon17471 {
	static int people[];
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		
		people = new int[n+1];
		
		for (int i = 1; i < people.length; i++) {
			people[i]= sc.nextInt(); 
		}
		
		arr = new int[n+1][n+1];
		int temp2;
		for (int i = 1; i < n+1; i++) {
			int temp = sc.nextInt();
			for (int j = 0; j < temp; j++) {
				temp2 = sc.nextInt();
				arr[i][temp2] = 1; 
			}
		}
		
		print2DInt(arr);
		
		

		
		
		
		
		
	}
	

	
	static void print2DInt(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	
	
}
