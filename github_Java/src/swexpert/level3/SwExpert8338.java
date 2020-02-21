package swexpert.level3;

import java.util.Arrays;
import java.util.Scanner;
//계산기
public class SwExpert8338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
//			int prev = sc.nextInt();
			sc.nextLine();
			int num;
			String[] in = sc.nextLine().split(" ");
			int[] arr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
			int prev = arr[0];
//			System.out.println(Arrays.toString(arr));
			for (int i = 1; i < n; i++) {
				num = arr[i];
				if( num < 2 || prev < 2) {
					prev += num;
				}
				else {
					prev *= num;
				}
			}
			System.out.printf("#%d %d%n", test_case, prev);
		}
	}
}
