package baekjoon;
import java.util.Scanner;

public class Baekjun11724 {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//? •?  ê°œìˆ˜
		int N = sc.nextInt()+1;
		//ê°„ì„  ê°œìˆ˜
		int M = sc.nextInt();
		arr = new int[N][N];
		int a, b;
		int result =0;
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			arr[a][b] = 1; 
			arr[b][a] = 1; 
		}
		boolean[] V = new boolean[N];
		for (int i = 1; i < arr.length; i++) {
			if(!V[i]) {
				dfs(V, i);
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}
	
	static void dfs(boolean[] V, int idx){
		
		V[idx] = true;
		for (int i = 1; i < arr.length; i++) {
			if(arr[idx][i] == 1) {
				if(!V[i]) {
					dfs(V, i);
				}
			}
		}
		
	}
	
}
