package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon10974 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int n = 8;
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]= i+1; 
		}
//		long start = System.currentTimeMillis();
		perm(n, 0, new int[n], 0);
//		long end = System.currentTimeMillis();
//		System.out.println("perm time  :  " + (end - start));
		
//		start = System.currentTimeMillis();
//		perm2(n, 0, new int[n], 0, new boolean[n]);
//		end = System.currentTimeMillis();
//		System.out.println("perm2 time  :  " + (end - start));
//		
		
	}
	static boolean contain(int[] result, int n) {
		for (int i = 0; i < result.length; i++) {
			if(result[i]== n ) {
				return true;
			}
		}
		return false;
	}
	//V쓰나 n만큼 돌면서 있는지 체크하나 시간 똑같음.
	static void perm2(int n, int k, int[] result, int idx, boolean[] V) {
		if(n == k) {
//			System.out.println(Arrays.toString(result));
		}
		else {
			for (int i = 0; i < arr.length; i++) {
				if(V[i]){
					continue;
				}
				V[i]= true; 
				result[idx]= arr[i]; 
				perm(n, k+1, result, idx+1);
				V[i]= false; 
				result[idx]= 0; 
			}
		}
	}
	static void perm(int n, int k, int[] result, int idx) {
		if(n == k) {
//			System.out.println(Arrays.toString(result));
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+ " " );
			}
			System.out.println();
		}
		else {
			for (int i = 0; i < arr.length; i++) {
				if(contain(result, arr[i])) {
					continue;
				}
				result[idx]= arr[i]; 
				perm(n, k+1, result, idx+1);
				result[idx]= 0; 
			}
		}
	}
	
}
