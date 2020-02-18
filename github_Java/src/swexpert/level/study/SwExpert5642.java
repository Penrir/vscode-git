package swexpert.level.study;
import java.util.Scanner;

public class SwExpert5642 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int answer =0;
		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt(); 
			}
			int max = Integer.MIN_VALUE;
			int temp =0;
			for (int i = 0; i < arr.length; i++) {
				temp = arr[i];
				max = max > temp ? max : temp; 
				for (int j = i+1; j < arr.length; j++) {
					temp += arr[j];
					max = max > temp ? max : temp; 
//					System.out.printf("%d %d%n", i, j);
//					System.out.println("------ " + max);
				}
				temp =0;
			}
			System.out.printf("#%d %d%n", test_case, max);
			
		}
	}
	
	public static int arrSum(int[] arr, int startidx, int endidx) {
		int sum = 0;
		for (int i = startidx; i <= endidx; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
