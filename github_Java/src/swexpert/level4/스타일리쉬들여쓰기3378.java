package swexpert.level4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
import java.util.StringTokenizer;

public class 스타일리쉬들여쓰기3378 {
	private static int[][] m;
	private static int[][] dap;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			m = new int[p][4]; // . 소 중 대
			for (int i = 0; i < p; i++) {
				String line = sc.next(); // 한줄을 입력받아서
				// 앞부분에 나온 .의개수
				int index = 0; 
				while(line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index;
				// 괄호의 개수 는 누적처리
				if (i > 0) { // 이전 값으로 초기화
					m[i][1] = m[i-1][1]; // 소괄호
					m[i][2] = m[i-1][2]; // 중괄호
					m[i][3] = m[i-1][3]; // 대괄호
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': m[i][1]++; break;
					case ')': m[i][1]--; break;
					case '{': m[i][2]++; break;
					case '}': m[i][2]--; break;
					case '[': m[i][3]++; break;
					case ']': m[i][3]--; break;
					}
				}
			} // 마스터의 스타일리쉬 코드 분석 for
		
			// 내코드 입력
			dap = new int[q][4]; // . 소 중 대
			for (int i = 0; i < q; i++) {
				String line = sc.next(); // 한줄을 입력받아서
				// 앞부분에 나온 .의개수
				int index = 0; 
				
				// 괄호의 개수 는 누적처리
				if (i > 0) { // 이전 값으로 초기화
					dap[i][1] = dap[i-1][1]; // 소괄호
					dap[i][2] = dap[i-1][2]; // 중괄호
					dap[i][3] = dap[i-1][3]; // 대괄호
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': dap[i][1]++; break;
					case ')': dap[i][1]--; break;
					case '{': dap[i][2]++; break;
					case '}': dap[i][2]--; break;
					case '[': dap[i][3]++; break;
					case ']': dap[i][3]--; break;
					}
				}
			} // 내 코드 분석 for
			
			// dap[i][0] : 초기값 -2 .의 개수를 몇개 
			for (int i = 0; i < q; i++) {
				dap[i][0] = -2; // 안쓰는 값으로 초기화
			}
			// 중복 순열
			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if(check(R,C,S)) { // 마스터 코드에서 해가 되는가?
							cal(R,C,S);
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(test_case).append(" 0"); // 첫번째 줄의 들여쓰기는 0으로 일정
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
			}
			System.out.println(sb);
		}
	}
	/** 내 코드에서 들여쓰기를 각 라인에 몇개씩 해야하는지 구해서 dap 배열에 저장 */
	private static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i-1][1]*R+ dap[i-1][2]*C + dap[i-1][3]*S;
			if (dap[i][0] == -2) { // 답을 구한적이 없으면
				dap[i][0] = x;
			} else if (dap[i][0] != x) { // 기존값과 다른 들여쓰기 값이 생긴다면
				dap[i][0] = -1;
			}
		}
	}
	/** 마스터 코드에서 해가 되는지 체크해서 리턴  */
	private static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] != m[i-1][1]*R+ m[i-1][2]*C + m[i-1][3]*S) {
				return false;
			}
		}
		return true;
	}
	


}

