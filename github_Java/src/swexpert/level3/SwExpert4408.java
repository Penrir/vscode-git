package swexpert.level3;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class SwExpert4408 {
	public static void main(String[] args) {
		LinkedList<Move> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				list.add(new Move( a < b ? a : b, a < b ? b : a));
			}
			
			list.sort(Comparator.comparing(Move::getNow).thenComparing(Move::getDes));
			
			list.stream().forEach(System.out::println);
			System.out.println();
			
			int cnt = 0;
			boolean check[] = new boolean[list.size()];
			int tcnt =0;
			int max =0;
			int idx = 0;
			while(tcnt < list.size()) {
				for (int i = 0; i < check.length; i++) {
					if(!check[i]) {
						max = list.get(i).des;
						idx = i;
						check[i]= true; 
						tcnt++;
						break;
					}
				}
				if(max % 2 == 1) {
					max++;
				}
//				System.out.println(Arrays.toString(check));
				for (int i = idx; i < check.length; i++) {
					//이미 방에 들어간 학생이면 패스
					if(check[i]) {
						continue;
					}
					Move temp = list.get(i);
					if(max < temp.now) {
	//					System.out.println(temp.toString());
						check[i]= true;
						max = temp.des;
						tcnt++;
					}
				}
				cnt++;
				//한바퀴 돌고 시작점 재설정
			}
			System.out.printf("#%d %d%n", test_case, cnt);
			
			
			list.clear();
		}
		sc.close();
	}
	
	static class Move{
		int now;
		int des;
		int gap;
		public Move(int now, int des) {
			super();
			this.now = now;
			this.des = des;
			this.gap = Math.abs(des-now);
		}
		public int getNow() {
			return now;
		}
		public void setNow(int now) {
			this.now = now;
		}
		public int getDes() {
			return des;
		}
		public void setDes(int des) {
			this.des = des;
		}
		public int getGap() {
			return gap;
		}
		public void setGap(int gap) {
			this.gap = gap;
		}
		@Override
		public String toString() {
			return "Move [now=" + now + ", des=" + des + ", gap=" + gap + "]";
		}
		
	}
	
}
