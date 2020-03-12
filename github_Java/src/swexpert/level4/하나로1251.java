package swexpert.level4;

import java.util.ArrayList;
import java.util.Comparator;
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

import javax.swing.text.GapContent;

import java.awt.geom.AffineTransform;
import java.io.FileInputStream;

public class 하나로1251 {
	private static double result = 0;
	private static int N;
	static List<island> answerList = new ArrayList<island>();
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= 2; test_case++) {
			N = sc.nextInt();
			List<island> list = new ArrayList<island>();
			for (int i = 0; i < N; i++) {
				list.add(new island(sc.nextInt()));
			}
			for (int i = 0; i < N; i++) {
				list.get(i).y = sc.nextInt();
			}
			double M = sc.nextDouble();
			//end input
			
			
			//우선순위 큐에 넣고 서로소 집합 이용해서 풀기. 프림 알고리즘
			
			
			System.out.printf("#%d %d%n", test_case, result);
		}
	}
	
	static class island{
		int x;
		int y;
		public island(int x) {
			this(x, 0);
		}
		public island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public double distance(island other) {
			return Math.pow(x-other.x, 2) + Math.pow(y-other.y, 2);
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			builder.append(x);
			builder.append(", ");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			island other = (island) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
}

