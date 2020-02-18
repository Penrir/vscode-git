package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		Random random = new Random();
		int size = 15;
		int[] arr = new int [size];
		for (int i = 0; i < arr.length; i++) {
			arr[i]= random.nextInt(size*2) + 1 ;
		}
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void quickSort(int[] arr, int left, int right) {
		int s;
//		if(left < right	) {
//			s = partitionHoare(arr, left, right);
//			quickSort(arr, left, s-1);
//			quickSort(arr, s+1, right);
//		}
		if(left < right) {
			s = partitionLomuto(arr, left, right);
			quickSort(arr, left, s-1);
			quickSort(arr, s+1, right);
		}
	}
	//hoare - Partition Algorithm
	private static int partitionHoare(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int pivot = left;
		
		while ( i <= j) {
			//왼쪽에서부터 피봇값보다 큰 것 찾을 때까지 오른쪽으로 옮김.
			while( i <= right && arr[pivot] >= arr[i]) {
				i++;
			}
			//오른쪽부터  작은 수 찾을 떄까지 왼쪽으로
			while( j > left && arr[pivot] <= arr[j]) {
				j--;
			}
			if(i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, left, j);
		
		return j;
	}

	//Lomuto partition Algorithm
	static int partitionLomuto(int[] arr, int left, int right) {
		int x = arr[right];
		int i = left -1;
		
		for (int j = left; j < right; j++) {
			if(arr[j]<= x ) {
				i++;
				swap(arr, j, i);
			}
		}
		swap(arr, i+1, right);
		
		return i+1;
	}
	
	static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
}
