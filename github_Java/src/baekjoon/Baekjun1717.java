package baekjoon;
import java.util.Scanner;

public class Baekjun1717 {
	private static int[] parent;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//넥스트라인 스플릿이 넥스트 인티져보다 훨씬 메모리 많이 먹음
//		String[] command;
//		command = sc.nextLine().split(" ");
//		int n = Integer.parseInt(command[0]);
//		int m = Integer.parseInt(command[1]);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		makeSet();
		for (int i = 0; i < m; i++) {
//			command = sc.nextLine().split(" ");
//			int c1 = Integer.parseInt(command[1]);
//			int c2 = Integer.parseInt(command[2]);
			int c = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
//			if(command[0].equals("0")) { //union
			if(c == 0) { //union
				union(c1, c2);
			}
			else { //find
				if(findSet(c1) == findSet(c2) ) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}
	
	private static void union(int x, int y) {	
//		parent[findSet(y)] = findSet(x);
		x = findSet(x);
		y = findSet(y);
		if(x == y) {
			return ;
		}
		parent[y] = x;
	}
	
	private static int findSet(int idx) {
		if(idx != parent[idx]) {
			parent[idx]= findSet(parent[idx]);
		}
		return parent[idx];
	}
//	private static int findSet(int idx) {
//		if(idx == parent[idx]) {
//			return idx;
//		}
//		return parent[idx]= findSet(parent[idx]); 
//	}
	
	private static void makeSet() {
		for (int i = 0; i < parent.length; i++) {
			parent[i]= i; 
		}
	}
	
}
