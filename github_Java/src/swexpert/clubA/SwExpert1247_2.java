package swexpert.clubA;

import java.util.Scanner;

//D5 최적경로
public class SwExpert1247_2 {
	static int[] idxarr;
	static int max = Integer.MAX_VALUE;
	static Home[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC ; test_case++) {
			int n = sc.nextInt();
			
			arr = new Home[n+2];
			arr[0] = new Home(sc.nextInt(), sc.nextInt());
			arr[n+1] = new Home(sc.nextInt(), sc.nextInt());
			for (int i = 1; i <= n; i++) {
				arr[i]= new Home(sc.nextInt(), sc.nextInt()); 
			}
			idxarr = new int[n];
			for (int i = 0; i < idxarr.length; i++) {
				idxarr[i]= i+1; 
			}
			perm(n, 0);
			System.out.printf("#%d %d%n", test_case, max);
			max = Integer.MAX_VALUE;
		}
	}
	static int getDistance() {
		int distance =0;
		//회사에서 첫번쨰 손님까지 거리
		distance += getD(arr[0], arr[idxarr[0]]);
		//마지막 손님과 집 까지의 거리.
		distance += getD(arr[arr.length-1], arr[idxarr[idxarr.length-1]]);
		for (int i = 0; i < idxarr.length-1; i++) {
			distance += getD(arr[idxarr[i]], arr[idxarr[i+1]]);
		}
		return distance;
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

	//permutation해서 만들건데 만들고 난다음 컴패러블 써서 다른 홈과의 거리차이 이용해서 정렬하면 되는지 확인해볼것.
	static class Home{
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
	}
	
}
