package jungol;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//안된거임

public class Jungol2116_usedict {
	public static void main(String[] args) {
		//바닥이 0일때는 천장이 5 1일때는 3, 2일때는 4
//		int pair[] = {5, 3, 4, 1, 2, 0};
		int pair[] = {0, 6, 4, 5, 2, 3, 1};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		int max[] = new int[7]; //1~6번쨰 인ㄴ덱스가 바닥일때 현재까지 최대치
		int ceil[] = new int[7]; //현재층의 천장값 저장해두는곳. 1번째에는 가장 아래층이 1번쨰 인덱스에서 시작한것의 현재 천장값
		int[] tttt = new int[7];
		int temp = 0;
		int tmax =0;
		int tidx = 1;
		for (int i = 0; i < ceil.length; i++) {
			ceil[i]= i; 
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < tttt.length; j++) {
				tttt[j]= sc.nextInt(); 
			}
			for (int j = 1; j < ceil.length; j++) {
				tidx = pair[ceil[j]];
				temp = tttt[tidx];//현재층 천장
				for (int j2 = 1; j2 < ceil.length; j2++) {
					if(tttt[j2] == temp || tttt[j2]== ceil[j] ) {
						continue;
					}
					tmax = tmax < tttt[j2]? tttt[j2]: tmax;  
				}
				max[j] += tmax;  
				ceil[j]= tttt[pair[tidx]];
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(max));
		System.out.println(answer);
	}
}
