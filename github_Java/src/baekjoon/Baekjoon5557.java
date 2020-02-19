package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//1학년 문제.
public class Baekjoon5557 {
	
	static long result=0;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\input.txt"));
//		System.setIn(new FileInputStream("C:\\Users\\multicampus\\git\\vscode-git\\github_Java\\src\\input.txt"));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt()+1;
		int[] arr = new int[n];
		for (int i = 1; i < n; i++) {
			arr[i]= scanner.nextInt(); 
		}
//		System.out.println(Arrays.toString(arr));
		long answer = makeResult(arr);
		System.out.println(answer);
		
//		dfs(arr, 1, arr[0]);
//		System.out.println(result);
//		result =0;
		scanner.close();
	}
	
	public static long makeResult(int[] arr) {
		long[] result = new long[21];
		long[] temparr = new long[arr.length];
		result[arr[1]] = 1;
		for (int i = 2; i < arr.length-1; i++) {
			temparr = new long[21];
			//현재 arr의 인덱스까지 0~20  나올 수 있는 경우들 구하기.
			for (int j = 0; j < result.length; j++) {
				//이전 상태에 존재하고 있음.
//				System.out.println(Arrays.toString(result));
				if(j + arr[i] <= 20 ) {
					temparr[j] += result[ j + arr[i]]; 
				}
				if( j - arr[i] >= 0 ) {
					temparr[j] += result[j - arr[i]] ; 
				}
			}
			result = temparr;
//			System.out.printf("%2d: %2d ||", i, arr[i]);
//			System.out.print(arr[i] + "  " + i + "  ");
//			printArr(result);
//			System.out.println(Arrays.toString(result));
		}
		return result[arr[arr.length-1]];
	}
	public static void printArr(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%2d:%2d ", i, arr[i]);
//			System.out.print(i+":" + arr[i] + "  ");
			if( i % 5 == 0) {
				System.out.print("\t");
			}
		}
		System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	//dfs - 시간초과뜸
	public static void dfs(int[]arr, int depth, int answer)
	{
		if(answer > 20 || answer < 0) {
			return;
		}
		if(depth == arr.length-1) {
			if(arr[arr.length-1] == answer) {
				result++;
			}
			return;
		}
		dfs(arr, depth+1, answer + arr[depth]);
		dfs(arr, depth+1, answer - arr[depth]);
	}
	
}
