package baekjoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
//전쟁 땅따먹기
public class Baejoon1270 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> maps = new HashMap<>();
		int n = sc.nextInt();
		int temp;
		int answer = -1;
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				temp = sc.nextInt();
				if(maps.get(temp) == null) {
					maps.put(temp, 1);
				}
				else {
					maps.put(temp, maps.get(temp) + 1);
				}
			}
			System.out.println(maps.toString());
			Iterator<Integer> iterator = maps.keySet().iterator();
			while(iterator.hasNext()) {
				temp = iterator.next();
				if(maps.get(temp) > t/2) {
					answer = temp;
					break;
				}
			}
			if(answer == -1) {
				System.out.println("SYJKGW");
			}else {
				System.out.println(answer);
			}
			maps.clear();
			answer = -1;
		}
		
	}
}
