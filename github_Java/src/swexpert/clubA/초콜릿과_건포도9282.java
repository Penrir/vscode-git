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

public class 초콜릿과_건포도9282 {
	private static int result = 0;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			
			
			
			System.out.printf("#%d %d%n", test_case, result);
		}
	}
}
/*
사각형의 각 점들을 인덱스로 하는.4차원 배열 만들어서 메모이제이션함.
//왼쪼ㅓㄱ위랑 오른쪽 아래 점만 저장하는 2차원으로도 만들 수 있을 듯 -> x1y1, x2y2 결국 같음
dfs로 하는데 sum = 자른거 합ㅈ + 자른거합
sum 중에 최소 구하기. 
한칸단위로 바뀌면 그 칸의 값 리턴. 
 */
