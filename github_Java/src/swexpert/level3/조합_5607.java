package swexpert.level3;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 조합_5607 {
	private static int mod = 1234567891;
	private static int littlemod= 11;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
//			System.out.println(pow(3, 4));
			System.out.println(myPow(n, r));
			System.out.println(myPow(3, 4));
			
			System.out.printf("#%d %d%n", test_case, Fermat(n, r));
			System.out.printf("#%d %d%n", test_case, myFermat(n, r));
		}
	}
	
	public static int basic(int n, int r) {
		long temp = 1;
		// n! /
		//--------------
		//(r! * (n-r)!)
		for (int i = n-r+1; i <= n; i++) {
			temp = (temp * i) % mod;
		}
		long down = 1;
		for (int i = 1; i <= r; i++) {
			down = (down * i) % mod;
		}
		return (int) (temp / down);
	}
	
	public static int Fermat(int n, int r) {
		// r1/r2가 답.  r1/r2 == nCr == n!/((n-r)! * (r!)) 
		long r1 = factorial(n) % mod;
		long r2 = factorial(r) % mod;
		//분모쪽이 r2
		r2 = r2 * (factorial(n-r) % mod) % mod;
		//r2^(mod-2) % mod = 1/r2 % mod;
		r2 = pow(r2, mod-2) % mod;
		r1 = r1 * r2 % mod;
		return (int) r1;
	}
	public static int myFermat(int n, int r) {
		long r1 = factorial(n) % mod;
		long r2 = factorial(r) % mod;
//		System.out.println(r1 + " -1-  " + r2);
		r2 = r2 * (factorial(n-r) % mod) % mod;
//		System.out.println(r1 + " -2-  " + r2);
		
		r2 = power((int) r2, mod-2) % mod;
//		System.out.println(r1 + " -3-  " + r2);
		r1 = r1 * r2 % mod;
//		System.out.println(r1 + " -4-  " + r2);
		return (int) r1;
		
//		return (((myPow(factorial(n), mod-2) % mod) * (myPow(factorial(n-r), mod-2)%mod) * 
//				(myPow(factorial(r), mod-2) % mod) ) % mod);
//		return n!/11 * (n-r)!^9 /11  *   r!^9  /11   ;
	}
	
	public static int factorial(int n) {
		long temp = 1L;
		for (int i = 2; i <= n; i++) {
			temp = (temp * i) % mod;
		}
		return (int) temp;
	}
	
	public static int pow(long x, long y) {
		long xy = 1;
		while( y > 0) {
//			System.out.printf("xy = %d x = %d y = %d%n", xy, x, y);
			if( y % 2 == 1) {
				xy = xy * x % mod;
				y -= 1;
			}
			x = x * x % mod;
			y /= 2;
		}
		return (int) xy;
	}
	public static int myPow(int base, int exp) {
		long semi = 1;
		while(exp > 0) {
			if((exp & 1) == 1) {
				semi *= base;
				exp -= 1;
			}
			base *= base % mod;
			exp /= 2;
		}
		return (int) semi;
	}
	static int power(int base, int exp) {
		//0제곱은 1
		if(exp == 0) {
			return 1;
		}
		//1제곱은 베이스
		if(exp == 1) {
			return base;
		}
		
		long semi_base = power(base, exp/2) % mod;
//		System.out.printf("%d %d %d%n", base, exp, semi_base);
		//exp가 짝수면 exp반으로 나눈거 두개 곱하기
		if(exp % 2 == 0) {
			return (int) ((semi_base * semi_base) % mod);
		}
		//홀수면 두개에다 base한번 더 곱하기.
		else {
			return (int) (((semi_base* semi_base % mod) * base) % mod);
		}
	}

}

