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

import swexpert.모의역량테스트.벽돌깨기5656.Point;

public class 벽돌깨기5656 {
	private static int answer = Integer.MAX_VALUE;
	private static int[][] map;
	private static int[][] baseMap;
	static int N;
	static int W;
	static int H;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
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
//					baseMap[i][j] = map[i][j]; 
				}
			}
			baseMap = map.clone();
			combOverlap(W, N-1, new int[N]);
			System.out.printf("#%d %d%n", test_case, answer);
			answer = Integer.MAX_VALUE;
		}
	}
	
	public static void combOverlap(int n, int r, int[] result) {
		if(answer == 0) {
			return;
		}
		if( r == -1) {
			//end'
			//solution
			System.out.println(Arrays.toString(result));
			destroy(n, result);
			
			return;
		}
		for (int i = 0; i < n; i++) {
			result[r] = i;
			combOverlap(n, r-1, result);
		}
	}
	//부수기
	private static void destroy(int n, int[] result) {
		Queue<Point> q = new LinkedList<Point>();
		//result에 든 번호에 던지고 부수기
		int row = 0;
		int cnt =0;
		for (int i = 0; i < N; i++) {
			//가장 위에 돌의 행값 찾기
			row =0;
			while(row < H && map[row][result[i]] == 0) row++;
//			System.out.println(row + "  " + result[i]);
			//전부다 0인 행이면 넘어가기
			if(row == H) break;
			//찾은곳 부터 1부수기
			int nx, ny;
			q.offer(new Point(row, i, map[row][result[i]]));
			map[row][result[i]] = 0;
			cnt++;
			Point temPoint;
			//떨어졌을때 벽돌 깨기
			while(!q.isEmpty()) {
				temPoint = q.poll();
				nx = temPoint.x;
				ny = temPoint.y;
				int temp = 0;
				//up
				for (int j = 0; j < temPoint.value; j++) {
					temp = nx -j;
					if(temp>= 0 && map[temp][ny] != 0 ) {
						q.offer(new Point(temp, ny, map[temp][ny]));
						map[temp][ny] = 0;  
						System.out.printf("1x y %d %d%n", temp, ny);
						cnt++;
					}
				}
				//down
				for (int j = 0; j < temPoint.value; j++) {
					temp = nx + j;
					if(temp < H && map[temp][ny] != 0 ) {
						q.offer(new Point(temp, ny, map[temp][ny]));
						map[temp][ny] = 0;  
						System.out.printf("2x y %d %d%n", temp, ny);
						cnt++;
					}
				}
				//right
				for (int j = 0; j < temPoint.value; j++) {
					temp = ny + j;
					if(temp < W && map[nx][temp] != 0 ) {
						q.offer(new Point(nx, temp, map[nx][temp]));
						map[nx][temp] = 0;  
						System.out.printf("3x y %d %d%n", nx, temp);
						cnt++;
					}
				}
				//left
				for (int j = 0; j < temPoint.value; j++) {
					temp = ny - j;
					if(temp >= 0 && map[nx][temp] != 0 ) {
						q.offer(new Point(nx, temp, map[nx][temp]));
						map[nx][temp] = 0;  
						System.out.printf("4x y %d %d%n", nx, temp);
						cnt++;
					}
				}
			}
			//map 재정렬
			down();
		}
		System.out.println("cnt " + cnt);
		calculAnswer();
	}
	private static void calculAnswer() {
		int ans = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != 0 )
					++ans;
			}
		}
		if(ans < answer) {
			System.out.println(ans);
//			printMap();
		}
		answer = Math.min(ans, answer);
	}

	//밑으로 정렬
	private static void down() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < W; i++) {
			//0아닌것 큐에 넣기. 각 열별로
			for (int j = H-1; j >= 0; j--) {
				if(map[j][i]!= 0 ) {
					q.offer(map[j][i]);
					map[j][i] = 0; 
				}
			}
			//해당 열에 0 아닌 수 를 밑에서부터 채우기
			int size = q.size();
			for (int j = 1; j <= size; j++) {
				map[H-j][i] = q.poll(); 
			}
		}
//		printMap();
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
			builder.append("Point [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append(", value=");
			builder.append(value);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
}

