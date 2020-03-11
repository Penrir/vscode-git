package swexpert.level5;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class 오나의여신7793 {
	private static int result = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [][] map = new int[n][m];
			//0은 길, 1은 수연 2는 여신 3은 악마 4은 벽 
			int startx=0, starty=0;
			for (int i = 0; i < n; i++) {
				String temp = sc.next();
				for (int j = 0; j < temp.length(); j++) {
					switch (temp.charAt(j)) {
					//길
					case '.':
						map[i][j] = 0; 
						break;
					case 'S': 	//수연(이동하는것)
						map[i][j] = 1; 
						startx = i;
						starty = j;
						break;
					case 'D':	//여신(도착지)
						map[i][j] = 2; 
						break;
					case '*':	//악마(번지는벽)
						map[i][j] = 3; 
						break;
					case 'X':	//고정 벽
						map[i][j] = 4; 
						break;
					}
				}
			}
//			dfs(map, 0, startx, starty);
			
			bfs(map, startx, starty);
			
			
			if(result == Integer.MAX_VALUE) {
				System.out.printf("#%d GAME OVER%n", test_case);
			}
			else {
				System.out.printf("#%d %d%n", test_case, result);
			}
			result = Integer.MAX_VALUE;
		}
	}
	private static void bfs(int[][] map, int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		Queue<Point> devil = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		int answer = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]== 3 ) {
					devil.offer(new Point(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			int devilsize = devil.size();
			int nx, ny;
			Point deviltemp;
			for (int i = 0; i < devilsize; i++) {
				deviltemp = devil.poll();
				for (int j = 0; j < dx.length; j++) {
					nx = deviltemp.x + dx[j];
					ny = deviltemp.y + dy[j];
					if(isInBound(map.length, map[0].length, nx, ny)
							&& map[nx][ny] < 2 ) {
						map[nx][ny] = 3; 
						devil.offer(new Point(nx, ny));
					}
				}
			}
			
//			change(map);
//			print2DArr(map);
//			System.out.println();
			answer += 1;
			for (int i = 0; i < size; i++) {
				Point temp= queue.poll();
//				System.out.println(temp);
				for (int j = 0; j < dx.length; j++) {
					nx = temp.x + dx[j];
					ny = temp.y + dy[j];
					if(isOK(map, map.length, map[0].length, nx, ny)) {
						if(map[nx][ny]== 2 ) {
							result = answer;
							return;
						}
						Point temp2 = new Point(nx, ny);
						if(!queue.contains(temp2)) {
							queue.offer(temp2);
						}
					}
				}
			}
		}
		
	}
	public static void print2DArr(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void dfs( int[][] map, int depth, int x, int y) {
//		print2DArr(map);
//		System.out.printf("x=%d y=%d%n", x, y);
//		if(map[x][y] == 2) {
//			result = Math.max(depth, result);
//			return ;
//		}
//		if(depth != 0) {
		change(map);
//		}
//		System.out.println("change");
//		print2DArr(map);
		int nx, ny;
		for (int i = 0; i < dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(isInBound(map.length, map[0].length, nx, ny)) {
				//0은 길, 1은 수연 2는 여신 3은 악마 4은 벽 
//				System.out.printf("nx=%d ny=%d map[nx][ny] = %d\n", nx, ny, map[nx][ny]);
				switch (map[nx][ny]) {
				case 0: 	//길
					map[nx][ny]= 1; 
					dfs(map, depth+1, nx, ny);
					break;
				case 1: 	//수연(이동하는것)
					break;
				case 2:	//여신(도착지)
					result = Math.min(result, depth+1);
					return;
				case 3://악마(번지는벽)
					break;
				case 4:	//고정 벽
					break;
				}
			}
		}
		
	}
	private static void change(int[][] map) {
		boolean [][] v = new boolean[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 3 && !v[i][j]) {
					int nx, ny;
					for (int k = 0; k < dx.length; k++) {
						nx = i + dx[k];
						ny = j + dy[k];
						if(isInBound(map.length, map[0].length, nx, ny) 
								&& !v[nx][ny])
							if(	map[nx][ny]== 0 || map[nx][ny] == 1) {
								map[nx][ny] = 3;
								v[nx][ny] = true; 
							}
					}
					
				}
			}
		}
	}
	public static boolean isInBound(int row, int col, int x, int y) {
		if(x < row && y < col && x >= 0 && y>= 0)
			return true;
		return false;
	}
	public static boolean isOK(int[][] map, int row, int col, int x, int y) {
		if(isInBound(row, col, x, y) && map[x][y] <=2) {
			return true;
		}
		return false;
	}
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Point x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("");
			return builder.toString();
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	
}

