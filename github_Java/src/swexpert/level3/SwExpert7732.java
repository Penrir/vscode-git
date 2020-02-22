package swexpert.level3;

import java.util.Scanner;

//시간 개념
public class SwExpert7732 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine(); //nextInt() 다음에 바로 넥스트라인 쓰면 잘못받아져서 줄바꿈 문자 버림.
		for (int test_case = 1; test_case <= TC; test_case++) {
			Time t1;
			Time t2;
			String[] in;
			//시간 클래스에 입력 넣기.
			in = sc.nextLine().split(":");
			t1 = new Time(Integer.parseInt(in[0]), 
					Integer.parseInt(in[1]),Integer.parseInt(in[2]));
			in = sc.nextLine().split(":");
			t2 = new Time(Integer.parseInt(in[0]), 
					Integer.parseInt(in[1]),Integer.parseInt(in[2]));
			System.out.printf("#%d %s%n", test_case, gap(t1, t2));
		}
		sc.close();
	}
	//시간차이 구하기.
	public static Time gap(Time t1 ,Time t2) {
		Time gap = new Time(0, 0, 0);
		gap.hour = t2.hour - t1.hour;
		gap.minute= t2.minute- t1.minute;
		gap.second = t2.second - t1.second;
		//t2 - t1 했을때 음수나오면 양수로 바꾸면서 더 윗자리를 하나 줄임.
		if(gap.second < 0) {
			gap.minute--;
			gap.second = 60 + gap.second;
		}
		if(gap.minute < 0) {
			gap.hour--;
			gap.minute = 60 + gap.minute;
		}
		if(gap.hour < 0) {
			gap.hour = 24 + gap.hour;
		}
		return gap;
	}
	
	static class Time{
		int hour;
		int minute;
		int second;
		public Time(int hour, int minute, int second) {
			super();
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(String.format("%02d", hour));
			builder.append(":");
			builder.append(String.format("%02d", minute));
			builder.append(":");
			builder.append(String.format("%02d", second));
			return builder.toString();
		}
		
	}
}
