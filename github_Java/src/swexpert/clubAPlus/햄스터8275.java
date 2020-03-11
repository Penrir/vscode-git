package swexpert.clubAPlus;

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

public class 햄스터8275 {
	private static int result = 0;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * 큐에 가능한 경우 다 넣어두고 입력 끝났을때 큐에 남은 것 중에 가장 오름차순 가장 앞에께 답
			 * 조건을 만족하는 모든 경우의 수 다 큐에 넣기.
			 * 큐돌면서 조건 출족하는것만 추가 반복. 
			 */
			
			
			
			System.out.printf("#%d %d%n", test_case, result);
		}
	}
}

/*
 세 정수 N, 	X, 			M
 (우리 갯수, 햄스터 숫자 최대값, 기록 수)
 1 ≤ N ≤ 6, 1 ≤ X, M ≤ 10
 
3
3 5 1
1 2 5
3 5 2
1 2 6
2 3 7
4 5 2
1 3 15
3 4 4


*/

