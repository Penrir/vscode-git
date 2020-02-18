package baekjoon;
import java.util.Scanner;

public class Baekjun5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int ans1;
		if(A%C == 0) {
			ans1 = A/C;
		}else {
			ans1 = (A/C) + 1;
		}
		int ans2;
		if(B%D == 0) {
			ans2 = B/D;
		}else {
			ans2 = (B/D) + 1;
		}
		
		System.out.println(L - Math.max(ans1, ans2));
		
	}
}
