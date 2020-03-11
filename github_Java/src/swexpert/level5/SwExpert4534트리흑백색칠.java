package swexpert.level5;

import java.util.Arrays;
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
import java.awt.Color;
import java.io.FileInputStream;

public class SwExpert4534트리흑백색칠 {
	private static int result = 0;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr= new int[N+1][N+1];
			int a, b;
			for (int i = 0; i < N-1; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				arr[a][b]= 1;
				arr[b][a]= 1; 
			}//end input
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			
			System.out.printf("#%d %d %n", test_case, result);
			result  = 0;
		}
	}
	
	
	
	
//	int[] V = new int[N+1];
//	V[1] = 1;
//	dfs(0, arr, V, 1);
//	V[1] = 2;
//	dfs(0, arr, V, 1);
//	public static void dfs(int depth, int[][]arr, int[] VisitedWB, int state) {
//		System.out.printf("depth = %d, s=%d ,%d%n", depth, state, VisitedWB[state]);
//		if(depth == arr.length-2) {
//			if(check(VisitedWB, arr)) {
//				result++;
//			}
//			return;
//		}
//		int color = VisitedWB[state];
//		//1 = black,    2 = white,    0= not visited
//		if(color == 1) {
//			for (int i = 1; i < VisitedWB.length; i++) {
//				if( arr[state][i]== 1 && VisitedWB[i]==0  ) {
//					VisitedWB[i]= 2; 
//					dfs(depth+1, arr, VisitedWB, i);
//					VisitedWB[i] = 0; 
//				}
//			}
//		}
//		else if(color == 2) {
//			for (int i = 1; i < VisitedWB.length; i++) {
//				if( arr[state][i]== 1 && VisitedWB[i]==0  ) {
//					VisitedWB[i]= 2; 
//					dfs(depth+1, arr, VisitedWB, i);
//					VisitedWB[i] = 0; 
//					VisitedWB[i]= 1; 
//					dfs(depth+1, arr, VisitedWB, i);
//					VisitedWB[i] = 0; 
//				}
//			}
//		}
//	}
//
//	private static boolean check(int[] visitedWB, int[][] arr) {
//		System.out.println("check");
//		for (int i = 0; i < visitedWB.length; i++) {
//			//현재 노드 주변 검사
//			//현재 노드가 검은색이면 주변 검사함
//			if(visitedWB[i]== 1 ) {
//				for (int j = 0; j < arr.length; j++) {
//					//해당노드와 연결된 곳에 검은색 있으면 실패
//					if(arr[i][j] == 1) {
//						if(visitedWB[j]== 1 )
//							return false;
//					}
//				}
//			}
//		}
//		return true;
//	}
//	
}

