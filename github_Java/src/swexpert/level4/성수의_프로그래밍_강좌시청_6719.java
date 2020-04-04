package swexpert.level4;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 성수의_프로그래밍_강좌시청_6719 {
	private static double result = 0;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			/**
			 *  N개 찾았고 시간 문제상 이 중에서 K개를 적절한 순서로 선택해 한 번씩 시청
			 *  첫 번째 줄에는 두 정수 N, K ( 1 ≤ K ≤ N ≤ 200 )
			 *  두 번째 줄에는 N개의 정수 M1, … MN ( 1 ≤ Mi ≤ 10000 )
			 *  각 정수는 강좌의 수준
			 *  성수가 얻을 수 있는 실력 수치의 최댓값을 출력
			 */
			int N = sc.nextInt();
			int K = sc.nextInt();
			Integer [] arr = new Integer[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i]= sc.nextInt(); 
			}
			Arrays.parallelSort(arr);
			int len = arr.length;
			for (int i = len - K; i < len ; i++) {
				result = (result + arr[i]) / 2; 
			}
			System.out.printf("#%d %f%n", test_case, result);
			result = 0;
		}
	}
}

