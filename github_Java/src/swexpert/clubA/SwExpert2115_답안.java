package swexpert.clubA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert2115_답안 {
	
	static int N, M, C;
	static int[][] map, maxMap;
//	int N = sc.nextInt(); //벌통들의 크기 N*N  (3 ≤ N ≤ 10)
//	int M = sc.nextInt(); //선택가능 벌통개수  (1 ≤ M ≤ 5)
//	int C = sc.nextInt(); //최대벌꿀양		(10 ≤ C ≤ 30)
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
			N = Integer.parseInt(stringTokenizer.nextToken());
			M = Integer.parseInt(stringTokenizer.nextToken());
			C = Integer.parseInt(stringTokenizer.nextToken());
			map = new int[N][N];
			maxMap = new int [N][N];
			for (int i = 0; i < N; i++) {
				stringTokenizer = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}// end input
			
			//1. 각 i, j 위치에서 연속된 m개를 고려해 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			//2. 두 일꾼의 조합
			System.out.printf("#%d %d%n", test_case, getMaxBenefit());
		}
	}
	
	private static int getMaxBenefit() {
		int max =0;
		int temp =0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {	//1번 일꾼 선택
				//2번 일꾼 선택
				//같은행
				for (int j2 = j+M; j2 <= N-M; j2++) {
					if(maxMap[i][j2] + maxMap[i][j]> max)
					{
						max = maxMap[i][j2] + maxMap[i][j];
					}
				}
				//다른 행부터 마지막 행
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						temp = maxMap[i][j]+ maxMap[i2][j2];
						if(temp > max) {
							max = temp;
						}
					}
				}
			}
		}
		return max;
	}
	
	private static void makeMaxMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeMaxSubSet(i, j, 0, 0, 0);
			}
		}
	}
	
	private static void makeMaxSubSet(int i, int j, int cnt, int sum, int powSum) {
		if(sum > C) {
			return ;
		}
		if(cnt == M) {
			if( maxMap[i][j-cnt] < powSum ) {
				maxMap[i][j-cnt]= powSum;
			}
			return;
		}
		makeMaxSubSet(i, j+1, cnt+1, sum+map[i][j], powSum+(map[i][j]*map[i][j]));
		makeMaxSubSet(i, j+1, cnt+1, sum, powSum);
	}
	
	
	
	public static void print2DArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

/*	input

10
4 2 13
6 1 9 7
9 8 5 8
3 4 5 3
8 2 6 7
3 3 10
7 2 9
6 6 6
5 5 7
4 1 10
8 1 8 2
4 6 1 6
4 9 6 3
7 4 1 3
4 3 12
8 8 6 5
5 2 7 4
8 5 1 7
7 8 9 4
5 2 11
7 5 9 9 6
7 3 7 9 3
1 7 1 4 5
1 7 9 2 6
6 6 8 3 8
6 3 20
8 5 2 4 3 1
4 3 6 1 1 8
4 4 1 2 3 1
1 7 4 9 6 1
6 5 1 2 8 4
3 1 4 5 1 3
7 2 11
2 8 2 5 2 8 6
2 3 7 4 6 4 8
3 7 8 3 9 4 4
8 8 5 9 3 6 9
9 7 6 2 4 1 3
2 9 2 8 9 7 3
2 1 7 2 7 8 3
8 3 12
9 1 6 7 5 4 6 7
9 5 1 8 8 3 5 8
5 2 6 8 6 9 2 1
9 2 1 8 7 5 2 3
6 5 5 1 4 5 7 2
1 7 1 8 1 9 5 5
6 2 2 9 2 5 1 4
7 1 1 2 5 9 5 7
9 4 20
5 2 4 8 3 7 6 2 1
7 9 8 5 8 2 6 3 6
1 9 4 6 7 5 3 1 1
4 4 7 6 2 2 8 1 7
9 6 8 5 7 3 7 9 5
7 3 1 4 1 1 8 5 3
4 6 8 9 4 5 3 8 8
1 3 4 2 4 1 1 3 6
5 9 2 3 5 2 4 8 5
10 5 30
7 4 7 5 9 3 6 4 6 7
8 9 8 4 5 7 8 9 2 9
6 5 3 4 6 4 7 6 3 2
4 7 4 3 4 7 3 3 4 3
3 5 6 4 8 8 2 1 8 6
3 7 9 7 1 7 6 2 8 9
3 6 1 6 8 9 7 7 5 1
4 3 5 6 2 1 2 6 3 6
3 4 9 2 1 5 9 9 6 3
9 9 7 3 7 5 5 5 8 4



#1 174
#2 131
#3 145
#4 155
#5 166
#6 239
#7 166
#8 172
#9 291
#10 464
*/