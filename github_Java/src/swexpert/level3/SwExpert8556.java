package swexpert.level3;

import java.awt.Frame;
import java.util.Scanner;
//북북서
// 서 = 90
//북서 = 90 - (90/2)
//북북서 = 45 - (90/2^2)
public class SwExpert8556 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer TC = scanner.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			//north = a - (90/2^n)
			//west = a + (90/2^n)
			String string = scanner.next();
			Fraction fraction =new Fraction(0, 1);
			int count=0;
			for (int idx = string.length()-1; idx >= 0; idx--) {
				if(string.charAt(idx) == 'w') {
					fraction.nextWest(count++);
//					System.out.println(fraction);
				}
				else if(string.charAt(idx) == 'n') {
					fraction.nextNorth(count++);
//					System.out.println(fraction);
				}
			}
			System.out.printf("#%d %s%n", test_case, fraction);

		}
	}
	public static class Fraction{
		int denominator; // 분모
		int numerator; // 분자
		public Fraction(int denominator, int numerator) {
			super();
			this.denominator = denominator;
			this.numerator = numerator;
		}
		@Override
		public String toString() {
			return isInt() ? Integer.toString(denominator): denominator + "/" + numerator;
		}
		public boolean isInt() {
			if(numerator == 0) {
				return true;
			}
			return denominator % numerator == 0 ? true : false;
		}
		public void setInt() {
			denominator = denominator / numerator;
			numerator = 1;
		}
		public void nextWest(int count) {
			denominator = (int) (denominator * (Math.pow(2, count)/numerator) + 90);
			if(denominator < 0) {
				denominator =0;
			}
			numerator = (int) Math.pow(2, count);
			while(denominator%2 == 0 && numerator % 2 == 0 && denominator != 0) {
				denominator /= 2;
				numerator /= 2;
//				System.out.println("iidd  " + denominator);
//				System.out.println("iinn  " + numerator);
			}
		}
		public void nextNorth(int count) {
			denominator = (int) (denominator * (Math.pow(2, count)/numerator) - 90);
			if(denominator < 0) {
				denominator =0;
			}
			numerator = (int) Math.pow(2, count);
//			System.out.println("dd  " + denominator);
//			System.out.println("nn  " + numerator);
			while(denominator%2 == 0 && numerator % 2 == 0 && denominator != 0) {
				denominator /= 2;
				numerator /= 2;
//				System.out.println("oodd  " + denominator);
//				System.out.println("oonn  " + numerator);
			}
		}
	}
}
