package swexpert.level3;
import java.io.FileInputStream;
import java.util.Scanner;

public class 팩토리얼과최대공약수7466 {
	private static int result = 0;
	static int mod = 1234567891;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("#%d %d%n", test_case, find(a, b));
		}

	}
	
	public static int find(int a, int b) {
		//factorial 할 필요없이 a가 크면 b는 무조건 하나 이상 나오니 그대로 답.
		if(a>=b) {
			return b;
		}
		int ans =1;
		for (int i = a; i > 0; i--) {
			//b가 나눠진다면 b를 소인수붅해한것처럼 줄일 수 있음. 
			if( b % i == 0) {
				//최대ㅔ공약수에 해당 숫자 추가.
				ans*=i;
				b /= i;
				//더이상 할게 없으므로 리턴
				if ( b== 1) {
					return ans;
				}
				//b가 작아지면 i까지 올라오는 팩토리얼에 무조건 포함되므로 
				if(i >= b) {
//					i = b +1;
					//이때까지 해왔던 공약수에 현재b값 곱하고 답으로 출력.
					return ans * b;
				}
			}
		}
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static int factorial(int n) {
		long temp = 1L;
		for (int i = 2; i <= n; i++) {
			temp = (temp * i);
		}
		System.out.print(n + "fact = "+ temp + " \t\t");
		return (int) temp;
	}
	public static int gcd(int a, int b) {
		if( a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if(b==0) return a;
		return gcd(b, a%b);
	}
	public static int gcdIter(int a, int b) {
		int temp =0;
		while(b > 0) {
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
//	public static long 최소공배수(long a, long b) {
//		long gcd = gcd(a, b);
//		return ((a * b) % mod) / gcd;
//	}
//	public static long lcm(long a, long b) {
//		long gcd = gcd(a, b);
//		return ((a * b) % mod) / gcd;
//	}
	public static int 최대공약수(int n, int r) {
		if(n % r == 0) {
			return r;
		}
		return 최대공약수(r, n%r);
	}
}

