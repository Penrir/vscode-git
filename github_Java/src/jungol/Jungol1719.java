package jungol;

import java.util.Scanner;

public class Jungol1719 {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int type = sc.nextInt();
		if(N < 1 || N >100 || type < 1 || type > 4 || N % 2 == 0) {
			System.out.println("INPUT ERROR!");
		}
		else {
			switch(type) {
			case 1:
				print1(N);
				break;
			case 2:
				print2(N);
				break;
			case 3:
				print3(N);
				break;
			case 4:
				print4(N);
				break;
			}
		}
		sc.close();
	}
	static void print1(int n) {
		int num = (n/2) * (-1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < ((n/2) +1) - Math.abs(num); j++) {
				System.out.print("*");
			}
			System.out.println();
			num++;
		}
	}
	static void print2(int n) {
		int num = (n/2) * (-1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.abs(num); j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < ((n/2) +1) - Math.abs(num); j++) {
				System.out.print("*");
			}
			System.out.println();
			num++;
		}
	}
	static void print3(int n) {
			// ºóÄ­Àº 0 1 2 1 0
			// º°Àº    5 3 1 3 5
		int idx = n;
		int blank = (n/2) * (-1);
		for (int i = 0; i < n; i++) {
//			System.out.println(idx);
			for (int j = Math.abs(blank); j < n/2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < Math.abs(idx); j++) {
				System.out.print("*");
			}
			idx -= 2;
			if(idx == -1) {
				idx = -3;
			}
			blank++;
			System.out.println();
		}
	}
	static void print4(int n) {
		//blank 0 1 2 2 2 
		// star 3 2 1 2 3
		int blank = 0;
		int star = (n/2) + 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < blank; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < Math.abs(star); j++) {
				System.out.print("*");
			}
			System.out.println();
			star--;
			if(star == 0) {
				star = -2;
			}
			blank++;
			if(blank > n/2)
				blank = n >> 1;
		}
	}
}
