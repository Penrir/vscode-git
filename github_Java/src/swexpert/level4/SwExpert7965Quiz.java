package swexpert.level4;

import java.util.Scanner;

/**
 * 모듈러의 법칙
 * 각 숫자들의 나머지들을 합해서 나눠도 전체합을 나눗것과 같다.
 * @author ptm91
 */
// 1_000_000_007
public class SwExpert7965Quiz {
	static int div = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int size = (int)Math.pow(10, 6) + 1;
//		int size = 1001;
		long[] arr = new long[size];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 5;
		for (int i = 3; i < arr.length; i++) {
			arr[i] = ( (( arr[i-1]%1_000_000_007 ) + (power(i, i) % 1_000_000_007)) % 1_000_000_007);
			arr[i] %=  1_000_000_007;
//			System.out.println(i + "  " +arr[i]);
		}
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			System.out.printf("#%d %d%n", test_case, arr[n]);
		}
	}
//	public static long power(int base, int exp) {
//		int cnt = 1;
//		long result = base;
//		
//		while(cnt < exp) {
//			for (int i = 1; i < exp; i++) {
//				result = 
//			}
//		}
//		
//		
//		return  result;
//	}
	
//	public static long power(int base, int exp) {
//		int cnt = 1;
//		long result = base;
//		while(cnt < exp) {
//			result = (((result % 1_000_000_007) * (base % 1_000_000_007)) % 1_000_000_007);
//			cnt++;
//		}
////		System.out.println(result > 1_000_000_007 ? 1_000_000_007 + "------------" : result);
//		return  result;
//	}
	
	//dfs로 들어갈때 같은 함수 두번 들어가면 터짐.
	//한번 해서 구한걸로 재사용하면 안터짐.
	public static long power(int base, int exp) {
		if(exp == 1) {
			return base;
		}
		long tmp = power(base, exp/2) % div;
		long su = (tmp * tmp)% div;
		if( exp % 2 == 0) {
			return su;
		}
		else {
			return (su*base) % div;
		}
	}
	
}
