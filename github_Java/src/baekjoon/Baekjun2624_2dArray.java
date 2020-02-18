package baekjoon;
import java.time.chrono.JapaneseChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjun2624_2dArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		//입력값 넣어두는 배열
		int[][] arr = new int[n+1][n+1];
		int x, y;
		
		for (int i = 0; i < m; i++) {
			int mm = sc.nextInt();
			x = sc.nextInt();
			for (int j = 1; j < mm; j++) {
				y = sc.nextInt();
				arr[x][y]= 1;
				x = y;
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
		boolean flag = true;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		while(flag) {
			//다 돌았는데 배출할 게 없는 경우
			if(cnt >= arr.length) {
//				System.out.println(0);
//				sb = new StringBuilder();
//				sb.append(0);
				list.clear();
				list.add(0);
				break;
			}
			loop:
			for (int i = 1; i < arr.length; i++) {
//				System.out.println("iii " + i);
//				if(sb.toString().contains(Integer.toString(i))) {
//					continue;
//				}
				if(list.contains(i)) {
					continue;
				}
				for (int j = 1; j < arr.length; j++) {
					//앞에 더 있는지 검사.
					if ( arr[j][i] == 1)
					{
						//내 앞에 있으면 다음 열로 넘어감.
						cnt++;
						continue loop;
					}
//					System.out.println(j);
				} 
				//다 돌고 여기 왔으면 해당열에 앞에 칸이 없다는 뜻임.
//				sb.append(String.format("%d%n", i));
				list.add(i);
				//i가 연결된거 다 초기화
				Arrays.fill(arr[i], 0);
				cnt = 0;
//				for (int j = 0; j < arr.length; j++) {
//					System.out.println(Arrays.toString(arr[j]));
//				}
//				System.out.println();
			}
			if(list.size() >= n) {
				break;
			}
		}
		list.stream().forEach(s -> System.out.println(s));
//		System.out.println(list.toString());
//		System.out.println(sb);
	}
}
