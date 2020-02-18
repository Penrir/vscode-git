package swexpert.level5;
import java.util.Arrays;
import java.util.Scanner;
//최소거리 구하기
//메모이제이션 및 가지치기하는거 구현해보기.
public class SwExpert1247 {
	static int answer=Integer.MAX_VALUE;
	static int[] idx;
	static int[] ax ;
	static int[] ay ;
//	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			
			int n = sc.nextInt();
			ax = new int[n+2];
			ay = new int[n+2];
			//회사좌료
			ax[0] = sc.nextInt();
			ay[0] = sc.nextInt();
			//집좌표
			ax[n+1] = sc.nextInt();
			ay[n+1] = sc.nextInt();
			for (int i = 1; i < n+1; i++) {
				ax[i]= sc.nextInt();
				ay[i]= sc.nextInt(); 
			}
			idx = new int[n];
			for (int i = 0; i < idx.length; i++) {
				idx[i]= i+1; 
			}
			perm(n, 0);
			
			
			System.out.printf("#%d %d%n", test_case, answer);
			answer = Integer.MAX_VALUE;
		}
		
		
	}
	private static int calc(int n) {
		int sum =0;
//		System.out.println(Arrays.toString(idx));
//		System.out.println(Arrays.toString(ax));
//		System.out.println(Arrays.toString(ay));
		for (int i = 0; i < idx.length-1; i++) {
			sum += getDistance(ax[idx[i]], ay[idx[i]], ax[idx[i+1]], ay[idx[i+1]]);
//			System.out.println(sum);
		}
//		System.out.println("----  " + getDistance(ax[0], ay[0], ax[idx[0]], ay[idx[0]]));
//		System.out.println(getDistance(ax[n+1], ay[n+1], ax[idx[n-1]], ay[idx[n-1]]));
		sum += getDistance(ax[0], ay[0], ax[idx[0]], ay[idx[0]]) + getDistance(ax[n+1], ay[n+1], ax[idx[n-1]], ay[idx[n-1]]);
//		System.out.println(sum);
		answer = Math.min(sum, answer);
		return sum;
	}
	
	private static void swap(int a, int b) {
		int temp = idx[a];
		idx[a]= idx[b]; 
		idx[b]= temp; 
	}
	
	private static void perm(int n, int k) {
		if(n == k) {
			calc(n);
		}
		else {
			for (int i = k; i < n; i++) {
				swap(k, i);
				perm(n, k+1);
				swap(k, i);
			}
		}
	}
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	
}
