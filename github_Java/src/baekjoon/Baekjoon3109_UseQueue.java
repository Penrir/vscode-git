package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon3109_UseQueue {
	static boolean[][] V;
	static int[][] arr;
	static int answer = 0;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int row, col;
		LinkedList<Point> list = new LinkedList<>();
		row = sc.nextInt();
		col = sc.nextInt();
		arr = new int[row][col];
		V = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			String string = sc.next();
			for (int j = 0; j < string.length(); j++) {
				if(string.charAt(j) == '.') {
					arr[i][j]= 1; 
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			list.add(new Point(i, 1));
			V[i][1] = true;
			Point temp;
			int nx;
			while(!list.isEmpty()) {
				temp = list.poll();
				if(temp.y == col-2) {
					answer++;
					printarrb(V);
					continue;
				}
				for (int j = 0; j < dx.length; j++) {
					nx = temp.x + dx[j];
					if(nx < row && nx > -1) {
						if(!V[nx][temp.y+1]) {
							//1이 갈 수 있는 곳임.
							if(arr[nx][temp.y+1] == 1) {
								V[nx][temp.y+1] = true;
								list.add(new Point(nx, temp.y+1));
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
		long end = System.currentTimeMillis();
		System.out.printf("time : %d" , end-start);
		
	}
	
	static int[] dx = {-1, 0, 1};
	static boolean dfs(int x, int y) {
//		System.out.println("xy " + x + " " + y);
		V[x][y] = true;
		if ( y == arr[0].length-2) {
//			printarr(arr);
//			printarrb(V);
			answer++;
			return true;
		}
		int nx;
		for (int i = 0; i < dx.length; i++) {
			nx = x + dx[i];
			//오른쪽 위부터 오른쪽 오른아래 순으로 검사.
			if(nx >=0 && nx < arr.length) {
				//방문한 적 없을 때 
				if(!V[nx][y+1]) {
					//갈수 없으면
					if(arr[nx][y+1] != 0) {
						//끝까지 간 경우
						if(dfs(nx, y+1)) {
							return true;
						}//끝까지 못갔으면
//						V[nx][y+1] = false;
					}
				}
			}
		}
		return false;
	}
	
	
	static void printarrb(boolean[][] list) {
		System.out.println("   arr-------------------bool");
		for (int i = 0; i < list.length; i++) {
			System.out.printf("%2d  ", i);
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " " );
			}
			System.out.print("  ");
			for (int j = 0; j < list[i].length; j++) {
				if(list[i][j]) {
					System.out.print("1 " );
				}else {
					System.out.print("0 " );
				}
			}

			
			System.out.println();
		}
	}
	static void printarr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " " );
			}
			System.out.println();
		}
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
}