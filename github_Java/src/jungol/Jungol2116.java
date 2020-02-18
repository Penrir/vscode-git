package jungol;
import java.util.Scanner;

public class Jungol2116 {
	public static void main(String[] args) {
		//바닥이 0일때는 천장이 5 1일때는 3, 2일때는 4
//		int pair[] = {5, 3, 4, 1, 2, 0};
		int pair[] = {0, 6, 4, 5, 2, 3, 1};
		Scanner sc = new Scanner(System.in);
		int max=0;
		int n = sc.nextInt();
		int ceil;
		int a, b;
		int answer =0;
		int temp=0;
		int[][] arr = new int[n][7];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= 6; j++) {
				arr[i][j]= sc.nextInt(); 
			}
		}
		//각 idx의 값이 바닥면일때 최대값 찾기.
		for (int k = 1; k <= 6; k++) {
			//가장 아래쪽 바닥의 ㄱㅄ
			ceil = arr[0][k];//바닥의 값
//			if(k > 2) {
//				for (int i = 0; i < pair.length; i++) {
//					if(k == pair[i]) {
//						ceil = i;
//						break;
//					}
//				}
//			}else {
//				ceil = pair[k];
//			}//ceil은 전층의 천장
			//n층 쌓는동안
			for (int i = 0; i < n; i++) {
				//받은 천장값을 이용해서 현재층에 그 숫자의 인덱스를 찾아야함.
				temp = findIdx(arr[i], ceil); // temp 에는 현재 이전 천장값고 ㅏ같은 수를 가진 현재층의 인덱스.
				a = arr[i][temp];	//이번층 바닥의값
				b = arr[i][pair[temp]];	//이번층 천장의값
//				System.out.printf("ceil - %d %d %n", a, b);
				temp =0;
				// 주사위 6면 검색해서 이전층 천장 숫자랑 비교해서 제거
				for (int j = 1; j <= 6; j++) {
	//				System.out.println("ijijij" + arr[i][j]);
					if(a == arr[i][j] || b == arr[i][j]) {
						continue;
					}
					temp = temp >= arr[i][j] ? temp : arr[i][j];
				}
//				//제거 된 수 제외하고 가장 큰 수 찾기
//				for (int j = 0; j < 4; j++) {
//					
//				}
//				System.out.println("ttt "+ temp);
				//큰수 찾은거 max에 더하기.
				max += temp;
				ceil = b;
			}
//			System.out.println(max + "-------------------");
			//n층까지 찾았으면 기존의 max와 비교후 큰것으로 교체.
			answer = answer >= max ? answer : max;
			max =0;
		}
		System.out.println(answer);
	}
	
	static int findIdx(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
