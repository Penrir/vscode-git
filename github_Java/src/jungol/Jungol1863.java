package jungol;
import java.util.Arrays;
import java.util.Scanner;

public class Jungol1863 {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		makeSet();
		for (int i = 0; i < m; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		System.out.println(Arrays.toString(parent));
		System.out.println(checkMax());
	}
	
	static int checkMax() {
		int result =0;
		for (int i = 1; i < parent.length; i++) {
			if(parent[i]== i )
				result++;
		}
		return result;
	}
	
	static void makeSet(){
		for (int i = 0; i < parent.length; i++) {
			parent[i]= i; 
		}
	}
	static int findSet(int n) {
		if(n == parent[n]) {
			return n;
		}
		return parent[n] = findSet(parent[n]);
	}
	static void union(int a, int b) {
		parent[findSet(b)] = findSet(a);
	}
	
}
