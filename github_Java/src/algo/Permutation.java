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
import java.util.stream.IntStream;
import java.io.FileInputStream;

public class Permutation {
	public static void main(String args[]) throws Exception {
		
		Integer[] arr = new Integer[]{1, 2, 3};
//		Integer[] arr = new Integer[]{1, 2, 3};
//		Integer[] arr = new Integer[]{1, 2, 3, 4};
//		Integer[] arr = new Integer[]{1, 3, 5, 4 ,2};
//		while(arr != null) {
//			System.out.println(Arrays.toString(arr));
//			arr = nextPermutation(arr);
//		}
		System.out.println(Arrays.toString(arr));
		while(nextPermutation(arr)) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("-------------");
		arr = new Integer[]{0, 0, 0, 1, 1, 1};
		System.out.println(Arrays.toString(arr));
		while(nextPermutation2(arr)) {
			System.out.println(Arrays.toString(arr));
		}
		
	}
	//배열에서 가장 큰수 찾아서 그 앞에자리 숫자를 하나 올리고 위에는 다시 오름차순으로
	private static boolean nextPermutation(Integer[] arr) {
		
		int len = arr.length;
		int i = len -1;
		//꼭대기 찾기
		while(i> 0 && arr[i-1] >= arr[i]) --i;
		
		//가장 앞이 가장 크면 마지막 순열임
		if(i ==0) {
			return false;
		}
		//뒤쪽부터 탐색하여 교환할 큰값 찾기
		int j = len-1;
		while(arr[j] <= arr[i-1]) --j;
		
		swap(arr, i-1, j);
		
		int k = len-1;
		while(i<k) {
			swap(arr, i, k);
			++i;
			--k;
		}
		return true;
	}
	//배열에서 가장 큰수 찾아서 그 앞에자리 숫자를 하나 올리고 위에는 다시 오름차순으로
	private static boolean nextPermutation2(Integer[] arr) {
		int len = arr.length;
		int prev = arr[len-1];
		for (int i = len-2; i >= 0; i--) {
			//꼭대기 앞
			if(arr[i] < prev ) {
				for (int j = len-1; j > i; j--) {
					//꼭대기 앞에 숫자랑 비교해서 더 큰수 찾기
					if(arr[j] > arr[i] ) {
						//찾으면 그 숫자랑 자리 바꿈
						swap(arr, i, j);
						//뒷부분 정렬
						//이미 뒷부분은 오름차순이므로 절반만 바꾸면됨.
						int size = (len - i) / 2;
						for (int k = 1; k <= size; k++) {
							swap(arr, i+k, len-k);
						}
						return true;
					}
				}
			}
			prev = arr[i];
		}
		return false;
	}
//	//배열에서 가장 큰수 찾아서 그 앞에자리 숫자를 하나 올리고 위에는 다시 오름차순으로
//	private static Integer[] nextPermutation(Integer[] arr) {
//		int prev = arr[arr.length-1];
//		for (int i = arr.length-2; i >= 0; i--) {
//			//꼭대기 앞
//			if(arr[i] < prev ) {
//				for (int j = arr.length-1; j > i; j--) {
//					if(arr[j]> arr[i] ) {
//						swap(arr, i, j);
//						//뒷부분 정렬
//						for (int k = i+1; k < i+1 + (((arr.length-(i+1))/2)); k++) {
//							swap(arr, k, arr.length-(k-i));
//						}
//						return arr;
//					}
//				}
//			}
//			prev = arr[i];
//		}
//		return null;
//	}
	
	public static void swap(Integer[]arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b]; 
		arr[b] = temp;
	}
}

