package swexpert.level.study;
import java.util.Arrays;
import java.util.Scanner;
//창용마을 무리의 개수
public class SwExpert7465 {
	private static int parent[];
	private static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String[] command;
//		int TC = Integer.parseInt(sc.nextLine());
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
//			command = sc.nextLine().split(" ");
//			int n = Integer.parseInt(command[0]);
//			int m = Integer.parseInt(command[1]);
			int n = sc.nextInt();
			int m = sc.nextInt();
			parent = new int[n+1];
			arr = new int[n+1];
			makeSet();
			int[] result = new int[n];
			for (int i = 0; i < m; i++) {
//				command = sc.nextLine().split(" ");
//				union(Integer.parseInt(command[0]), Integer.parseInt(command[1]));
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}
			System.out.printf("#%d %d%n", test_case, findResult());
			
		}
	}
	static int findResult() {
//		System.out.println(Arrays.toString(parent));
		int result = 0;
//		for (int i = 1; i < arr.length; i++) {
//			arr[findSet(i)]++;
//		}
		System.out.println("arr " + Arrays.toString(parent));
//		for (int i = 1; i < arr.length; i++) {
//			if(arr[i]> 0 ) {
//				result++;
//			}
//		}
		for (int i = 1; i < parent.length; i++) {
			if(parent[i] == i ) {
				result++;
			}
		}
		return result;
	}
	
	public static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
	
	private static int findSet(int x) {
		if(x == parent[x])
			return x;
		return parent[x]= findSet(parent[x]); 
	}

	public static void makeSet() {
		for (int i = 0; i < parent.length; i++) {
			parent[i]= i; 
		}
	}
	
}
