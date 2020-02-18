package baekjoon;

import java.util.Scanner;
//전쟁 땅따먹기
public class Baejoon1270UseBasicArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp;
		int idx = 0;
		//진짜 무식하게 int크기만큼 배열 잡고 돌려버릴예정
		//메모리오버뜸.
		for (int i = 0; i < n; i++) {
			int answer = 0;
			boolean flag = false;
			int t = sc.nextInt();
			int[] arr = new int[(int)Math.pow(2, 31)];
			for (int j = 0; j < t; j++) {
				temp = sc.nextInt();
				arr[temp]++;
			}
			
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]!= 0  && arr[j] > t/2 ){
					flag = true;
					answer = j;
				}
			}
			if(flag)
				System.out.println(answer);
			else {
				System.out.println("SYJKGW");
			}
		}
		sc.close();
	}

}
