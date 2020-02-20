package baekjoon;

import java.util.Scanner;

public class Baekjoon3109_2 {
	static int answer = 0;
	static int[][] Visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row, col;
		
		row = sc.nextInt();
		col = sc.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			String string = sc.next();
			for (int j = 0; j < string.length(); j++) {
				if(string.charAt(j) != '.') {
					arr[i][j]= 1; 
				}
			}
		}
//		printarr(arr);
		
		int startCol = 1;
		Visited = new int[row][col];
		for (int x = 0; x < arr.length; x++) {
			if(arr[x][startCol] == 0) {
				dfs(arr,x, 0, x+1);
			}
		}
		System.out.println(answer);
		answer = 0;
	}
	
	public static boolean dfs(int[][] arr, int x, int y, int startX) {
		Visited[x][y] = startX; 
		if(y == arr[0].length-2) {
//			System.out.println();
//			printarr(Visited);
			answer++;
			return true;
		}
		boolean flag = false;
		//arr은 1이 길		Visited는 1이 방문한 곳
		if( x-1 >= 0  &&  Visited[x-1][y+1] == 0 && arr[x-1][y+1] == 0) {
			flag = dfs(arr,  x-1, y+1, startX);
		}
		if(flag) {
			return true;
		}
		if(Visited[x][y+1] == 0 && arr[x][y+1] == 0) {
			flag = dfs(arr,  x, y+1, startX);
		}
		if(flag) {
			return true;
		}
		if(x + 1 < arr.length && Visited[x+1][y+1] == 0 && arr[x+1][y+1] == 0) {
			flag = dfs(arr, x+1, y+1, startX);
		}
		if(flag)
			return true;
		return false;
	}
	
	
	
	static void printarr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " " );
			}
			System.out.println();
		}
	}
}
