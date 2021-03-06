package baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Baekjoon7576_2 {
	static int before=0;   //이전의 0의 개수
	static int after = 0;  //익히는 과정 한번 진행 후 0의 개수
	static int[][] arr;
	static LinkedList<Point> list = new LinkedList<Point>();
//	static Point[] list;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row, col;
		int answer = -1;
		row = sc.nextInt();
		col = sc.nextInt();
		arr = new int[col][row];
		int count0 = row*col;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]= sc.nextInt(); 
				if(arr[i][j] == 1) {
					list.add(new Point(i,  j));
					count0--;
				}
				if(arr[i][j]== -1 )
					count0--;
			}
		}
		int nx, ny;
		int size;
//		System.out.println(count0);
		while(!list.isEmpty()) {
			size = list.size();
//			System.out.println(size);
			for (int j = 0; j < size; j++) {
				Point temp = list.poll();
				for (int i = 0; i < dx.length; i++) {
					nx = temp.x + dx[i];
					ny = temp.y + dy[i];
					if( nx >-1 && ny > -1 && nx < arr.length && ny < arr[nx].length) {
						if(arr[nx][ny]== -1 )
							continue;
						if(arr[nx][ny] == 1)
							continue;
						arr[nx][ny]= 1; 
						list.add(new Point(nx, ny));
						count0--;
//						System.out.println(count0);
					}
				}
			}
			answer++;
		}
//		printarr();
		if(count0 == 0)
			System.out.println(answer);
		else {
			System.out.println(-1);
		}
	}


	static void printarr() {
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
