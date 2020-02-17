package swexpert.level3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//�ִ��� ����
//������ó�� �ϵ��ڵ����� ����� ����......
public class SwExpert1244_2 {
	static List<Integer> list = new ArrayList<Integer>();
	static int[] change;
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
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int num = sc.nextInt();
			int cnt = sc.nextInt();
			int digit = digitLength(num);
			
//			change = new int[digit];
//			for (int i = 0; i < digit; i++) {
//				change[i]= i; 
//			}
			int[] arr = new int[digit];
			int temp = digit-1;
			for (int i = 0; i < digit; i++ ) {
				arr[i] = (int) (num / Math.pow(10, temp));
				num = (int) (num % Math.pow(10, temp));
				temp--;
			}
//			System.out.println(Arrays.toString(arr));
			int startidx =0;
			TempClass max = null;
			TempClass min = null;
			while(cnt > 0) {
				if(cnt % 2 == 0 ) {
					if(isSorted(arr)) {
//						System.out.println("cnt --- " + cnt);
						break;
					}
				}
				//���� �ڿ� �ƽ��� ã��
				for (int i = startidx; i < arr.length; i++) {
					if(max == null) {
						max = new TempClass();
						max.idx = i;
						max.num = arr[i];
						max.count = 1;
						continue;
					}
					if(max.num == arr[i]) {
						max.idx = i;
						max.count++;
						continue;
					}
					if(max.num < arr[i]) {
						max.idx = i;
						max.num = arr[i];
						max.count = 1;
						continue;
					}
				}
				//���� �� ���¸� �ƽ��� ����. ���Ͼ����� �ڿ������� �ٲ���.
				if(max == null) {
					swap(arr, new TempClass(arr.length-1,  arr[arr.length-1], 1),
							new TempClass(arr.length-2, arr[arr.length-2], 1));
					cnt--;
					continue;
				}
				//�ƽ��� �ϳ� ���μ��� �׳� ���� ���̶� �ٲٸ��.
				if(max.count == 1) {
					//�ٵ� �ƽ����� ���� �տ� ������ ���� �ε������� �˻��ؾ��ϤӤ�
					if(startidx == max.idx) {
						if(isSorted(arr)) {
							startidx = arr.length;
							max = null;
							swap(arr, new TempClass(arr.length-1,  arr[arr.length-1], 1),
									new TempClass(arr.length-2, arr[arr.length-2], 1));
							cnt--;
							continue;
						}
//						System.out.println("max == start");
						startidx = max.idx + max.count;
						max = null;
						continue;
					}
//					System.out.println("max one");
					swap(arr, max, new TempClass(startidx, arr[startidx], 1));
					startidx++;
					cnt--;
					max = null;
					min = null;
					continue;
				}
				
				//�ƽ��� ���� ���缭 �տ��� ���� ���� �� ã��
				for (int i = startidx; i < Math.min(arr.length, startidx + max.count); i++) {
					if(min == null) {
						min = new TempClass(i, arr[i], 1);
						continue;
					}
					if(min.num > arr[i]) {
						min.idx=i;
						min.num=arr[i];
						min.count =1;
						continue;
					}
				}
				//���ʿ� �ִ��Ŷ� �����. ���� �������� ū���� ���� �ε����� �Ѿ
				if(min.idx == max.idx) {
//					System.out.println("min == max");
					startidx = min.idx + min.count;
					continue;
				}
				
				
				//�� ���� ���� ���̸� �ٲ�
				if(min.idx == startidx) {
//					System.out.println("min == startidx swap");
					swap(arr, max, min);
					startidx++;
					cnt--;
					max = null;
					min = null;
					continue;
				}
//				System.out.println(min);
//				System.out.println(max);
//				System.out.println(Arrays.toString(arr));
//				if(cnt >= 2) {
//					if(isSorted(arr)) {
//						break;
//					}
//				}
				swap(arr, max, min);
//				startidx++;
				cnt--;
				max = null;
				min = null;
			}
					
//			System.out.println(srrStrings[test_case-1]);
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("#%d ", test_case));
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			System.out.printf("%s%n", sb);
//			System.out.println(srrStrings[test_case-1].contentEquals(sb));
//			System.out.println();
			
		}
		
	}
	static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] < arr[i+1] )
				return false;
		}
//		System.out.println("sort");
		
		return true;
	}
	
	static void swap(int[] arr, TempClass a, TempClass b) {
//		System.out.printf("swap idx %d %d value %d %d %n", a.idx, b.idx, a.num, b.num);
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
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
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
		@Override
		public String toString() {
			return "TempClass [idx=" + idx + ", num=" + num + ", count=" + count + "]";
		}
		
	}
	
	static int digitLength(int n ) {
		int cnt = 1;
		for (int i = 10; i <= 100000 ; i*= 10) {
			if(n / i == 0) {
				return cnt;
			}
			cnt++;
		}
		return cnt;
	}	
}
