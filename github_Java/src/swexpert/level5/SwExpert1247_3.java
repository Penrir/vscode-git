package swexpert.level5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//D5 최적경로
public class SwExpert1247_3 {
	static int[] idxarr;
	static int max = Integer.MAX_VALUE;
	static List<Home> arr;
	static List<Home> hc; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC ; test_case++) {
			int n = sc.nextInt();
			
			arr = new ArrayList<>();
			hc = new ArrayList<>();
			
			hc.add(new Home(sc.nextInt(), sc.nextInt()));
			Home last = new Home(sc.nextInt(), sc.nextInt());
			for (int i = 1; i <= n; i++) {
				arr.add(new Home(sc.nextInt(), sc.nextInt())); 
			}
			hc.add(last);
			idxarr = new int[n];
			for (int i = 0; i < idxarr.length; i++) {
				idxarr[i]= i+1; 
			}
			Collections.sort(arr);
//			arr.stream().forEach(System.out::println);
			max = Math.min(max,getDistance());
			System.out.printf("#%d %d%n", test_case, max);
			max = Integer.MAX_VALUE;
		}
	}
	static int getDistance() {
		int distance =0;
		int revdis = 0;
		//회사에서 첫번쨰 손님까지 거리
		distance += getD(hc.get(0), arr.get(0));
		revdis += getD(hc.get(0), arr.get(arr.size()-1));
		//마지막 손님과 집 까지의 거리.
		distance += getD(hc.get(1), arr.get(arr.size()-1));
		revdis += getD(hc.get(1), arr.get(0));
		for (int i = 0; i < arr.size()-1; i++) {
			distance += getD(arr.get(i), arr.get(i+1));
			revdis += getD(arr.get(arr.size() - i-1), arr.get(arr.size() - i - 2 ));
		}
		System.out.println(distance + "    " +  revdis);
		return Math.min(distance, revdis);
	}
	
	static int getD(Home a, Home b) {
		return Math.abs(a.x - b.x)+ Math.abs(a.y - b.y); 
	}
	
	static void perm(int n, int r) {
		if(n== r) {
			//task
			max = Math.min(max, getDistance());
		}
		else {
			for (int i = r; i < n; i++) {
				swap(r, i);
				perm(n, r+1);
				swap(r, i);
			}
		}
	}
	
	private static void swap(int r, int i) {
		// TODO Auto-generated method stub
		int temp = idxarr[r];
		idxarr[r]= idxarr[i];
		idxarr[i]= temp;
	}
	//안됨.
	//permutation해서 만들건데 만들고 난다음 컴패러블 써서 다른 홈과의 거리차이 이용해서 정렬하면 되는지 확인해볼것.
	static class Home implements Comparable<Home>{
		private int x;
		private int y;
		Home(){}
		public Home(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return "Home [x=" + x + ", y=" + y + "]";
		}
		@Override
		public int compareTo(Home o) {
			// TODO Auto-generated method stub
			return (this.x + this.y) - (o.x + o.y);
		}
	}
	
}
