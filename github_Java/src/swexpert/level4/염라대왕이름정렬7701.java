package swexpert.level4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
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
import java.util.Set;
import java.util.TreeSet;
import java.io.FileInputStream;

public class 염라대왕이름정렬7701 {
	private static int N;
	public static void main(String args[]) throws Exception {
		long start = System.currentTimeMillis();
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			TreeSet<String> set = new TreeSet<String>();
//			Set<String> set = new HashSet<String>();
			for (int i = 0; i < N; i++) {
				set.add(sc.next());
			}
//			System.out.println(Arrays.deepToString(srr));
//			Arrays.stream(srr).sorted(Comparator.comparing(String::length)
//					.thenComparing(Comparator.naturalOrder())).forEach(System.out::println);;
//			System.out.println();
//			for(String string : srr) {
//				set.add(string);
//			}
//			System.out.println("#" + test_case + " ");
			
			
			sb.append("#" + test_case + "\n");
			
//			set.descendingSet().forEach(s-> sb.append(s + "\n"));;
//			set.descendingSet().descendingSet().forEach(s-> sb.append(s + "\n"));;
			set.stream()
				.sorted(Comparator.comparing(String::length)
						.thenComparing(Comparator.naturalOrder()))
				.forEach(s -> sb.append(s + "\n"));
			
//			set.stream().soator.comparing(String::length)
//					.thenComparing(Comparatrted(Comparor.naturalOrder())).forEach(x -> sb.append(x+"\n"));;
					
//			set.stream().sorted(Comparator.comparing(String::length)
//					.thenComparing(Comparator.naturalOrder())).forEach(System.out::println);;
					
					
			System.out.print(sb);
//			System.out.printf("#%d %d%n", test_case, result);

		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		sc.close();
	}
}

