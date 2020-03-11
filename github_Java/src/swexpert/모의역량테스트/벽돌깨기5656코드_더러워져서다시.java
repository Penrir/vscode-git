package swexpert.모의역량테스트;
import java.io.FileInputStream;
import java.util.Arrays;
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

public class 벽돌깨기5656코드_더러워져서다시 {
	private static int answer = Integer.MAX_VALUE;
	private static int[][] map;
	private static int[][] baseMap;
	static int N;
	static int W;
	static int H;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			//부수는거는 bfs로 부수면 될듯. 
			//부수는 위치는 완전검색.한다면  최대 4의 12제곱 ->16백만
			//weight x 4 x 4(쏜 위치 배열) )짜리 배열에 각 열을 쐇을때 남은 갯수들 중에 가장 작은거 저장.
			
			//다시 생각해보니 12개중에 4개 뽑는 중복조합 문제
			//모든 케이스들 다 부숴보면서 최소값이 답.
			N = sc.nextInt();	//벽돌 던지기 횟수
			W = sc.nextInt();	//열
			H = sc.nextInt();	//행
			map = new int[H][W];
			baseMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt(); 
				}
				baseMap[i] = map[i].clone(); 
			}
//			print2Arr();
			
			combOverlap(W, N-1, new int[N]);
			System.out.printf("#%d %d%n", test_case, answer);
			answer = Integer.MAX_VALUE;
		}
	}
	
	public static void combOverlap(int n, int r, int[] result) {
		if( r == -1) {
			//end'
			//solution
//			System.out.println(Arrays.toString(result));
			
			solve(result);
			//refresh map
			map = new int[H][W];
			for (int row = 0; row < H; row++) {
				map[row] = baseMap[row].clone();
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			result[r] = i;
			combOverlap(n, r-1, result);
		}
	}
	static int[] dx = {-1, 0, 1, 0}; 
	static int[] dy = {0, 1, 0, -1};
	public static void solve(int[] result) {
		int row = 0;
		Queue<Point> q = new LinkedList<Point>();
		for (int idx = 0; idx < result.length; idx++) {
			row =0;
			int col = result[idx];
			while(row < H && map[row][col] == 0) row++;
			//해당 줄이 모두 0일때
			if(row == H) {
				continue;
			}
			q.offer(new Point(row, col, map[row][col]));
			map[row][col] = 0; 
			//delete block
			Point temPoint;
			int nx, ny;
			while(!q.isEmpty()) {
				temPoint = q.poll();
				for (int i = 0; i < dx.length; i++) {
					for (int j = 1; j < temPoint.value; j++) {
						nx = temPoint.x + dx[i] * j; 
						ny = temPoint.y + dy[i] * j;
						if(isInBound(nx, ny) && map[nx][ny]!= 0 ) {
							//block crash
							q.offer(new Point(nx, ny, map[nx][ny]));
							map[nx][ny] = 0; 
						}
					}
				}
//				System.out.print(temPoint + "||");
//				q.forEach(System.out::print);
//				System.out.println();
			}
			//block down
			for (col = 0; col < W; col++) {
				for ( row = H-1; row >=0 ; row--) {
					if(map[row][col] != 0 ) {
						q.offer(new Point(row, col, map[row][col]));
						map[row][col] = 0; 
					}
				}
				int size = q.size();
				for ( row = H-1; row >=0 ; row--) {
					if(size == 0) {
						break;
					}
					map[row][col] = q.poll().value; 
					size--;
				}
			}
//			printMap();
		}
		//end crash
		//answer
		int cnt = cntNotZero();
		if(cnt < answer) {
//			printMap();
			answer = cnt;
//			System.out.println("cnt " + cnt);
//			System.out.println(Arrays.toString(result));
//			print2Arr();
		}
//		answer = answer < cnt ? answer : cnt;
	}
	private static void print2Arr() {
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				System.out.print(baseMap[row][col] + " " );
			}
			System.out.print("   ");
			for (int col = 0; col < W; col++) {
				System.out.print(map[row][col] + " " );
			}
			System.out.println();
		}
		System.out.println();
	}
	private static boolean isInBound(int nx, int ny) {
		if(nx >=0 && ny >= 0 && nx < H && ny < W) {
			return true;
		}
		return false;
	}

	private static int cntNotZero() {
		int cnt =0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != 0) {
					++cnt;
				}
			}
		}
		return cnt;
	}

	public static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+ " " );
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static class Point{
		int x;
		int y;
		int value;
		public Point(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			builder.append(x);
			builder.append(", ");
			builder.append(y);
			builder.append("]=");
			builder.append(value);
			builder.append(" ");
			return builder.toString();
		}
		
	}
	
}

