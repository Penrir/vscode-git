package swexpert.level3;

import java.util.Scanner;

public class SwExpert7272 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			String a = sc.next();
			String b = sc.next();
			boolean c = true;
			if(a.length() != b.length()) {
				System.out.printf("#%d %s%n", test_case, "DIFF");
				continue;
			}
			for (int i = 0; i < a.length(); i++) {
				if(circleNum(a.charAt(i)) != circleNum(b.charAt(i))) {
					c = false;
					break;
				}
			}
			if(c) {
				System.out.printf("#%d %s%n", test_case, "SAME");
			}
			else {
				System.out.printf("#%d %s%n", test_case, "DIFF");
			}
			
		}
		
		sc.close();
	}
	public static int circleNum(char a) {
		switch(a) {
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			return 1;
		case 'B':
			return 2;
		default:
			return 0;
		}
	}
	
	
}
