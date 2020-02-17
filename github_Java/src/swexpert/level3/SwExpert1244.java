package swexpert.level3;

import java.util.Arrays;
import java.util.Scanner;

//최대상금 문제
public class SwExpert1244 {
	static String[] srrStrings = {"#1 321",
		"#2 7732",
		"#3 857147",
		"#4 87664",
		"#5 88832",
		"#6 777770",
		"#7 966354",
		"#8 954311",
		"#9 332211",
		"#10 987645"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= TC; test_case++) {
//			Integer num = sc.nextInt();
//			int cnt = sc.nextInt();
			int num;
			int cnt;
			String[] temp = sc.nextLine().split(" ");
			num = Integer.parseInt(temp[0]);
			cnt = Integer.parseInt(temp[1]);
			int[]arr = new int[temp[0].length()];
			int startidx = 0;
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(temp[0].charAt(i) + "");
			}
			loop:
			while ( cnt > 0) {
				if(isSorted(arr)) {
					if(cnt % 2 == 0) {
						break;
					}
					//연속된 같은 숫자 있는지 체크하면 될듯.
					for (int i = startidx; i < arr.length-1; i++) {
						if(arr[i] == arr[i+1]) {
							cnt = 0;
							break loop;
						}
					}
					 //소팅된 상태에서 홀수번 들어오면 깨질 수 있으니 보완하는 조건문
//					startidx = arr.length;
					cnt =1;
					swap(arr, new TempClass(arr.length-1,  arr[arr.length-1], 1),
							new TempClass(arr.length-2, arr[arr.length-2], 1));
					cnt--;
					continue;
				}
				TempClass max = findMax(arr, startidx);
				if(max.idx == startidx) {
					startidx++;
					continue;
				}
				if(max.count == 1) {
					swap(arr, new TempClass(startidx, arr[startidx], 1), max);
					startidx++;
					cnt--;
					continue;
				}
				//max가 여러개면
				TempClass min = findMin(arr, startidx, startidx + max.count); //범위는 startidx ~ startidx+max.count
				swap(arr, min, max);
				cnt--;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("#%d ", test_case));
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		}
	}

	private static TempClass findMin(int[] arr, int start, int end) {
		TempClass min = new TempClass(start, arr[start], 1);
		for (int i = start+1; i < end; i++) {
			if(min.num > arr[i]) {
				min.num = arr[i];
				min.idx = i;
				min.count = 1;
			}
		}
		return min;
	}
	private static TempClass findMax(int[] arr, int start) {
		TempClass max = new TempClass(start, arr[start], 1);
		for (int i = start; i < arr.length; i++) {
			if(max.num < arr[i]) {
				max.num = arr[i];
				max.idx = i;
				max.count = 1;
				continue;
			}
			if(max.num == arr[i]) {
				max.idx = i;
				max.count++;
			}
		}
		return max;
	}
	static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] < arr[i+1] )
				return false;
		}
		return true;
	}
	static void swap(int[] arr, TempClass a, TempClass b) {
		int temp = arr[a.idx];
		arr[a.idx] = arr[b.idx];
		arr[b.idx]= temp; 
	}
	
	static class TempClass{
		int idx;
		int num;
		int count;
		public TempClass() {
			// TODO Auto-generated constructor stub
		}
		public TempClass(int idx, int num, int count) {
			super();
			this.idx = idx;
			this.num = num;
			this.count = count;
		}	
	}
}
