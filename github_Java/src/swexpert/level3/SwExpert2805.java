package swexpert.level3;

import java.io.IOException;
import java.util.Scanner;

public class SwExpert2805 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int dc =0;
		int rc =0;
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt();
			dc = (N/2) * (-1);
			rc = 1;
			int answer = 0;
			for (int i = 0; i < N; i++) {
				String string = sc.next();
				for (int j2 = Math.abs(dc); j2 < N-Math.abs(dc); j2++) {
					answer += string.charAt(j2) - '0';
				}
				
				dc++;
				rc += 2;
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}

//읽는 카운트랑 버리는 카운트를 따로 변수지정.
//둘다 abs로 쓰면 될듯
// 5면 처음에 2개 버리고 1개 읽고 2개버림
//			2 1 2	dc = 2 rc = 1     dc = size /2 * (-1)로 시작해서 +1씩
//		2열은 1 3 1   dc = 1	rc = 3		rc는  1로 시작하되 사용할 때 %(size+1)쓰면 될듯 한번에 +2씩
//		3열은 0 5 0	dc = 0	5
//		4	1 3 1			3
// 			2 1 2			1