package swexpert.level3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//극장좌석
public class SwExpert8500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n= sc.nextInt();
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			list.sort((o1, o2) -> o2-o1);
//			list.forEach(System.out::print);
//			System.out.println();
			int max = list.get(0);
			System.out.printf("#%d %d%n", test_case, 
					list.parallelStream().map(Integer::intValue).reduce(0, Integer::sum)
					+ list.size() + max);
		}
		sc.close();
	}
}
