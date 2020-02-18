package swexpert.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//단순 2진 암호코드
public class SwExpert1240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int answer = 0;
			HashMap<String, Integer> map = new HashMap<>();
			map.put("0001101", 0);
			map.put("0011001", 1);
			map.put("0010011", 2);
			map.put("0111101", 3);
			map.put("0100011", 4);
			map.put("0110001", 5);
			map.put("0101111", 6);
			map.put("0111011", 7);
			map.put("0110111", 8);
			map.put("0001011", 9);
			int n = sc.nextInt();
			int len = sc.nextInt();
			Integer[] pattern = new Integer[8];
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				if(!line.contains("1")) {
					continue;
				}
				for (int startidx = 0; startidx < len - 48; startidx++) {
					if(map.get(line.substring(startidx, startidx+7)) == null) {
						continue;
					}
					
					for (int j = 0; j < pattern.length; j++) {
						pattern[j] = map.get(line.substring(startidx, startidx+7));
						startidx += 7;
					}
					if(containNull(pattern)) {
						startidx -= 55;
						continue;
					}
//					System.out.println(Arrays.toString(pattern));
					answer = checkPattern(pattern);
				}
			}
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
	
	static boolean containNull(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	static int checkPattern(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]== null ) {
				return 0;
			}
		}
		//암호가 맞을 경우
		if(((arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] +arr[7]) %10 == 0){
			int sum =0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			return sum;
		}
		return 0;
	}
	
}
