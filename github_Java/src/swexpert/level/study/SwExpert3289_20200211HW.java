package swexpert.level.study;
import java.util.Arrays;
import java.util.Scanner;

public class SwExpert3289_20200211HW {
	
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder answer = new StringBuilder();
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			arr = new int[n+1];
			makeSet();
			String[] command;
			for (int i = 0; i < m; i++) {
				command = sc.nextLine().split(" ");
				//0번째가 0이면 합집합하기 (union)
				//1이면 같은 집합인지 확인하는 명령 
				if(command[0].equals("0")) {
					union(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				}
				else {
					if(findSet(Integer.parseInt(command[1])) == findSet(Integer.parseInt(command[2]))) {
						answer.append("1");
					}
					else {
						answer.append("0");
					}
				}
			}
			
			System.out.printf("#%d %s%n", test_case, answer);
		}
	}
	private static void union(int x, int y) {
		arr[findSet(y)] = findSet(x);
	}
	
	private static int findSet(int idx) {
		if ( idx == arr[idx]) {
			return idx;
		}
		return arr[idx]= findSet(arr[idx]); 
	}

	private static void makeSet() {
		for (int i = 1; i < arr.length; i++) {
			arr[i]= i; 
		}
	}
	
	
}
