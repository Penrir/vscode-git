package algo;

import java.util.Arrays;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

public class Comb {
	public static void main(String args[]) throws Exception {
		int r = 3;
		int n = 5;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		comb(arr, r);

	}

	private static void comb(int[] arr, int target) {
		int len = arr.length;
		for (int i = 1; i <= (1<<len); i++) {
			if(Integer.bitCount(i) == target) {
				print(arr, i);
			}
		}
	}

	private static void print(int[] arr, int check) {
		for (int i = 0; i < arr.length; i++) {
			if( (1<<i & check) != 0) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
	
	private int[] nextPermutation(int[] arr) {

		return arr;
	}
}

