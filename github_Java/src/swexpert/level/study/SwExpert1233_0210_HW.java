package swexpert.level.study;
import java.util.Arrays;
import java.util.Scanner;

public class SwExpert1233_0210_HW {
	
	public static void main(String[] args) {
		int size = 10;
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= size; test_case++) {
			
			int n = sc.nextInt();
			sc.nextLine();
			int answer = 1;
			String[] command;
			
			int[] arr = new int[n+1];
//			if(Integer.parseInt(command[0]) < n/2) {
//				if(command[1].charAt(0) != '+' && command[1].charAt(0) != '-' && command[1].charAt(0) != '*' && command[1].charAt(0) != '/') {
//					System.out.printf("#%d %d%n", test_case, 0);
//					continue;
//				}
//			}
			for (int i = 1; i < arr.length; i++) {
				command = sc.nextLine().split(" ");
				if(command[1].equals("+") || command[1].equals("-") || command[1].equals("*") || command[1].equals("/"))
					arr[Integer.parseInt(command[0])] = -1;
				else {
					arr[Integer.parseInt(command[0])] = command[1].charAt(0) - '0';
				}
			}
			for (int i = 1; i < arr.length/2; i++) {
				if(arr[i] != -1) {
//					System.out.println(i + " " + arr[i]);
					answer = 0;
					break;
				}
			}
			for (int i = (arr.length/2) + 1; i < arr.length; i++) {
				if(arr[i] == -1 ) {
//					System.out.println(i + " " + arr[i]);
					answer =0;
					break;
				}
			}
//			System.out.printf("#%d %d%n", test_case, answer);
			System.out.printf("#%d %d%n", test_case, postOrder(arr, 1) == 1 ? 1 : 0);
		}
	}
	
	static int postOrder(int[] arr, int idx) {
		int left, right;
		if(idx * 2 >= arr.length) {
			return 1;
		}
		else {
			left = postOrder(arr, idx<<1);
			right = postOrder(arr, (idx <<1 ) + 1);
		}
		if(left == -1 || right == -1) {
			return -1;
		}
		else {
			if(arr[idx] != -1 )
				return -1;
			return 1;
		}
	}
	
	
}
