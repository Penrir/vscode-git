package baekjoon;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 제곱수의_합1699 {
	private static int result = 0;
	private static int n;
	static int cnt = 0;	// 현재 연산횟수
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			int sqrtMax = (int) Math.sqrt(n);
			int tempResult = Integer.MAX_VALUE;
			for (int i = (int) sqrtMax; i > 1; i--) {
				int temp = i;	// 여기서 시작하는 i는 제곱수 나올 수 있는 것중에 제일 큰것.
				//현재 제곱수를 한번씩 더해보면서 기존의 넣을 수 있는 횟수 축적
				int saveN = n;
				while(true) {
					cnt += increaseCnt(temp * temp);
					if (cnt > tempResult) break;
					temp--;
					if(n == 3){
						cnt += 3;
						break;
					}
					if(n == 2) {
						cnt += 2;
						break;
					}
					if(n == 1) {
						cnt++;
						break;
					}
					if(n < 1) {
						break;
					}
				}
				n = saveN;
				System.out.printf("n %d     i %d   cnt %d %n",n,  i*i, cnt);
				if(tempResult > cnt) {
					tempResult = cnt;
				}
				System.out.println("-------");
				cnt =0;
			}
//			System.out.println(tempResult + " RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
			System.out.println(tempResult);
		}
	}
	
	public static int increaseCnt(int sqsq) {
		int cnt = 0;
		int d = sqsq;
		while(sqsq <= n ) {
			cnt++;
			sqsq += d;
		}
		System.out.printf("d %d  n %d  cnt %d %n", d, n, cnt);
		sqsq -= d;
		n -= sqsq;
		return cnt;
	}
	
	public static int greedyFail(int n) {
		long temp = n;
		System.out.println("n = " + n);
		while(true) {
			temp = (int) Math.sqrt(n);
			n -= temp*temp;
			System.out.printf("n = %d, temp = %d\n", n, temp);
			/**
			 4 3 2 2 2 4 2 2 3 4
			  */
			result++;
			if(n == 2) {
				result += 2;
				break;
			}
			if(n == 1) {
				result++;
				break;
			}
			if(n < 1) {
				break;
			}
		}
		System.out.println(result);
		result = 0;
		return result;
	}
	
}

