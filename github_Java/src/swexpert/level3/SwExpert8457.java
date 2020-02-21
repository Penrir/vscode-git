package swexpert.level3;

import java.util.Scanner;

//알 덴테 스파게티
public class SwExpert8457 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int answer = 0;
			int N = sc.nextInt();
			int targetTime = sc.nextInt();
			int margin = sc.nextInt();
			int temp = 0;
			for (int i = 0; i < N; i++) {
				temp = sc.nextInt();
//				if((targetTime + margin) / temp > 0 && temp <= margin*2) {
//					answer++;
//				}
//				if (check(targetTime, margin, temp)) {
//					answer++;
//				}
				int gap = temp;
				while(temp <= targetTime + margin) {
					if(temp >= targetTime - margin) {
						answer++;
						break;
					}
					temp += gap;
				}
			}
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
	public static boolean check(int time, int margin, int sand) {
		if(sand > time)
			return false;
		if(sand > (time + margin) /2) {
			return false;
		}
		for (int i = time-margin; i <= time + margin; i++) {
			if(i / sand > 0 && i % sand == 0) {
				return true;
			}
		}
		return false;
	}
}


/*

TC
2
N(모래시계 갯수) B(타겟시간) E(허용오차)
2 10 2
각 모래시계가 측정가능한 시간.
3 4

3 10 5
16 100 10000

타겟시간+오차 / 모래시계 1이상일때 나머지가 오차*2보다 작거나 같으면 됨.
예시 ) 12 / 3 = 4  나머지 0  
	12/4 = 3 나머지 0
	12/5=2 나머지 2
	12/7 = 1 나머지 5
	12/8 = 1 나머지 4

*/