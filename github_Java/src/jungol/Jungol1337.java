package jungol;
import java.util.Arrays;
import java.util.Scanner;

public class Jungol1337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 1 || n > 100 ) {
			System.out.println("INPUT ERROR!");
		}
		else {
			int x =0, y=0;
			int[] dx = {1, 0, -1};
			int[] dy = {1, -1, 0};
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				Arrays.fill(arr[i], -1);
			}
			int cnt =0;
			arr[x][y]= cnt++; 
			for (int i = 0; i < n; i++) {
				int idx = i%3;
				while(x < n && y < n && x > -1 && y > -1) {
					x += dx[idx];
					y += dy[idx];
					if( x < n && y < n && x > -1 && y > -1 && arr[x][y] == -1 ) {
						if(arr[x][y] == -1 ) {
							arr[x][y]= cnt;
							if(cnt == 9) {
								cnt = 0;
							}
							else {
								cnt++;
							}
						}
						else {
							break;
						}
					}
					else {
						x -= dx[idx];
						y -= dy[idx];
						break;
					}
				}
				
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j]+ " " );
				}
				System.out.println();
			}
		}
	}
}
