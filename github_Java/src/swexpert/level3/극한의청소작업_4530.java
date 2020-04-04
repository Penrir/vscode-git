package swexpert.level3;
import java.util.Scanner;

import javax.xml.transform.Templates;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 극한의청소작업_4530 {
	private static long result = 0;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
//		System.out.println(test(-40040));
//		test(1);
//		System.out.println(test(40000));
		for (int test_case = 1; test_case <= T; test_case++) {
			long start = sc.nextLong();
			long end = sc.nextLong();
			long a = calc(start);
			long b = calc(end);
			if(start < 0 && end < 0) {
				result += a-b;
			}else if(start < 0) {
				result += a+b-1;
			}else {
				result += b-a;
			}
			System.out.printf("#%d %d%n", test_case, result);
			result = 0;
		}
	}
	public static long test(long i) {
//		System.out.println(test(4));
//		System.out.println(test(40));
//		System.out.println(test(400));
//		System.out.println(test(5400));
//		System.out.println();
		System.out.println(brutForce(0, 10));
		System.out.println(brutForce(0, 100));
		System.out.println(brutForce(0, 1000));
		System.out.println(brutForce(0, 10000));
		System.out.println(brutForce(0, 100000));
		System.out.println(brutForce(0, 1000000));
		return Long.toString(i).length() - Long.toString(i).indexOf("4");
	}
	
	public static long calc(long n) {
		long ans = 0;
//		System.out.println("shorNum = " + n);
		String temp = Long.toString(n);
		if(n < 0) {
			temp = temp.substring(1);
		}
		int len = temp.length();
		for (int i = 0; i < len; i++) {
			int tnum = temp.charAt(i)- '0';
//			System.out.println("tnum " + tnum + " rresult =  " + ans + " len = " + len);
			if(tnum >= 4) tnum--;
			ans += (Math.pow(9, len - i -1) * tnum); 
		}
//		System.out.println("result " + ans);
//		System.out.println("-----------------");
		return ans;
	}
	
	//무식한거랑 차이 별로 없음.
	public static long 도전2(long start, long end) {
		long answer = 0;
		int idx = 0;
		for (long i = start+1; i <= end; i++) {
			if(i == 0) {
				continue;
			}
			if(Long.toString(i).contains("4")) {
				idx = Long.toString(i).length() - Long.toString(i).indexOf("4");
				i += Math.pow(10, idx-1) -1;
				continue;
			}
			if(Math.abs(i) % 1000 == 0) System.out.println(answer);
			++answer;
		}
		return answer;
	}
	public static long brutForce(long start, long end) {
		long answer = 0;
		for (long i = start+1; i <= end; i++) {
			if(i == 0) {
				continue;
			}
			if(Long.toString(i).contains("4")) {
				continue;
			}
			++answer;
		}
		return answer;
	}
}

