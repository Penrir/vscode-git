package swexpert.level3;

import java.util.Scanner;

public class SwExpert1234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=0;
		boolean flag  = true;
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = sc.nextInt();
			String string = sc.next();
			loop:
			while(flag){
				for (int i = 0; i < string.length()-1; i++) {
					if(string.charAt(i) == string.charAt(i+1)) {
		//				System.out.println(i);
			//			System.out.println("Before");
				//		System.out.println(string);
						string = String.format("%s%s", string.substring(0, i), string.substring(i+2, string.length()));
					//	System.out.println(string);
						continue loop;
					}
				}
				break;
			}
			System.out.printf("#%d %s%n", test_case, string);
		}
		
	}
}
