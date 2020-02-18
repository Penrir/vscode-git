package baekjoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
//전쟁 땅따먹기
public class Baejoon1270 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> maps = new HashMap<>();
		//땅의 숫자
		int n = sc.nextInt();
		int temp;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			int answer = 0;
			//병사의 숫자
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				temp = sc.nextInt();
				if(maps.containsKey(temp)) {
					maps.put(temp, maps.get(temp)+1);
				}
				else {
					maps.put(temp, 1);
				}
			}
//			System.out.println(maps.toString());
			Iterator<Integer> iterator = maps.keySet().iterator();
			while(iterator.hasNext()) {
				temp = iterator.next();
				if(maps.get(temp) > t/2) {
					answer = temp;
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("SYJKGW");
			}else {
				System.out.println(answer);
			}
			maps.clear();
			answer = 0;
		}
		
	}
}





