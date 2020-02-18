package jungol;
import java.util.Scanner;

public class Jungol1329 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt1= 1;
		int cnt2 = n-2;
		int b1 = 0;
		int b2 = 2;
		
		if( n < 1 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
		}
		else {
			while(cnt1 <= n) {
				for (int i = 0; i < b1; i++) {
					System.out.print(" ");
				}
				for (int i = 0; i < cnt1; i++) {
					System.out.print("*");
				}
				System.out.println();
				b1++;
				cnt1 += 2;
			}
			b2 = b1-2;
			while(cnt2 > 0) {
				for (int i = 0; i < b2; i++) {
					System.out.print(" ");
				}
				for (int i = 0; i < cnt2; i++) {
					System.out.print("*");
				}
				System.out.println();
				
				b2--;
				cnt2 -= 2;
			}
		}
	}
}
