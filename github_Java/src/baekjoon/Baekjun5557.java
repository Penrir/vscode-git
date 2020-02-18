package baekjoon;
import java.util.Scanner;

public class Baekjun5557 {
	static int Answer =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()-1;
		int[]arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int result = sc.nextInt();
		dfs(arr, result, arr[0], 1);
		System.out.println(Answer);
		sc.close();
	}
	
	
	
	///dfs ?Š” ?‹œê°? ì´ˆê³¼
	//ë©”ëª¨?´? œ?´?…˜?•´?•¼?˜
	static void dfs(int[] arr, int result, int temp , int idx) {
		if(temp < 0 || temp > 20) {
			return;
		}
		if(idx == arr.length) {
			if(result == temp) {
				Answer++;
			}
			return;
		}
		dfs(arr, result, temp + arr[idx], idx+1);
		dfs(arr, result, temp - arr[idx], idx+1);
	}
	
}
