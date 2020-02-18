package baekjoon;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjun11403 {
	static int[][] result;
	static int row=0;
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src\\Baekjun11403.txt"));
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			result = new int[N][N];
			boolean V[][] = new boolean[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < V.length; i++) {
				row = i;
	//			printV(V);
				dfs(arr, i, V);
				for (int j = 0; j < V.length; j++) {
					Arrays.fill(V[j], false);
				}
			}
			printresult();
		}

		sc.close();
	}
	private static void printV(boolean[][] V) {
		// TODO Auto-generated method stub
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(V[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void dfs(int[][] arr, int idx , boolean[][] V) {
		// TODO Auto-generated method stub
//		System.out.println(row + " " + idx);
		for (int i = 0; i < arr.length; i++) {
			if(arr[idx][i] == 1) {
				if(!V[idx][i]) {
					V[idx][i] = true;
					result[row][i] = 1;
					dfs(arr, i, V);
				}
			}
		}
	}
	private static void printresult() {
		// TODO Auto-generated method stub
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
}
