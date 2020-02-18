package swexpert.level3;

import java.util.Scanner;

public class swexpert7272_D3 {
	public static void main(String[] args) {
		
//		for (int i = 65; i < 65 + 26; i++) {
//			System.out.printf("%c %d,,", (char)i, i);
//			if(i %10 == 0) {
//				System.out.println();
//			}
//		}
		//ê¸??ž ?•˜?‚˜ë¡? ?¸?‹ ?•˜?Š”ê²? - 65, 68, 79, 80, 81, 82 
		//  ADOPQR
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_Case = 1; test_Case <= TC; test_Case++) {
			String a = sc.next();
			String b = sc.next();
			String result = "SAME";
			if(a.length() != b.length()) {
				result = "DIFF";
			}
			else {
				for (int i = 0; i < a.length(); i++) {
					if(score(a.charAt(i)) != score(b.charAt(i))) {
						result = "DIFF";
						break;
					}
				}
			}
			System.out.printf("#%d %s%n", test_Case, result);
		}
		
	}
	
	public static int score(char c) {
		//B
		if((int)c == 66) {
			return 2;
		}
		//A
		if((int) c == 65) {
			return 1;
		}
		//D
		if((int)c == 68) {
			return 1;
		}
		//OPQR
		if((int)c > 77 && (int)c < 83) {
			return 1;
		}
		return 0;
	}
	
	
}
