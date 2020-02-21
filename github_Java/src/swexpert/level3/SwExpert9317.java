package swexpert.level3;

import java.util.Scanner;

//석찬이의 받아쓰기
public class SwExpert9317 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int TC = scanner.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = scanner.nextInt();
			String s1 = scanner.next();
			String s2 = scanner.next();
			int result =0;
			for (int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) == s2.charAt(i)) {
					result++;
				}
			}
			System.out.printf("#%d %d%n", test_case, result);
		}
	}
}
