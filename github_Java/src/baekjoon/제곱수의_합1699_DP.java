package baekjoon;
import java.util.Scanner;

public class 제곱수의_합1699_DP {
	public static int[] memo = new int[100001];
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			memo[i] = i; 
		}
		fillMemo();
//		for (int i = 0; i < 50; i++) {
//			System.out.print(i + ": " + memo[i]+ "\t "  );
//			if(i%10 == 0) System.out.println();
//		}
		System.out.println(memo[sc.nextInt()]);
	}
	public static void fillMemo() {
		for (int i = 4; i < memo.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				//1 부터 i의 제곱근까지 가면서 i-j^2들의 값중 가장 작은 값 +1 이 답.
				if(min > memo[i - (j*j)]) {
					min = memo[i - (j*j)];
				}
			}
			memo[i]= min+1; 
		}
	}
}

