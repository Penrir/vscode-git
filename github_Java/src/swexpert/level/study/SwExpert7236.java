package swexpert.level.study;
import java.util.Scanner;

public class SwExpert7236 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt();
			char[][] crr = new char[N][N];
			for (int i = 0; i < crr.length; i++) {
				for (int j = 0; j < crr.length; j++) {
					crr[i][j] = sc.next().charAt(0); 
				}
			}
			int answer = 0;
			for (int i = 0; i < crr.length; i++) {
				for (int j = 0; j < crr.length; j++) {
					if(crr[i][j]== 'W' ) {
						answer = Math.max(depth(crr, i, j),  answer);
					}
				}
			}
			System.out.printf("#%d %d%n", test_case, answer);
			
		}
	}					//상 우 하 좌 우하, 좌하, 우상, 좌상
	static int[] dx = { -1, 0, 1, 0, 1, 1, -1, -1};
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
	private static int depth(char[][] crr, int i, int j) {
		int sum=0;
		int nx, ny;
		for (int k = 0; k < dx.length; k++) {
			nx = i + dx[k];
			ny = j + dy[k];
			if(nx < 0 || ny < 0 || nx >= crr.length || ny >= crr.length) {
				continue;
			}
			if(crr[nx][ny]== 'W') {
				sum++;
			}
		}
		if(sum ==0) {
			sum++;
		}
		return sum;
	}
}
