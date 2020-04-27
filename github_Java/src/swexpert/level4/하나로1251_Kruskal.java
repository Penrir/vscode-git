package swexpert.level4;

import java.util.ArrayList;
import java.util.Arrays;
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
//아직
public class 하나로1251_Kruskal {
	private static double result = 0;
	private static int N;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			xs = new int[N];
			ys = new int[N];
			parents = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {
				xs[i] = sc.nextInt(); 
			}
			for (int i = 0; i < N; i++) {
				ys[i] = sc.nextInt(); 
			}
			makeset();
			//edge 배열 만들기
			double[][] edges = new double[(N*(N-1))/2][3];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx][2] = getDistance(xs[i], ys[i], xs[j], ys[j]);
					idx++;
				}
//				System.out.println(Arrays.toString(edges[i]));
			}
			double seyul = sc.nextDouble();
			//end input
//			System.out.println("idx = " + idx);
			
			
			//Kruscal
			//간선 정렬
			int cnt = 0;
			Arrays.parallelSort(edges,new Comparator< double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1[2], o2[2]);
				}
			});
//			Arrays.stream(edges).forEach(s -> System.out.println(Arrays.toString(s)));
			for (int i = 0; i < edges.length; i++) {
				//싸이클 생기면 넘어감.
				int a = findset((int) edges[i][0]);
				int b =  findset((int) edges[i][1]);
				
//				System.out.println(edges[i][0] + " " + edges[i][1]);
//				System.out.printf("a- %d b- %d %n", a, b);
				if( a == b ) {
					continue;
				}
				//연결
				union(a, b);
				//결과값 증가
				result += edges[i][2];
				cnt++;
				if(cnt == N-1) {
					break;
				}
			}
			
			
			//우선순위 큐에 넣고 서로소 집합 이용해서 풀기. 프림 알고리즘, 크루스칼
			//2차원배열에 간선들 넣고 그래프 만들어서 큐에 넣으면서 뽑고 bfs로 넣고 큐 빌때까지.
			
			
			
			
			
//			System.out.println(cnt);
			System.out.printf("#%d %d%n", test_case, Math.round(result * seyul));
			result = 0;
		}
	}
	static double getDistance(int x1, int y1, int x2, int y2) {
//		System.out.printf("%d %d  %n", x1, x2);
//		System.out.printf("%d %d  %n", y1, y2);
//		System.out.println(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
		return Math.pow(x1-x2,2) + Math.pow(y1-y2, 2);
	}
	
	static int[] xs;
	static int[] ys;
	static int[] parents;
	static void makeset() {
		for (int i = 0, len = parents.length; i < len; i++) {
			parents[i] = i; 
		}
	}
	static int findset(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = findset(parents[x]); 
	}
	static int[] rank;
	static void union( int x, int y) {
		int a = findset(x);
		int b = findset(y);
		if( rank[a]> rank[b]  ) {
			parents[b] = a; 
		}
		else {
			parents[a] = b;
			if(rank[a] == rank[b] ) {
				rank[b]++; 
			}
		}
	}
}

