package baekjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjun2623 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		//입력값 넣어두는 배열
		int[][] arr = new int[m][];
		
		for (int i = 0; i < arr.length; i++) {
			int mm = sc.nextInt();
			arr[i] = new int[mm];
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt(); 
			}
		}
		
		int[][] list = new int[n+1][n+1];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length-1 ; j > 0 ; j--) {
				for (int j2 = j-1; j2 >= 0; j2--) {
					list[arr[i][j]][++list[arr[i][j]][0]] = arr[i][j2];
					
				}
			}
		}
//		for (int i = 0; i < list.length; i++) {
//			System.out.println(Arrays.toString(list[i]));
//		}
		boolean flag = true;
		while(flag) {
			//앞에 아무것도 없는 숫자 출력
			for (int i = 1; i < list.length; i++) {
				if (list[i][0] == 0) {
					System.out.println(i);
					list[i][0] = -1;
					//출력 한숫자들 찾아서 제거하기
					for (int j = 0; j < list.length; j++) {
						for (int j2 = 1; j2 < list[j].length; j2++) {
							if(i == list[j][j2]) {
								list[j][0]--;
								list[j][j2]= 0; 
							}
						}
					}
//					for (int j = 0; j < list.length; j++) {
//						System.out.println(Arrays.toString(list[j]));
//					}
//					System.out.println();
				}
			}
			flag = false;
			for (int i = 1; i < list.length; i++) {
				if(list[i][0] != -1) {
					flag = true;
					break;
				}
			}
		}
		
		
	}
}
