package swexpert.level3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import swexpert.level3.SwExpert1244_3.Box;

//최대상금 문제
//_3은 perm 이용해서 만들어보기.
public class SwExpert1244_3 {
	static int answer =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= TC; test_case++) {
			String[] srr = sc.nextLine().split(" ");
			int n = Integer.parseInt(srr[1]);
			int[] arr = new int[srr[0].length()];
			for (int i = 0; i < srr[0].length(); i++) {
				arr[i]= srr[0].charAt(i)-'0'; 
			}
			dfs(arr, 0, n, 0);
			System.out.printf("#%d %d%n", test_case, answer);
			answer = 0;
		}
	}
	//arr은 인풋 받은 배열,,,,dir 은 2차원으로 교환가능한것들 ,,,depth는 dfs횟수 ,,n은 목표교환횟수,,start는 현재까지소팅 완료된번호+1
	public static void dfs(int[] arr, int depth, int n, int start) {
		//모든 교환 완료
		if(depth == n) {
			answer = Math.max(arrToInt(arr), answer);
			return;
		}
		//배열이 정렬된 상태라면 
		if(isSorted(arr)) {
			//교환횟수가 짝수번 남았다면 같은 숫자로 교환 가능하므로 종료.
			if((n - depth) % 2 == 0) {
				answer = Math.max(arrToInt(arr), answer);
				return;
			}
			else {
				//upper2메서드에서 같은 숫자가 두개 이상 존재한다면 몇번 남아있어도 같은수되므로 로직을 끝냄.
				if(upper2(arr)) {
					answer = Math.max(arrToInt(arr), answer);
					return;
				}
				//같은 숫자가 두개이상 존재하지 않으면 가장 뒤쪽 두개 교환하고 끝냄.
				swap(arr, arr.length-1, arr.length-2);
				answer = Math.max(arrToInt(arr), answer);
				return;
			}
		}
		Box max = findMax(arr, start);
		//max가 하나면 가장 앞이랑 바꿈
		if(max.count == 1) {
			//가장 큰수가 가장 앞에 있으면 아무것도 안하고 넘어감. 뒤쪽에서 이후의 모든 경우의수 고려
			if ( max.idx <= start) {}
			else {
				int temp = arr[start];
				arr[start]= max.num;
				arr[max.idx] = temp;
				dfs(arr, depth+1, n, start+1);
				return;
			}
		}
		//max가 같은게 여러개라면
		//교환가능한것 다 해보기
		for (int i = start; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(i == j)
					continue;
				swap(arr, j, i);
				dfs(arr, depth+1, n, start);
				swap(arr, j, i);
			}
		}
	}
	static boolean upper2(int[] arr) {
		int[] list = new int[10];
		for (int i = 0; i < arr.length; i++) {
			list[arr[i]]++;
		}
		for (int i = 0; i < list.length; i++) {
			if(list[i]> 1 )
				return true;
		}
		return false;
	}
	
	static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] < arr[i+1] )
				return false;
		}
		return true;
	}
	
	static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right]; 
		arr[right] = temp; 
	}
	
	private static Box findMax(int[] arr, int start) {
		Box max = new Box(0, 0, 0);
		for (int i = start; i < arr.length; i++) {
			if(max.num < arr[i]) {
				max = new Box(arr[i], 1, i);
				continue;
			}
			if(max.num == arr[i]) {
				max.idx = i;
				max.count++;
			}
		}
		return max;
	}
	public static int arrToInt(int[]arr) {
		int num =0;
		for (int i = 0; i < arr.length; i++) {
			num += Math.pow(10, arr.length-i-1) * arr[i];
		}
		return num;
	}
	
	static class Box{
		private int num;
		private int count;
		private int idx;
		Box(){}
		public Box(int num, int count, int idx) {
			super();
			this.num = num;
			this.count = count;
			this.idx = idx;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		@Override
		public String toString() {
			return "Box [num=" + num + ", count=" + count + ", idx=" + idx + "]";
		}
	}
	
}
/*
최대 6자리수
바꾸는 방법은 15가지 5+4+3+2+1
최대 10번 바꿈. 그럼 15의 10승만큼의 경우의 수가 나옴.

1이 바뀌는 경우는 1 23456
2는 2 13455

맥스값이 가장 앞인 경우들만 다시 검사함. 

1. 6개중에 2개뽑기한 것을 배열로 저장해둠.

2. 저장한 배열 돌아가면서 가장 앞줄이 가장 큰값 된것들만 큐에 넣는다.

3. 조합한것중에 1들어간거 다 제거.

4.시작 인덱스를 하나 올린다.

5. 배열 돌면서 바꿔본다.
6. 가장 앞줄 큰값들만 저장한다.
7. 조합한것중에 시작인덱스 들어간거 지운다.
8. 교환횟수 0될때까지 5~7반복.
*/