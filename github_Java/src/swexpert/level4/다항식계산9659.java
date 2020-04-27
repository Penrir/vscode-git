package swexpert.level4;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 다항식계산9659 {
	private static long[][] arr;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
		int mod = 998_244_353;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int [][] command = new int [N-1][3];
			for (int i = 0; i < N-1; i++) {
				for (int j = 0; j < 3; j++) {
					command[i][j] =  sc.nextInt();
				}
			}//end input N
//			System.out.println(Arrays.deepToString(command));
			int M = sc.nextInt();
			arr = new long[N+1][M];
			Arrays.fill(arr[0], 1);
			for (int i = 0; i < M; i++) {
				arr[1][i] = sc.nextInt(); 
			}//end input
			
			for (int idx = 2; idx < N+1; idx++) {
				int[] temp = command[idx-2];
//				System.out.println(Arrays.toString(temp));
				//배열 채우기.
				for (int i = 0; i < M; i++) {
					if(temp[0] == 1) {
						arr[idx][i] = (arr[temp[1]][i] + arr[temp[2]][i])% mod;
					}
					else if(temp[0] == 2) {
						arr[idx][i] = (temp[1] * arr[temp[2]][i])%mod;
					}else if(temp[0] == 3) {
						arr[idx][i] = (arr[temp[1]][i] * arr[temp[2]][i]) % mod;
					}
				}
			}
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			//결과 출력
			int len = arr.length-1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			for (int i = 0; i < M; i++) {
				sb.append(" ").append(arr[len][i]);
			}
			System.out.println(sb);
		}
		sc.close();
	}
}

/*
※ SW expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

N+1개의 다항식 f0(x),f1(x), ⋯, fN(x)가 있다. f0(x)= 1, f1(x) = x이고, i≥2인 fi는 세 정수 ti, ai,bi에 의해 결정된다.

ti =1이면 fi(x) = fai(x) + fbi(x)
ti =2이면 fi(x) = ai × fbi(x)
ti= 3이면 fi(x)= fai(x) × fbi(x)

M개의 수 x1,x2, ⋯, xM이 주어질 때,fN(x1), fN(x2), ⋯, fN(xM)을 계산하는 프로그램을 작성하라.

 
[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(2≤N≤50)이 주어진다.

i번째 줄에는 fi(x)를 구하기 위한 세 정수 ti, ai, bi (1≤ti≤3, 0≤ai,bi ≤i-1)

i의 범위가 2≤i≤N인 것에 주의하라.

다음 줄에는 하나의 정수 M(1≤M≤50)이 주어진다.

다음 줄에는 M개의 정수 x1, x2, ⋯, xM(0≤xi<998,244,353)이 공백 하나로 구분되어 주어진다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를의미하며 1부터 시작한다)를 출력하고,

각테스트 케이스마다 fN(x1), fN(x2),⋯, fN(xM)를 공백 하나로 구분하여 출력한다. 각 수가 매우클 수 있으므로, 998,244,353로 나눈 나머지를 출력하도록 한다.

1			// 테스트 케이스 개수
4			// N = 4
1 0 1		// t2 = 1, a2 = 0, b2 = 1
2 2 2		// t2 = 1, a2 = 0, b2 = 1
3 2 3		// t3 = 2, a3 = 2, b3 = 2
4			// t4 = 3, a4 = 2, b4 = 3
0 1 2 3		// M = 4
			// x1 = 0, x2 = 1, x3 = 2, x4 = 3


#1 2 8 18 32	 
*/