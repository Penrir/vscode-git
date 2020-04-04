package swexpert.level5;
import java.io.FileInputStream;
import java.util.Scanner;

public class 현주가_좋아하는_제곱근_놀이6782 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		long result = 0;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			Long N = sc.nextLong();
			Long temp = 0L;
			int cnt = 0;
			while(N != 2L) {
				System.out.println(N);
				temp = (long) Math.sqrt(N);
				if(temp * temp == N ) {
					// 정수일때
					N = temp;
					++result;
				}
				else {
					result += ((temp+1) * (temp+1)) - N + 1;
					N = temp;
				}
				cnt++;
				if(cnt == 100)
					break;
			} 
//			double temp = 0;
//			while(N != 2) {
//				temp = Math.sqrt(N);
//				if(temp % 1 == 0 ) {
//					// 정수일때
//					N = (long) temp;
//					++result;
//				}
//				else {
//					double ceil = Math.pow(Math.ceil(temp), 2);
//					result += ceil - N + 1;
//					N = (long) Math.sqrt(ceil);
//				}
//			} 
			System.out.printf("#%d %d%n", test_case, result);
			result = 0;
		}
	}
}

