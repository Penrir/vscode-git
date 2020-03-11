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
import java.io.PrintStream;

public class SwExpert2115 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); //벌통들의 크기 N*N  (3 ≤ N ≤ 10)
			int M = sc.nextInt(); //선택가능 벌통개수  (1 ≤ M ≤ 5)
			int C = sc.nextInt(); //최대벌꿀양		(10 ≤ C ≤ 30)
			int[][] arr = new int[N][N]; //벌통입력 넣어두는 배열
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j]= sc.nextInt(); 
				}
			} // 벌통에 있는 꿀양 입력 받음
			System.out.printf("--- %d %d ---%n", M, C);
			print2DArr(arr);
			//문제풀이
			/*
			 * 1~10 개가 최대이므로 10개중에 두개 선택하는경우의 수는 45개. + 한줄에 두번 선택가능한거까지 최대 90개
			 * + 한줄에 하나씩 선택할때 10개줄에 6종류.
			 * 90개 선택중에 5개 선택시  최대 선택가능 숫자는 5팩 = 120개 부분집합 다 구해서 최대점수 구하기.
			 *** 각 시작 위치별 최대 점수 계산 후에 조합을 사용해서 최대점수를 뽑는게 중복된 계산 없이 하는 방법임.
			 *
			 * 맵에 넣고 맥스수익맵 하나 더 만들어서 계산해 넣어두기. 그리고 거기서 두개 고르는거 다 확인
			 */
			
		}
	}
	public static Temp calculateScore(int[][] arr, int x, int y, int len) {
		Temp answer = new Temp(x, y, len, 0);
		
		
		//answer.score = ?;
		return null;
	}
	
	static class Temp{
		int x;	//시작행
		int y;	//시작열
		int len; // 벌꿀통 가로길이
		int score;	//해당길이에서 가장 높은 점수
		public Temp(int x, int y, int len, int score) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
			this.score = score;
		}
	}
	
	public static void print2DArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int getScore(int x, int y) {
		return (x*x) + (y*y);
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