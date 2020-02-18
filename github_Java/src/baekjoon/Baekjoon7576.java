package baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Baekjoon7576 {
	static int before=0;   //이전의 0의 개수
	static int after = 0;  //익히는 과정 한번 진행 후 0의 개수
	static int[][] arr;
	static List<Point> list = new LinkedList<Point>();
	static List<Point> templist = new LinkedList<Point>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int row, col;
			row = sc.nextInt();
			col = sc.nextInt();
			arr = new int[col][row];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j]= sc.nextInt(); 
					if(arr[i][j] == 1) {
						list.add(new Point(i,  j));
					}
					else {
						before++;
					}
				}
			}
			int answer =0;
			int size = list.size();
			while(true) {
				if(check0() == 0)
					break;
//				list.stream().forEach(x -> change(x));
				size = list.size();
//				System.out.println("size: " + size);
				for (int k= 0; k < size; k++) {
					Point p = list.get(k);
					for (int i = 0; i < dx.length; i++) {
						int nx = p.x + dx[i];
						int ny = p.y + dy[i];
						if( nx >-1 && ny > -1 && nx < arr.length && ny < arr[nx].length) {
							if(arr[nx][ny]== -1 )
								continue;
							if(arr[nx][ny] == 1)
								continue;
							arr[nx][ny] = 1; 
							list.add(new Point(nx, ny));
						}
					}
				}
//				list.stream().forEach(x -> System.out.println(x));
//				System.out.println(list.size());
//				printarr();
//				for (int i = 0; i < size; i++) {
//					list.remove(0);
//				}
//				list = templist;
				answer++;
				if(row* col == list.size())
					break;
				if(before == check0()) {
					break;
				}
				before = check0();
				
			}
//			System.out.println("bbb   " + before);
			if(check0() == 0) {
				System.out.println(answer);
			}
			else {
				System.out.println(-1);
			}
			
			list.clear();
			
		}
		
		
	}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static int check0() {
		int sum =0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j]== 0 ) {
					sum++;
				}
			}
		}
		return sum;
	}
	static void printarr() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " " );
			}
			System.out.println();
		}
	}
//	private static void change(Point x) {
//		for (int i = 0; i < dx.length; i++) {
//			int nx = x.x + dx[i];
//			int ny = x.y + dy[i];
//			if( nx >-1 && ny > -1 && nx < arr.length && ny < arr[nx].length) {
//				if(arr[nx][ny]== -1 )
//					continue;
//				arr[nx][ny] = 1; 
//				templist.add(new Point(nx, ny));
//			}
//		}
//	}

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
