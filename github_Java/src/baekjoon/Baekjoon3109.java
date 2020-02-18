package baekjoon;

import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

public class Baekjoon3109 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row, col;
		
		row = sc.nextInt();
		col = sc.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			String string = sc.next();
			for (int j = 0; j < string.length(); j++) {
				if(string.charAt(j) == '.') {
					arr[i][j]= 1; 
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i < arr[0].length-1; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i]== 0 )
					continue;
				arr[j][i]= check(arr, j, i); 
			}
			answer = Math.min(answer, colSum(arr, i));
			printarr(arr);
			System.out.println();
		}
		
		System.out.println(answer);
		
		
		
	}
	static void printarr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " " );
			}
			System.out.println();
		}
	}
	static int[] dx = {-1, 0, 1};
	//해당칸 올 수 있으면 1 아니면 0
	static int check(int[][] arr, int x, int y) {
		int nx;
		int cnt = 0;
		boolean flag = false;
		nx = x + dx[0];
		if(nx >=0 && nx < arr.length) {
			if(arr[nx][y-1] != 0) {
//					return 1;
				cnt++;
			}else {
				flag = true;
			}
		}
		nx = x + dx[1];
		if(nx >=0 && nx < arr.length) {
			if(arr[nx][y-1] != 0) {
//					return 1;
				cnt++;
			}
		}
		nx = x + dx[2];
		if(nx >=0 && nx < arr.length) {
			if(arr[nx][y-1] != 0) {
//					return 1;
				cnt++;
			}
			else {
				if(flag) {
					return 0;
				}
			}
		}

		System.out.println("check " + x + " " + y);
//		if(cnt == 0 || cnt == 2)
//			return 0;
//		else {
//			return 1;
//		}
		return cnt;
	}
//	static int check(int[][] arr, int x, int y) {
//		int nx;
//		int cnt = 0;
//		for (int i = 0; i < dx.length; i++) {
//			nx = x + dx[i];
//			if(nx >=0 && nx < arr.length) {
//				if(arr[nx][y-1] != 0) {
////					return 1;
//					cnt++;
//				}
//			}
//		}
//		System.out.println("check " + x + " " + y);
////		if(cnt == 0 || cnt == 2)
////			return 0;
////		else {
////			return 1;
////		}
//		return cnt;
//	}

	static int colSum(int[][] arr, int y) {
		int sum = 0 ;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i][y] != 0) {
				sum++;
			}
//			sum += arr[i][y];
		}
//		System.out.println("---------!!! "+ sum);
		return sum;
	}
}
