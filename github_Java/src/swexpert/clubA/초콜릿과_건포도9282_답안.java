package swexpert.clubA;

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
import java.io.FileInputStream;

public class 초콜릿과_건포도9282_답안 {
	private static int result = 0;
	static int n, m;
	static int[][] map;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n= sc.nextInt();
			m= sc.nextInt();
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j]= sc.nextInt(); 
				}
			}
//			memo = new int[m][n][m][n];
			memo = new int[n+1][m+1][n+1][m+1];
			//사이즈 정해져있으면
			//처리
			result = dfs(0, 0, n, m, Integer.MAX_VALUE);
			//출력
			
			System.out.printf("#%d %d%n", test_case, result);
		}
	}
	static int[][][][] memo;
	private static int dfs(int y, int x, int h, int w, int min) {
		//end
		if(w== 1 && h == 1) {
			return 0;
		}
		//run
		if(memo[y][x][h][w] != 0 ) {
			return memo[y][x][h][w];
		}
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		//가로로 나누어 최소비용 구하기
		for (int i = 1; i < h; i++) {
			//위쪽 비용
			int sum1 = dfs(y,  x,  i, w, min);
			//아래쪽 비용
			int sum2 = dfs(y + i, x, h - i, w, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		//세로로 나눴을때 최소비용
		for (int i = 1; i < w; i++) {
			int sum1 = dfs(y, x, h, i, min);
			int sum2 = dfs(y, x+ i, h, w-i, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		memo[y][x][h][w] = min; 
		return min;
	}
}

