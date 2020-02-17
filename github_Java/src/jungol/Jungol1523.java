package jungol;

import java.util.Scanner;

public class Jungol1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int type = sc.nextInt();
		if(N < 1 || N >100 || type < 1 || type > 3) {
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
			}
		}
		sc.close();
	}
	static void print1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void print2(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n-i; j >0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void print3(int n) {
		int idx = 1;
		for (int i = 0; i < n; i++) {
			for (int j = n-i-1; j >0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < idx; j++) {
				System.out.print("*");
			}
			System.out.println();
			idx += 2;
		}		
	}
}
