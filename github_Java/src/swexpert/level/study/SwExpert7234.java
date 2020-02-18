package swexpert.level.study;
import java.util.Scanner;

public class SwExpert7234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt()+1; // 배열 크기
			int B = sc.nextInt(); // 안전기지 개수
			int[][] arr = new int[N][N];
			for (int i = 0; i < B; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				plus(arr, x, y);
			}
			int answer = findMax(arr);
			System.out.printf("#%d %d%n", test_case, answer);
			
		}
		
		
	}
	static int [] dx = { -1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static void plus(int[][] arr, int x, int y) {
		int nx = x; 
		int ny = y;
		for (int i = 0; i < dx.length; i++) {
			for (int j = 1; j <= 2; j++) {
				nx = x + (dx[i] * j) ;
				ny = y + (dy[i] * j) ;
				if(nx >= arr.length || ny >= arr.length || nx <1 || ny < 1) {
					break;
				}
				arr[nx][ny]++; 
			}
		}
	}
	private static int findMax(int[][]arr) {
		int max = 0;
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				max = Math.max(max,  arr[i][j]);
			}
		}
		
		return max;
	}
}
