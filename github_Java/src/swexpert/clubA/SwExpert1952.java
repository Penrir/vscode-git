package swexpert.clubA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

public class SwExpert1952 {
	private static int answer=0;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int n;
	private static int m;
	static List<String> list = new ArrayList<String>();
	static HashSet<Character> container;
	static int[][]visit;
	static int v;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();	
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			m = sc.nextInt();
			for (int i = 0; i < n; i++) {
				list.add(sc.next());
			}
//			StringBuilder sb = new StringBuilder().append(list.get(0).charAt(test_case));
			visit = new int[n][m];
			container = new HashSet<Character>();
			dfsUseBit( 0, 0, 1);
//			dfs( 0, 0, 1);
			System.out.printf("#%d %d%n", test_case, answer);
			answer = 0;
			list.clear();
			v =0 ;
		}
	}
	public static void printBit() {
		for (int i = 0; i < 26; i++) {
			System.out.print((v & (1 << i)) == 0 ? 0 : (char)(i + 'A') );
		}
		System.out.println();
	}
	public static void dfsUseBit(int x, int y, int depth) {
		int nx, ny;
		v = v | 1 << list.get(x).charAt(y)-'A';
//		System.out.println(v);
		printBit();
		for (int i = 0; i < dx.length; i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			if(isInBound(nx, ny) && (v & 1 << list.get(nx).charAt(ny)-'A') == 0) {
				dfsUseBit(nx, ny, depth+1);
				v &= ~(1 << list.get(nx).charAt(ny)-'A');
			}
		}
		if(depth > answer) {
			answer = depth;
		}
	}
	
	public static void dfs( int x, int y, int depth) {
		int nx, ny;
		container.add(list.get(x).charAt(y));
		if(container.size() == 26) {
			answer = 26;
			return ;
		}
		for (int i = 0; i < dx.length; i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			
			//바뀐좌표가 이동가능한곳,, 기존에 이동한곳이 없는 경우만.
			if(isInBound(nx, ny) //방문x  
					&& !container.contains(list.get(nx).charAt(ny))) {
//				System.out.printf("%c %d %d %s%n",list.get(nx).charAt(ny), nx, ny, container.toString());
				dfs(nx, ny, depth+1);
				container.remove(list.get(nx).charAt(ny));
			}
		}
		if(depth > answer) {
			answer = depth;
		}
	}
//	public static void dfs( int x, int y, int depth) {
//		int nx, ny;
//		container.add(list.get(x).charAt(y));
//		visit[x][y]= 1; 
//		if(container.size() == 26) {
//			answer = 26;
//			return ;
//		}
//		for (int i = 0; i < dx.length; i++) {
//			nx = x+dx[i];
//			ny = y+dy[i];
//			
//			//바뀐좌표가 이동가능한곳,, 기존에 이동한곳이 없는 경우만.
//			if(isInBound(nx, ny) && visit[nx][ny] == 0 //방문x  
//					&& !container.contains(list.get(nx).charAt(ny))) {
////				System.out.printf("%c %d %d %s%n",list.get(nx).charAt(ny), nx, ny, container.toString());
//				dfs(nx, ny, depth+1);
//				container.remove(list.get(nx).charAt(ny));
//				visit[nx][ny] = 0; 
//			}
//		}
//		if(depth > answer) {
//			answer = depth;
//		}
//	}
	
//	public static boolean isInChar(char a, String s) {
//		for(int i = 0; i < s.length() ; i ++) {
//			if(s.charAt(i) == a) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public static boolean isInBound(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<m) {
			return true;
		}
		return false;
	}
}