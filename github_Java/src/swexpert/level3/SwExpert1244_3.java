package swexpert.level3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import swexpert.level3.SwExpert1244_3.Box;

//�ִ��� ����
//_3�� perm �̿��ؼ� ������.
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
	//arr�� ��ǲ ���� �迭,,,,dir �� 2�������� ��ȯ�����Ѱ͵� ,,,depth�� dfsȽ�� ,,n�� ��ǥ��ȯȽ��,,start�� ����������� �Ϸ�ȹ�ȣ+1
	public static void dfs(int[] arr, int depth, int n, int start) {
		//��� ��ȯ �Ϸ�
		if(depth == n) {
			answer = Math.max(arrToInt(arr), answer);
			return;
		}
		//�迭�� ���ĵ� ���¶�� 
		if(isSorted(arr)) {
			//��ȯȽ���� ¦���� ���Ҵٸ� ���� ���ڷ� ��ȯ �����ϹǷ� ����.
			if((n - depth) % 2 == 0) {
				answer = Math.max(arrToInt(arr), answer);
				return;
			}
			else {
				//upper2�޼��忡�� ���� ���ڰ� �ΰ� �̻� �����Ѵٸ� ��� �����־ �������ǹǷ� ������ ����.
				if(upper2(arr)) {
					answer = Math.max(arrToInt(arr), answer);
					return;
				}
				//���� ���ڰ� �ΰ��̻� �������� ������ ���� ���� �ΰ� ��ȯ�ϰ� ����.
				swap(arr, arr.length-1, arr.length-2);
				answer = Math.max(arrToInt(arr), answer);
				return;
			}
		}
		Box max = findMax(arr, start);
		//max�� �ϳ��� ���� ���̶� �ٲ�
		if(max.count == 1) {
			//���� ū���� ���� �տ� ������ �ƹ��͵� ���ϰ� �Ѿ. ���ʿ��� ������ ��� ����Ǽ� ���
			if ( max.idx <= start) {}
			else {
				int temp = arr[start];
				arr[start]= max.num;
				arr[max.idx] = temp;
				dfs(arr, depth+1, n, start+1);
				return;
			}
		}
		//max�� ������ ���������
		//��ȯ�����Ѱ� �� �غ���
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
�ִ� 6�ڸ���
�ٲٴ� ����� 15���� 5+4+3+2+1
�ִ� 10�� �ٲ�. �׷� 15�� 10�¸�ŭ�� ����� ���� ����.

1�� �ٲ�� ���� 1 23456
2�� 2 13455

�ƽ����� ���� ���� ���鸸 �ٽ� �˻���. 

1. 6���߿� 2���̱��� ���� �迭�� �����ص�.

2. ������ �迭 ���ư��鼭 ���� ������ ���� ū�� �Ȱ͵鸸 ť�� �ִ´�.

3. �����Ѱ��߿� 1���� �� ����.

4.���� �ε����� �ϳ� �ø���.

5. �迭 ���鼭 �ٲ㺻��.
6. ���� ���� ū���鸸 �����Ѵ�.
7. �����Ѱ��߿� �����ε��� ���� �����.
8. ��ȯȽ�� 0�ɶ����� 5~7�ݺ�.
*/